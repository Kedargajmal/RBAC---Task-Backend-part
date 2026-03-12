package com.employee.system.service;

import com.employee.system.dto.AuthResponse;
import com.employee.system.dto.LoginRequest;
import com.employee.system.dto.RegisterRequest;

public interface AuthService
{
    void register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
