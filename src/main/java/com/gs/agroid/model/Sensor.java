package com.gs.agroid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_SENSOR")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_sensor", discriminatorType = DiscriminatorType.STRING)
public abstract class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sensor")
    @SequenceGenerator(name = "seq_sensor", sequenceName = "SEQ_SENSOR", allocationSize = 1)
    @Column(name = "id_sensor")
    private Long id;

    @Column(name = "modelo", nullable = false, length = 100)
    private String modelo;

    @Column(name = "status", nullable = false, length = 20)
    private String status; // ATIVO, INATIVO

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_propriedade", nullable = false)
    private Propriedade propriedade;

    public Sensor() {}

    public Sensor(Long id, String modelo, String status, Propriedade propriedade) {
        this.id = id;
        this.modelo = modelo;
        this.status = status;
        this.propriedade = propriedade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    @Transient
    public abstract String getTipoSensor();
}
