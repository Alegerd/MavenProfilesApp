package com.alegerd.model.dto.mappers;

import com.alegerd.model.User;
import com.alegerd.model.VolumeVector;
import com.alegerd.model.dto.UserDTO;
import com.alegerd.model.dto.VolumeVectorDTO;
import org.mapstruct.Mapper;

@Mapper
public interface VolumeVectorMapper {
    VolumeVectorDTO toDto(VolumeVector entity);
    VolumeVector toEntity(VolumeVectorDTO dto);
}
