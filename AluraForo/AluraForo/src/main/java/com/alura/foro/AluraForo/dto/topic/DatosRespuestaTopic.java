package com.alura.foro.AluraForo.dto.topic;

import com.alura.foro.AluraForo.Modelo.Topic;

public record DatosRespuestaTopic(String titulo, String mensaje, String autor, String curso) {

    public DatosRespuestaTopic(Topic topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }
}
