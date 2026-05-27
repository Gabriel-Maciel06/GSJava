package com.gs.agroid.dto;

import org.springframework.hateoas.RepresentationModel;

public class PropriedadeResponseDto extends RepresentationModel<PropriedadeResponseDto> {
    private Long id;
    private String nome;
    private String localizacao;
    private Double tamanho;
    private Long usuarioId;

    public PropriedadeResponseDto() {}

    public PropriedadeResponseDto(Long id, String nome, String localizacao, Double tamanho, Long usuarioId) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.tamanho = tamanho;
        this.usuarioId = usuarioId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String nome;
        private String localizacao;
        private Double tamanho;
        private Long usuarioId;

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

        public Builder usuarioId(Long usuarioId) {
            this.usuarioId = usuarioId;
            return this;
        }

        public PropriedadeResponseDto build() {
            return new PropriedadeResponseDto(id, nome, localizacao, tamanho, usuarioId);
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropriedadeResponseDto that)) return false;
        if (!super.equals(o)) return false;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (localizacao != null ? !localizacao.equals(that.localizacao) : that.localizacao != null) return false;
        if (tamanho != null ? !tamanho.equals(that.tamanho) : that.tamanho != null) return false;
        return usuarioId != null ? usuarioId.equals(that.usuarioId) : that.usuarioId == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (localizacao != null ? localizacao.hashCode() : 0);
        result = 31 * result + (tamanho != null ? tamanho.hashCode() : 0);
        result = 31 * result + (usuarioId != null ? usuarioId.hashCode() : 0);
        return result;
    }
}
