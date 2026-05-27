package com.gs.agroid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_LEITURA")
public class Leitura {

    @EmbeddedId
    private LeituraId id;

    @MapsId("sensorId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sensor", insertable = false, updatable = false)
    private Sensor sensor;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private Double valor;

    public Leitura() {}

    public Leitura(LeituraId id, Sensor sensor, Double valor) {
        this.id = id;
        this.sensor = sensor;
        this.valor = valor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private LeituraId id;
        private Sensor sensor;
        private Double valor;

        public Builder id(LeituraId id) {
            this.id = id;
            return this;
        }

        public Builder sensor(Sensor sensor) {
            this.sensor = sensor;
            return this;
        }

        public Builder valor(Double valor) {
            this.valor = valor;
            return this;
        }

        public Leitura build() {
            return new Leitura(id, sensor, valor);
        }
    }

    public LeituraId getId() {
        return id;
    }

    public void setId(LeituraId id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
