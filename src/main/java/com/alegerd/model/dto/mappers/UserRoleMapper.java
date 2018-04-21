package com.alegerd.model.dto.mappers;

import com.alegerd.model.User;
import com.alegerd.model.UserRole;
import com.alegerd.model.dto.UserDTO;
import com.alegerd.model.dto.UserRoleDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserRoleMapper {
    UserRoleDTO toDto(UserRole entity);
    UserRole toEntity(UserRoleDTO dto);
}
