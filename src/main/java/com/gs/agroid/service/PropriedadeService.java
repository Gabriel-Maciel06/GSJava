package com.gs.agroid.service;

import com.gs.agroid.dto.PropriedadeRequestDto;
import com.gs.agroid.dto.PropriedadeResponseDto;
import com.gs.agroid.exception.ResourceNotFoundException;
import com.gs.agroid.model.Propriedade;
import com.gs.agroid.model.Usuario;
import com.gs.agroid.repository.PropriedadeRepository;
import com.gs.agroid.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropriedadeService {

    @Autowired
    private PropriedadeRepository propriedadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public PropriedadeResponseDto create(PropriedadeRequestDto dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário proprietário não encontrado com ID: " + dto.usuarioId()));

        Propriedade propriedade = Propriedade.builder()
                .nome(dto.nome())
                .localizacao(dto.localizacao())
                .tamanho(dto.tamanho())
                .usuario(usuario)
                .build();

        propriedade = propriedadeRepository.save(propriedade);
        return convertToDto(propriedade);
    }

    @Transactional(readOnly = true)
    public List<PropriedadeResponseDto> findAll() {
        return propriedadeRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PropriedadeResponseDto findById(Long id) {
        Propriedade propriedade = propriedadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Propriedade não encontrada com ID: " + id));
        return convertToDto(propriedade);
    }

    @Transactional(readOnly = true)
    public List<PropriedadeResponseDto> findByUsuario(Long usuarioId) {
        return propriedadeRepository.findByUsuarioId(usuarioId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PropriedadeResponseDto convertToDto(Propriedade p) {
        return PropriedadeResponseDto.builder()
                .id(p.getId())
                .nome(p.getNome())
                .localizacao(p.getLocalizacao())
                .tamanho(p.getTamanho())
                .usuarioId(p.getUsuario().getId())
                .build();
    }
}
