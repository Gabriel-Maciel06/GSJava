package com.gs.agroid.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorResponseDto {
    private Long id;
    private String tipoSensor;
    private String modelo;
    private String status;
    private Long propriedadeId;
}
