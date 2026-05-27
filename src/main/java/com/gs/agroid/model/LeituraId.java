package com.gs.agroid.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class LeituraId implements Serializable {

    @Column(name = "id_sensor")
    private Long sensorId;

    @Column(name = "data_leitura")
    private LocalDateTime timestamp;

    public LeituraId() {}

    public LeituraId(Long sensorId, LocalDateTime timestamp) {
        this.sensorId = sensorId;
        this.timestamp = timestamp;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long sensorId;
        private LocalDateTime timestamp;

        public Builder sensorId(Long sensorId) {
            this.sensorId = sensorId;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public LeituraId build() {
            return new LeituraId(sensorId, timestamp);
        }
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeituraId leituraId = (LeituraId) o;
        return Objects.equals(sensorId, leituraId.sensorId) && 
               Objects.equals(timestamp, leituraId.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorId, timestamp);
    }
}
