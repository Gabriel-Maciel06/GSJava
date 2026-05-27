package com.gs.agroid.service;

import com.gs.agroid.model.SateliteDados;
import com.gs.agroid.repository.SateliteDadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SateliteDadosService {

    @Autowired
    private SateliteDadosRepository sateliteDadosRepository;

    @Transactional
    public SateliteDados create(SateliteDados dados) {
        return sateliteDadosRepository.save(dados);
    }

    @Transactional(readOnly = true)
    public List<SateliteDados> findByRegiao(String regiao) {
        return sateliteDadosRepository.findByRegiaoOrderByTimestampDesc(regiao);
    }
}
