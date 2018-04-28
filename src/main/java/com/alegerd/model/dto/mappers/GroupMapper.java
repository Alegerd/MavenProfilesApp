package com.alegerd.model.dto.mappers;

import com.alegerd.model.GroupEntity;
import com.alegerd.model.dto.GroupDTO;
import org.mapstruct.Mapper;

@Mapper
public interface GroupMapper {
    GroupDTO toDto(GroupEntity entity);
    GroupEntity toEntity(GroupDTO dto);
}
