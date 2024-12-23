package com.alura.foro.AluraForo.dto.curso;

import com.alura.foro.AluraForo.Modelo.Curso;

public record DatosRespuestaCurso(String nombre, String categoria) {

    public DatosRespuestaCurso(Curso curso) {
        this(curso.getNombre(), curso.getCategoria());
    }
}
