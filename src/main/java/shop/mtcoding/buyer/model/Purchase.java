package shop.mtcoding.buyer.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/*
 * create table purchase_tb(
   id int auto_increment primary key,
   user_id int,
   product_id int,
   created_at timestamp,
   constraint fk_user foreign key(user_id) references user_tb(id),
   constraint fk_product foreign key(product_id) references product_tb(id)
   );
 */

@Getter
@Setter
public class Purchase {
  private Integer id;
  private Integer userId;
  private Integer productId;
  private Integer productCount;
  private Timestamp createdAt;
}
