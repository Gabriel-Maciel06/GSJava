package com.gs.agroid.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_SATELITE_DADOS")
public class SateliteDados {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_satelite")
    @SequenceGenerator(name = "seq_satelite", sequenceName = "SEQ_SATELITE", allocationSize = 1)
    @Column(name = "id_satelite")
    private Long id;

    @Column(name = "umidade_prevista", nullable = false, precision = 5, scale = 2)
    private Double umidadePrevista;

    @Column(name = "clima", nullable = false, length = 50)
    private String clima;

    @Column(name = "regiao", nullable = false, length = 100)
    private String regiao;

    @Column(name = "data_coleta", nullable = false)
    private LocalDateTime timestamp;

    public SateliteDados() {}

    public SateliteDados(Long id, Double umidadePrevista, String clima, String regiao, LocalDateTime timestamp) {
        this.id = id;
        this.umidadePrevista = umidadePrevista;
        this.clima = clima;
        this.regiao = regiao;
        this.timestamp = timestamp;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Double umidadePrevista;
        private String clima;
        private String regiao;
        private LocalDateTime timestamp;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder umidadePrevista(Double umidadePrevista) {
            this.umidadePrevista = umidadePrevista;
            return this;
        }

        public Builder clima(String clima) {
            this.clima = clima;
            return this;
        }

        public Builder regiao(String regiao) {
            this.regiao = regiao;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public SateliteDados build() {
            return new SateliteDados(id, umidadePrevista, clima, regiao, timestamp);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getUmidadePrevista() {
        return umidadePrevista;
    }

    public void setUmidadePrevista(Double umidadePrevista) {
        this.umidadePrevista = umidadePrevista;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
