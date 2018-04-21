package com.alegerd.model.dto;

import com.alegerd.model.VolumeVector;

import java.sql.Date;
import java.util.Collection;

public class VolumeVectorDTO {
    private Long id;
    private RoomDTO room;
    private Date date;
    private Collection<MeasureDTO> measures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
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

    public VolumeVectorDTO(){

    }

    public VolumeVectorDTO(Long id, RoomDTO room, Date date, Collection<MeasureDTO> measures) {
        this.id = id;
        this.room = room;
        this.date = date;
        this.measures = measures;
    }
}
