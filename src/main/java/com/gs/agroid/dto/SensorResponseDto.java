package com.gs.agroid.dto;

public class SensorResponseDto {
    private Long id;
    private String tipoSensor;
    private String modelo;
    private String status;
    private Long propriedadeId;

    public SensorResponseDto() {}

    public SensorResponseDto(Long id, String tipoSensor, String modelo, String status, Long propriedadeId) {
        this.id = id;
        this.tipoSensor = tipoSensor;
        this.modelo = modelo;
        this.status = status;
        this.propriedadeId = propriedadeId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String tipoSensor;
        private String modelo;
        private String status;
        private Long propriedadeId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder tipoSensor(String tipoSensor) {
            this.tipoSensor = tipoSensor;
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

        public Builder propriedadeId(Long propriedadeId) {
            this.propriedadeId = propriedadeId;
            return this;
        }

        public SensorResponseDto build() {
            return new SensorResponseDto(id, tipoSensor, modelo, status, propriedadeId);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
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

    public Long getPropriedadeId() {
        return propriedadeId;
    }

    public void setPropriedadeId(Long propriedadeId) {
        this.propriedadeId = propriedadeId;
    }
}
