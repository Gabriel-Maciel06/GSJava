package com.gs.agroid.repository;

import com.gs.agroid.model.SateliteDados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SateliteDadosRepository extends JpaRepository<SateliteDados, Long> {
    List<SateliteDados> findByRegiaoOrderByTimestampDesc(String regiao);
}
