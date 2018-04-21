package com.alegerd.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "volume_vector")
public class VolumeVector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="room")
    private Room room;

    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "volumeVector")
    private Iterable<Measure> measures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Iterable<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(Iterable<Measure> measures) {
        this.measures = measures;
    }
}
