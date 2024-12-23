package com.alura.foro.AluraForo.dto.Usuario;

import com.alura.foro.AluraForo.Modelo.Usuario;

public record DatosListadoUsuario(Long id, String nombre, String email, String tipo ) {


    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getTipo().toString());
    }
}
