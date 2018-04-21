package com.alegerd.model.dto.mappers;

import com.alegerd.model.Room;
import com.alegerd.model.Subject;
import com.alegerd.model.dto.RoomDTO;
import com.alegerd.model.dto.SubjectDTO;
import org.mapstruct.Mapper;

@Mapper
public interface SubjectMapper {
    SubjectDTO toDto(Subject entity);
    Subject toEntity(SubjectDTO dto);
}
