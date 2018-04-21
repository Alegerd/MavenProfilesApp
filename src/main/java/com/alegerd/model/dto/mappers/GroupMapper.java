package com.alegerd.model.dto.mappers;

import com.alegerd.model.CheckIn;
import com.alegerd.model.Group;
import com.alegerd.model.dto.CheckInDTO;
import com.alegerd.model.dto.GroupDTO;
import org.mapstruct.Mapper;

@Mapper
public interface GroupMapper {
    GroupDTO toDto(Group entity);
    Group toEntity(GroupDTO dto);
}
