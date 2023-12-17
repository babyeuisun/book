package com.example.zerobase.book.register.repository;

import com.example.zerobase.book.register.entity.RegiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<RegiEntity,Long> {
    Optional<RegiEntity> findByUserName(String userName);
}
