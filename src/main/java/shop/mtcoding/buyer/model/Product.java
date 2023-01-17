package shop.mtcoding.buyer.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/*
 * create table product_tb(
    id int auto_increment primary key,
    name varchar not null unique,
    price int not null,
    qty int not null,
    created_at timestamp
    );
 */

@Getter
@Setter
public class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
    private Timestamp createdAt;
}
