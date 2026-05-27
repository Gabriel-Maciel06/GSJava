package com.gs.agroid.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("UMIDADE")
public class SensorUmidade extends Sensor {

    public SensorUmidade() {}

    public SensorUmidade(Long id, String modelo, String status, Propriedade propriedade) {
        super(id, modelo, status, propriedade);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String modelo;
        private String status;
        private Propriedade propriedade;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder modelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder propriedade(Propriedade propriedade) {
            this.propriedade = propriedade;
            return this;
        }

        public SensorUmidade build() {
            return new SensorUmidade(id, modelo, status, propriedade);
        }
    }

    @Override
    public String getTipoSensor() {
        return "UMIDADE";
    }
}
