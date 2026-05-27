package com.gs.agroid.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ALERTA")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alerta")
    @SequenceGenerator(name = "seq_alerta", sequenceName = "SEQ_ALERTA", allocationSize = 1)
    @Column(name = "id_alerta")
    private Long id;

    @Column(name = "mensagem", nullable = false, length = 255)
    private String mensagem;

    @Column(name = "data_alerta", nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_propriedade", nullable = false)
    private Propriedade propriedade;

    public Alerta() {}

    public Alerta(Long id, String mensagem, LocalDateTime timestamp, Propriedade propriedade) {
        this.id = id;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
        this.propriedade = propriedade;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String mensagem;
        private LocalDateTime timestamp;
        private Propriedade propriedade;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder mensagem(String mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder propriedade(Propriedade propriedade) {
            this.propriedade = propriedade;
            return this;
        }

        public Alerta build() {
            return new Alerta(id, mensagem, timestamp, propriedade);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }
}
