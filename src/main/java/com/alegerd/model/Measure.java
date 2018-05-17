package com.alegerd.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "measure")
public class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="router_id")
    private String routerId;

    @Column(name="volume")
    private Double volume;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="volume_vector_id", nullable = false)
    private VolumeVector volumeVector;

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

    public VolumeVector getVolumeVector() {
        return volumeVector;
    }

    public void setVolumeVector(VolumeVector volumeVector) {
        this.volumeVector = volumeVector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measure that = (Measure) o;
        return id == that.id
                && Objects.equals(routerId, that.routerId)
                && Objects.equals(volume, that.volume)
                && Objects.equals(volumeVector, that.volumeVector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routerId, volumeVector, volume);
    }
}
