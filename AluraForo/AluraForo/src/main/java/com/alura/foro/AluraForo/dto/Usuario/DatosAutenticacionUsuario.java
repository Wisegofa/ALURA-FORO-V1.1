package com.alura.foro.AluraForo.dto.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank
        @Email
        String email,  // Cambiado a minúscula

        @NotBlank
        String contrasena
) {
}
