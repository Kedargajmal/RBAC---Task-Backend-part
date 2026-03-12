package com.employee.system.service.impl;

import com.employee.system.dto.AuthResponse;
import com.employee.system.dto.LoginRequest;
import com.employee.system.dto.RegisterRequest;
import com.employee.system.entity.User;
import com.employee.system.mapper.UserMapper;
import com.employee.system.repository.UserRepository;
import com.employee.system.security.JwtService;
import com.employee.system.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserMapper userMapper;

    @Override
    public void register(RegisterRequest request)
    {
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
    }

    @Override
    public AuthResponse login(LoginRequest request)
    {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword()))
        {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.createToken(user);
        return new AuthResponse(token, user.getRole().name());
    }
}