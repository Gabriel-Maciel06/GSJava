package com.gs.agroid.service;

import com.gs.agroid.dto.LeituraRequestDto;
import com.gs.agroid.dto.LeituraResponseDto;
import com.gs.agroid.exception.CustomValidationException;
import com.gs.agroid.exception.ResourceNotFoundException;
import com.gs.agroid.model.*;
import com.gs.agroid.repository.AlertaRepository;
import com.gs.agroid.repository.LeituraRepository;
import com.gs.agroid.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeituraService {

    @Autowired
    private LeituraRepository leituraRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private AlertaRepository alertaRepository;

    @Transactional
    public LeituraResponseDto create(LeituraRequestDto dto) {
        Sensor sensor = sensorRepository.findById(dto.sensorId())
                .orElseThrow(() -> new ResourceNotFoundException("Sensor não encontrado com ID: " + dto.sensorId()));

        // Validação dinâmica: umidade deve ser de 0 a 100%
        if ("UMIDADE".equalsIgnoreCase(sensor.getTipoSensor())) {
            if (dto.valor() < 0.0 || dto.valor() > 100.0) {
                throw new CustomValidationException("Leitura de umidade inválida: " + dto.valor() + "%. Deve estar entre 0% e 100%.");
            }
        }

        LocalDateTime timestamp = dto.timestamp() != null ? dto.timestamp() : LocalDateTime.now();

        LeituraId id = LeituraId.builder()
                .sensorId(sensor.getId())
                .timestamp(timestamp)
                .build();

        Leitura leitura = Leitura.builder()
                .id(id)
                .sensor(sensor)
                .valor(dto.valor())
                .build();

        leitura = leituraRepository.save(leitura);

        // Lógica de Integração Estratégica: Irrigação Automática
        // Se a leitura for de umidade e estiver abaixo de 20%, dispara o sistema de irrigação e gera alerta
        if ("UMIDADE".equalsIgnoreCase(sensor.getTipoSensor()) && dto.valor() < 20.00) {
            triggerIrrigacao(sensor.getPropriedade(), dto.valor());
        }

        return convertToDto(leitura);
    }

    private void triggerIrrigacao(Propriedade propriedade, Double valorUmidade) {
        System.out.println("[SISTEMA DE IRRIGAÇÃO] >>> DISPARANDO IRRIGAÇÃO AUTOMÁTICA para a propriedade: " 
                + propriedade.getNome() + " (Umidade atual: " + valorUmidade + "%)");

        Alerta alerta = Alerta.builder()
                .mensagem("SISTEMA DE IRRIGAÇÃO ATIVADO: Umidade crítica detectada de " + valorUmidade + "% na propriedade: " + propriedade.getNome())
                .timestamp(LocalDateTime.now())
                .propriedade(propriedade)
                .build();

        alertaRepository.save(alerta);
    }

    @Transactional(readOnly = true)
    public List<LeituraResponseDto> findBySensor(Long sensorId) {
        return leituraRepository.findByIdSensorIdOrderByIdTimestampDesc(sensorId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public LeituraResponseDto convertToDto(Leitura l) {
        return new LeituraResponseDto(
                l.getId().getSensorId(),
                l.getId().getTimestamp(),
                l.getValor()
        );
    }
}
