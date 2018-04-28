package com.alegerd.model.dto.mappers;

import com.alegerd.model.StudyClass;
import com.alegerd.model.dto.StudyClassDTO;
import org.mapstruct.Mapper;

@Mapper
public interface StudyClassMapper {
    StudyClassDTO toDto(StudyClass entity);
    StudyClass toEntity(StudyClassDTO dto);
}
