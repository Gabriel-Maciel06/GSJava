package com.gs.agroid.service;

import com.gs.agroid.model.Alerta;
import com.gs.agroid.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Transactional(readOnly = true)
    public List<Alerta> findByPropriedade(Long propriedadeId) {
        return alertaRepository.findByPropriedadeIdOrderByTimestampDesc(propriedadeId);
    }
}
