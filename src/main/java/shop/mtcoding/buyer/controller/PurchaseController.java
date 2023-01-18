package shop.mtcoding.buyer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer.Dto.PurchaseDto;
import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.Purchase;
import shop.mtcoding.buyer.model.PurchaseRepository;
import shop.mtcoding.buyer.model.User;
import shop.mtcoding.buyer.model.UserRepository;

@Controller
public class PurchaseController {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HttpSession session;

    @PostMapping("/product/{id}/purchase")
    public String purchase(@PathVariable int id, int count) {
        if (session.getAttribute("principal") == null) {
            return "redirect:/loginForm";
        } else {
            int result = productRepository.updateById(id, count);
            if (result == 1) {
                User user = (User) session.getAttribute("principal");
                purchaseRepository.insert(user.getId(), id, count);
                return "redirect:/product/{id}";
            } else {
                return "redirect:/product/{id}";
            }
        }
    }

    @GetMapping("/purchase")
    public String purchaseList(Model model) {
        User user = (User) session.getAttribute("principal");
        List<Purchase> purchaseList = purchaseRepository.findByUserId(user.getId());
        List<PurchaseDto> purchaseDtos = new ArrayList<>();
        for (Purchase purchase : purchaseList) {
            PurchaseDto purchaseDto = new PurchaseDto(purchase.getId(), user,
                    productRepository.findById(purchase.getProductId()), purchase.getProductCount(),
                    purchase.getCreatedAt());
            purchaseDtos.add(purchaseDto);
        }
        model.addAttribute("purchaseDtoList", purchaseDtos);
        return "user/purchaseList";
    }
}
