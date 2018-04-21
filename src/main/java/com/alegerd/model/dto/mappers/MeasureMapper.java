package com.alegerd.model.dto.mappers;

import com.alegerd.model.Group;
import com.alegerd.model.Measure;
import com.alegerd.model.dto.GroupDTO;
import com.alegerd.model.dto.MeasureDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MeasureMapper {
    MeasureDTO toDto(Measure entity);
    Measure toEntity(MeasureDTO dto);
}
