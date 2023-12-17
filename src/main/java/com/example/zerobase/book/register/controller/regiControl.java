package com.example.zerobase.book.register.controller;

import com.example.zerobase.book.admin.model.ServiceResult;
import com.example.zerobase.book.common.ResponseResult;
import com.example.zerobase.book.register.entity.RegiEntity;
import com.example.zerobase.book.register.model.RegiInput;

import com.example.zerobase.book.register.repository.RegisterRepository;
import com.example.zerobase.book.register.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class regiControl {
    private final RegisterService registerService;
    @PostMapping("/api/register")
    public ResponseEntity<?> addUser(@RequestBody @Valid RegiInput regiInput,Errors errors){
        if (errors.hasErrors()){
            ResponseResult.fail("입력값이 정확하지 않습니다");
        }
        ServiceResult result = registerService.addUser(regiInput);
        if(!result.isResult()){
            return ResponseResult.fail(result.getMessage());
        }
        return ResponseResult.success();



    }

}
