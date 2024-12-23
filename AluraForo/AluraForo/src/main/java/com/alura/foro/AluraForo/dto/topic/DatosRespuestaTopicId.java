package com.alura.foro.AluraForo.dto.topic;

import com.alura.foro.AluraForo.Modelo.Topic;
import com.alura.foro.AluraForo.dto.Usuario.DatosRespuestaUsuario;
import com.alura.foro.AluraForo.dto.curso.DatosRespuestaCurso;

public record DatosRespuestaTopicId(Long id, String titulo, String mensaje, String fechaCreacion, String estado, DatosRespuestaUsuario autor,
                                    DatosRespuestaCurso curso) {

    // Constructor que toma un Topic y lo convierte a DatosRespuestaTopicId
    public DatosRespuestaTopicId(Topic topic){
        this(topic.getId(), topic.getTitulo(), topic.getMensaje(), topic.getFechaCreacion().toString(),
                topic.getStatusTopic().toString(), new DatosRespuestaUsuario(topic.getAutor()),
                new DatosRespuestaCurso(topic.getCurso()));
    }
}
