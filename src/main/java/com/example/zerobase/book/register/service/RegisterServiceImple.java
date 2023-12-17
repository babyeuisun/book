package com.example.zerobase.book.register.service;

import com.example.zerobase.book.admin.model.ServiceResult;
import com.example.zerobase.book.register.entity.RegiEntity;
import com.example.zerobase.book.register.model.RegiInput;
import com.example.zerobase.book.register.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterServiceImple implements RegisterService{
    private final RegisterRepository registerRepository;
    @Override
    public ServiceResult addUser(RegiInput regiInput) {
        Optional<RegiEntity> optionalRegi = registerRepository.findByUserName(regiInput.getUserName());
        if(optionalRegi.isPresent()){
            return ServiceResult.fail("이미 가입된 계정이 있습니다");
        }
        RegiEntity regiEntity = RegiEntity.builder()
                .userName(regiInput.getUserName())
                .email(regiInput.getEmail())
                .phone(regiInput.getPhone())
                .password(regiInput.getPassword())
                .build();
        registerRepository.save(regiEntity);
        return ServiceResult.success();
    }
}
