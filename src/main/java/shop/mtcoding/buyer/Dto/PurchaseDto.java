package shop.mtcoding.buyer.Dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.buyer.model.Product;
import shop.mtcoding.buyer.model.User;

@Getter
@Setter
public class PurchaseDto {
    private Integer id;
    private User user;
    private Product product;
    private Integer productCount;
    private Timestamp createdAt;

    public PurchaseDto(Integer id, User user, Product product, Integer productCount, Timestamp createdAt) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.productCount = productCount;
        this.createdAt = createdAt;
    }
    
}
