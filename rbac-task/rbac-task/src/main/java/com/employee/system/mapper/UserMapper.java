package com.employee.system.mapper;

import com.employee.system.dto.RegisterRequest;
import com.employee.system.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(RegisterRequest request);

}