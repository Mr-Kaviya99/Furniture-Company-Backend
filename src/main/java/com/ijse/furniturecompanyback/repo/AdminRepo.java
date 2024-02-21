package com.ijse.furniturecompanyback.repo;

import com.ijse.furniturecompanyback.enitiy.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AdminRepo  extends JpaRepository<Admin,String> {
    @Query(value = "SELECT admin_id FROM admin WHERE admin_id like ?% ORDER BY CAST(SUBSTRING(admin_id,?) AS UNSIGNED) DESC LIMIT 1", nativeQuery = true)
    String findLastId(String s, int i);
    @Query(value = "SELECT * FROM admin WHERE email=?1 AND password=?2 ", nativeQuery = true)
    Admin findByEmailAAndPassword(String email,String password);
}
