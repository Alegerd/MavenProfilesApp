package com.alegerd.model;

import javax.persistence.*;

@Entity
@Table(name = "measure")
public class Measure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="routerId")
    private String routerId;

    @Column(name="volume")
    private Double volume;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="volume_vector_id")
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
}
