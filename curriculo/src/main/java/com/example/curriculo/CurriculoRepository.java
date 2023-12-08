package com.example.curriculo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
    // Métodos de consulta personalizados, se necessário
}

