package com.alegerd.service;

import com.alegerd.dao.VolumeVectorDao;
import com.alegerd.model.Measure;
import com.alegerd.model.VolumeVector;
import com.alegerd.model.dto.MeasureDTO;
import com.alegerd.model.dto.RoomDTO;
import com.alegerd.model.dto.VolumeVectorDTO;
import com.alegerd.model.dto.mappers.VolumeVectorMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class VolumeVectorService {

    @Autowired
    private VolumeVectorDao dao;
    private VolumeVectorMapper mapper;
    @Autowired
    private RoomService roomService;

    private List<String> permittedRouters;

    public VolumeVectorService() {
        this.mapper = Mappers.getMapper(VolumeVectorMapper.class);
        permittedRouters = new ArrayList<>();
        permittedRouters.add("e4:18:6b:3a:53:dc");
        permittedRouters.add("84:16:f9:2f:b9:98");
        permittedRouters.add("e4:18:6b:0e:2a:c4");
    }

    public void setDao(VolumeVectorDao dao) {
        this.dao = dao;
    }

    @Transactional
    public VolumeVectorDTO getClosestMatch(VolumeVectorDTO volumeVectorDTO) {
        List<VolumeVector> presets = dao.getAll();

        double minDifference = 0;
        VolumeVectorDTO closestMatch = null;

        for (VolumeVector preset : presets) {
            VolumeVectorDTO presetDTO = mapper.toDto(preset);
            VolumeVectorDTO differenceVector = substractVectors(volumeVectorDTO, presetDTO);
            if (differenceVector.getMeasures().size() > 0) {
                double difference = getVectorLength(differenceVector);
                if (difference < minDifference || closestMatch == null) {
                    minDifference = difference;
                    closestMatch = presetDTO;
                }
            }
        }

        return closestMatch;
    }

    @Transactional
    public void saveMeasures(VolumeVectorDTO volumeVectorDTO, String room) throws Exception {
        RoomDTO roomDTO = roomService.getRoomByName(room);
        if (roomDTO != null) {
            volumeVectorDTO.setRoom(roomDTO);
            java.util.Date utilDate = new java.util.Date();
            volumeVectorDTO.setDate(new Date(utilDate.getTime()));
            VolumeVector volumeVector = mapper.toEntity(volumeVectorDTO);
            for (Measure measure : volumeVector.getMeasures()) {
                measure.setVolumeVector(volumeVector);
            }
            dao.create(volumeVector);
        } else throw new Exception("No such room");
    }

    private VolumeVectorDTO substractVectors(VolumeVectorDTO v1, VolumeVectorDTO v2) {
        VolumeVectorDTO result = new VolumeVectorDTO();
        List<MeasureDTO> measures = new ArrayList<>();

        for (MeasureDTO m1 : v1.getMeasures()) {
            //if (permittedRouters.contains(m1.getRouterId())) {
                for (MeasureDTO m2 : v2.getMeasures()) {
                    if (m1.getRouterId().equals(m2.getRouterId())) {
                        MeasureDTO measureDTO = new MeasureDTO();
                        measureDTO.setRouterId(m1.getRouterId());
                        measureDTO.setVolume(m1.getVolume() - m2.getVolume());
                        measures.add(measureDTO);
                    }
                }
            //}
        }
        result.setMeasures(measures);

        return result;
    }

    private Double getVectorLength(VolumeVectorDTO volumeVectorDTO) {
        double result = 0;
        for (MeasureDTO measureDTO : volumeVectorDTO.getMeasures()) {
            result += Math.pow(measureDTO.getVolume(), 2);
        }
        result = Math.sqrt(result);
        return result;
    }
}
