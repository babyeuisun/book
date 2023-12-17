package com.example.zerobase.book.admin.controller;

import com.example.zerobase.book.admin.model.ServiceResult;
import com.example.zerobase.book.admin.model.ShopInfo;
import com.example.zerobase.book.admin.service.AdminService;
import com.example.zerobase.book.common.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
public class AdminController {

    private final AdminService adminService;
    @PostMapping("/api/admin/shop")
    public ResponseEntity<?> shopInfo(@RequestBody ShopInfo shopInfo){

        ServiceResult result = adminService.addShop(shopInfo);
        if (!result.isResult()) {
            return ResponseResult.fail(result.getMessage());
        }
        return ResponseResult.result(result);

    }

    }

