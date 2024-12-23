package com.alura.foro.AluraForo.Repository;

import com.alura.foro.AluraForo.Modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
