package com.example.zerobase.book.register.service;

import com.example.zerobase.book.admin.model.ServiceResult;
import com.example.zerobase.book.register.model.RegiInput;

public interface RegisterService {
    ServiceResult addUser(RegiInput regiInput);
}
