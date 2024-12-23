package com.alura.foro.AluraForo.dto.topic;

import com.alura.foro.AluraForo.Modelo.Topic;

public record DatosListadoTopic(Long id, String titulo, String mensaje, String autor, String curso) {

    public DatosListadoTopic(Topic topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
    }
}
