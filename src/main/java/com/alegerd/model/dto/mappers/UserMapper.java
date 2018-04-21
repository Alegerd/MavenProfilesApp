package com.alegerd.model.dto.mappers;

import com.alegerd.model.StudyClass;
import com.alegerd.model.User;
import com.alegerd.model.dto.StudyClassDTO;
import com.alegerd.model.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO toDto(User entity);
    User toEntity(UserDTO dto);
}
