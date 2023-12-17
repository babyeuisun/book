package com.example.zerobase.book.admin.service;

import com.example.zerobase.book.admin.entity.Shop;
import com.example.zerobase.book.admin.model.ServiceResult;
import com.example.zerobase.book.admin.model.ShopInfo;
import com.example.zerobase.book.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public ServiceResult addShop(ShopInfo shopInfo) {
        Optional<Shop> optionalShop = adminRepository.findByShopName(shopInfo.getShopName());
        if(optionalShop.isPresent()){
           return ServiceResult.fail("등록된 매장 정보가 존재합니다.");
        }

        Shop shop = Shop.builder()
                .shopName(shopInfo.getShopName())
                .shopPosition(shopInfo.getShopPosition())
                .description(shopInfo.getDescription())
                .build();
        adminRepository.save(shop);
        return ServiceResult.success();
    }
}
