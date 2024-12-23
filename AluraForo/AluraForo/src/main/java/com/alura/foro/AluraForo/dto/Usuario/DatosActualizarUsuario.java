package com.alura.foro.AluraForo.dto.Usuario;

import com.alura.foro.AluraForo.Modelo.Tipo;

public record DatosActualizarUsuario(Long id, String nombre, String email, String contrasena, Tipo tipo) {
}
