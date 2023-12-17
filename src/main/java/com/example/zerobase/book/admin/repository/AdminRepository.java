package com.example.zerobase.book.admin.repository;

import com.example.zerobase.book.admin.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Shop,Long> {

    Optional<Shop> findByShopName(String shopName);

}
