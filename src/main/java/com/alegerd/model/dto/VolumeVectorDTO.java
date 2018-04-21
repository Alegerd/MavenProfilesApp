package com.alegerd.model.dto;

import java.sql.Date;
import java.util.Collection;

public class VolumeVectorDTO {
    private Long id;
    private String room;
    private Date date;
    private Collection<MeasureDTO> measures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<MeasureDTO> getMeasures() {
        return measures;
    }

    public void setMeasures(Collection<MeasureDTO> measures) {
        this.measures = measures;
    }
}
