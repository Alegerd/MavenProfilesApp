package com.alegerd.model.dto.mappers;

import com.alegerd.model.CheckIn;
import com.alegerd.model.VolumeVector;
import com.alegerd.model.dto.CheckInDTO;
import com.alegerd.model.dto.VolumeVectorDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CheckInMapper {
    CheckInDTO toDto(CheckIn entity);
    CheckIn toEntity(CheckInDTO dto);
}
