package com.gs.agroid.controller;

import com.gs.agroid.dto.LeituraResponseDto;
import com.gs.agroid.dto.SensorRequestDto;
import com.gs.agroid.dto.SensorResponseDto;
import com.gs.agroid.service.LeituraService;
import com.gs.agroid.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private LeituraService leituraService;

    @PostMapping
    public ResponseEntity<SensorResponseDto> create(@RequestBody @Valid SensorRequestDto dto) {
        SensorResponseDto response = sensorService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<SensorResponseDto>> findAll() {
        return ResponseEntity.ok(sensorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(sensorService.findById(id));
    }

    // Endpoint para buscar o histórico de leituras de um sensor específico
    @GetMapping("/{id}/leituras")
    public ResponseEntity<List<LeituraResponseDto>> getLeituras(@PathVariable Long id) {
        return ResponseEntity.ok(leituraService.findBySensor(id));
    }
}
