package com.gs.agroid.repository;

import com.gs.agroid.model.Leitura;
import com.gs.agroid.model.LeituraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeituraRepository extends JpaRepository<Leitura, LeituraId> {
    List<Leitura> findByIdSensorIdOrderByIdTimestampDesc(Long sensorId);
}
