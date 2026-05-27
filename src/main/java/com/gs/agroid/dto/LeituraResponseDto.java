package com.gs.agroid.dto;

import java.time.LocalDateTime;

public record LeituraResponseDto(
    Long sensorId,
    LocalDateTime timestamp,
    Double valor
) {}
