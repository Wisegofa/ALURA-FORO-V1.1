package com.alura.foro.AluraForo.dto.Usuario;

import com.alura.foro.AluraForo.Modelo.Usuario;

public record DatosRespuestaUsuario(String nombre, String email, String tipo ) {

    public DatosRespuestaUsuario(Usuario usuario){
        this(usuario.getNombre(), usuario.getEmail(), usuario.getEmail().toString());
    }
}
