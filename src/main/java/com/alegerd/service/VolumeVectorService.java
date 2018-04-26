package com.alegerd.service;

import com.alegerd.dao.VolumeVectorDao;
import com.alegerd.model.VolumeVector;
import com.alegerd.model.dto.MeasureDTO;
import com.alegerd.model.dto.VolumeVectorDTO;
import com.alegerd.model.dto.mappers.VolumeVectorMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolumeVectorService {

    @Autowired
    private VolumeVectorDao dao;

    private VolumeVectorMapper mapper;

    public void setDao(VolumeVectorDao dao) {
        this.dao = dao;
    }

    public VolumeVectorDTO getClosestMatch(VolumeVectorDTO volumeVectorDTO) {
        List<VolumeVector> presets = dao.getAll();

        double minDifference = 0;
        VolumeVectorDTO closestMatch = null;

        for (VolumeVector preset : presets) {
            VolumeVectorDTO presetDTO = mapper.toDto(preset);
            VolumeVectorDTO differenceVector = substractVectors(volumeVectorDTO, presetDTO);
            if (differenceVector.getMeasures().size() > 0) {
                double difference = getVectorLength(differenceVector);
                if (difference < minDifference || closestMatch == null){
                    minDifference=difference;
                    closestMatch=presetDTO;
                }
            }
        }

        return closestMatch;
    }

    private VolumeVectorDTO substractVectors(VolumeVectorDTO v1, VolumeVectorDTO v2) {
        VolumeVectorDTO result = new VolumeVectorDTO();
        List<MeasureDTO> measures = new ArrayList<>();

        for (MeasureDTO m1 : v1.getMeasures()) {
            for (MeasureDTO m2 : v2.getMeasures()) {
                if (m1.getRouterId().equals(m2.getRouterId())) {
                    MeasureDTO measureDTO = new MeasureDTO();
                    measureDTO.setRouterId(m1.getRouterId());
                    measureDTO.setVolume(m1.getVolume() - m2.getVolume());
                    measures.add(measureDTO);
                }
            }
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

    public VolumeVectorService() {
        this.mapper = Mappers.getMapper(VolumeVectorMapper.class);
    }
}
