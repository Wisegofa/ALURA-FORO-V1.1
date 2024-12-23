package com.alura.foro.AluraForo.dto.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(

        @NotNull
        Long id,

        @NotBlank
        String mensaje,

        @NotNull
        Long TopicId,

        @NotBlank
        Long autorId,

        @NotNull
        Boolean solucion


) {
}
