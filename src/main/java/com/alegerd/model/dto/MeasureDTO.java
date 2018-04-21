package com.alegerd.model.dto;

import com.alegerd.model.Measure;

public class MeasureDTO {
    private Long id;
    private String routerId;
    private Double volume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouterId() {
        return routerId;
    }

    public void setRouterId(String routerId) {
        this.routerId = routerId;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public MeasureDTO(){

    }

    public MeasureDTO(Long id, String routerId, Double volume) {
        this.id = id;
        this.routerId = routerId;
        this.volume = volume;
    }
}
