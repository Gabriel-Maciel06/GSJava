package com.gs.agroid.controller;

import com.gs.agroid.model.Alerta;
import com.gs.agroid.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping("/propriedade/{propriedadeId}")
    public ResponseEntity<List<Alerta>> getAlertasByPropriedade(@PathVariable Long propriedadeId) {
        return ResponseEntity.ok(alertaService.findByPropriedade(propriedadeId));
    }
}
