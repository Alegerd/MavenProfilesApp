package com.alegerd.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

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
    private Collection<Measure> measures;

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

    public Collection<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(Collection<Measure> measures) {
        this.measures = measures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VolumeVector that = (VolumeVector) o;
        return id == that.id
                && Objects.equals(room, that.room)
                && Objects.equals(date, that.date)
                && Objects.equals(measures, that.measures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, room, date, measures);
    }
}
