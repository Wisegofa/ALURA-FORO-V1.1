package com.alura.foro.AluraForo.dto.respuesta;

import com.alura.foro.AluraForo.Modelo.Respuesta;

public record DatosListadoRespuesta(Long id, String mensaje, String topic, String autor ) {



    public DatosListadoRespuesta(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getTopico().getTitulo(), respuesta.getAutor().getNombre());
    }
}
