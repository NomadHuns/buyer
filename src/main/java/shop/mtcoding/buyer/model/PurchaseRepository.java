package shop.mtcoding.buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PurchaseRepository {
    public List<Purchase> findById(int id);

    public List<Purchase> findByUserId(int userId);

    public int insert(@Param("userId") int userId, @Param("productId") int productId, @Param("productCount") int count);
}
