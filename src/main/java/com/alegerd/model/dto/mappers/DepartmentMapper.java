package com.alegerd.model.dto.mappers;

import com.alegerd.model.CheckIn;
import com.alegerd.model.Department;
import com.alegerd.model.dto.CheckInDTO;
import com.alegerd.model.dto.DepartmentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {
    DepartmentDTO toDto(Department entity);
    Department toEntity(DepartmentDTO dto);
}
