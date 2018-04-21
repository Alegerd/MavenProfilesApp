package com.alegerd.model.dto.mappers;

import com.alegerd.model.Measure;
import com.alegerd.model.Room;
import com.alegerd.model.dto.MeasureDTO;
import com.alegerd.model.dto.RoomDTO;
import org.mapstruct.Mapper;

@Mapper
public interface RoomMapper {
    RoomDTO toDto(Room entity);
    Room toEntity(RoomDTO dto);
}
