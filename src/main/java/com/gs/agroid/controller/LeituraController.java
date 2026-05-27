package com.gs.agroid.controller;

import com.gs.agroid.dto.LeituraRequestDto;
import com.gs.agroid.dto.LeituraResponseDto;
import com.gs.agroid.service.LeituraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leituras")
public class LeituraController {

    @Autowired
    private LeituraService leituraService;

    @PostMapping
    public ResponseEntity<LeituraResponseDto> create(@RequestBody @Valid LeituraRequestDto dto) {
        LeituraResponseDto response = leituraService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
