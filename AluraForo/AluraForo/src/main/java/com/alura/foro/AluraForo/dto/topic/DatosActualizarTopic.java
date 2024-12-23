package com.alura.foro.AluraForo.dto.topic;

import com.alura.foro.AluraForo.Modelo.StatusTopic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopic(

        @NotNull
        Long id,

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotNull
        StatusTopic estado,

        @NotNull
        Long autorId,

        @NotNull
        Long cursoId) {
}
