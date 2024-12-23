package com.alura.foro.AluraForo.dto.respuesta;

import com.alura.foro.AluraForo.Modelo.Respuesta;

public record DatosRetornoRespuesta(String mensaje, String topic, String autor) {

    public DatosRetornoRespuesta(Respuesta respuesta){
        this(respuesta.getMensaje(), respuesta.getTopico().getTitulo(), respuesta.getAutor().getNombre());
    }
}
