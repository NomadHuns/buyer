package shop.mtcoding.buyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import shop.mtcoding.buyer.model.Product;
import shop.mtcoding.buyer.model.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping({ "/", "/product" })
    public String home(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, Model model){
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product/detail";
    }
}
