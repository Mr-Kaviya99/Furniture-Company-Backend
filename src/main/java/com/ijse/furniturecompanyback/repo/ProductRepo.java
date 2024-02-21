package com.ijse.furniturecompanyback.repo;

import com.ijse.furniturecompanyback.enitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product,String> {
    @Query(value = "SELECT product_id FROM product WHERE product_id like ?% ORDER BY CAST(SUBSTRING(product_id,?) AS UNSIGNED) DESC LIMIT 1", nativeQuery = true)
    String findLastId(String s, int i);
    @Query(value = "SELECT * FROM product WHERE product.category_id=?1", nativeQuery = true)
    List<Product> findByCategoryId(String categoryId);
}
