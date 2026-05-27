package com.gs.agroid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PROPRIEDADE")
public class Propriedade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_propriedade")
    @SequenceGenerator(name = "seq_propriedade", sequenceName = "SEQ_PROPRIEDADE", allocationSize = 1)
    @Column(name = "id_propriedade")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "localizacao", nullable = false, length = 255)
    private String localizacao;

    @Column(name = "tamanho", nullable = false, precision = 10, scale = 2)
    private Double tamanho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Propriedade() {}

    public Propriedade(Long id, String nome, String localizacao, Double tamanho, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.tamanho = tamanho;
        this.usuario = usuario;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String nome;
        private String localizacao;
        private Double tamanho;
        private Usuario usuario;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder localizacao(String localizacao) {
            this.localizacao = localizacao;
            return this;
        }

        public Builder tamanho(Double tamanho) {
            this.tamanho = tamanho;
            return this;
        }

        public Builder usuario(Usuario usuario) {
            this.usuario = usuario;
            return this;
        }

        public Propriedade build() {
            return new Propriedade(id, nome, localizacao, tamanho, usuario);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
