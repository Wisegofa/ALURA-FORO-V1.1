package com.alura.foro.AluraForo.dto.respuesta;

import com.alura.foro.AluraForo.Modelo.Respuesta;
import com.alura.foro.AluraForo.dto.Usuario.DatosRespuestaUsuario;
import com.alura.foro.AluraForo.dto.topic.DatosRespuestaTopic;

public record DatosRetornoRespuestaId(String mensaje, DatosRespuestaTopic topico, String fechaCreacion, DatosRespuestaUsuario autor, String solucion) {

    public DatosRetornoRespuestaId(Respuesta respuesta){
        this(respuesta.getMensaje(), new DatosRespuestaTopic(respuesta.getTopico()), respuesta.getFechaCreacion().toString(),
                new DatosRespuestaUsuario(respuesta.getAutor()), respuesta.getSolucion().toString());
    }

}
