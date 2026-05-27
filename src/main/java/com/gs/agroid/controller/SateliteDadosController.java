package com.gs.agroid.controller;

import com.gs.agroid.model.SateliteDados;
import com.gs.agroid.service.SateliteDadosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/satelite")
public class SateliteDadosController {

    @Autowired
    private SateliteDadosService sateliteDadosService;

    @PostMapping
    public ResponseEntity<SateliteDados> create(@RequestBody @Valid SateliteDados dados) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sateliteDadosService.create(dados));
    }

    @GetMapping("/regiao/{regiao}")
    public ResponseEntity<List<SateliteDados>> getByRegiao(@PathVariable String regiao) {
        return ResponseEntity.ok(sateliteDadosService.findByRegiao(regiao));
    }
}
