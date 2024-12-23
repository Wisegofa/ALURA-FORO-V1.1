package com.alura.foro.AluraForo.Controller;

import com.alura.foro.AluraForo.Modelo.Usuario;
import com.alura.foro.AluraForo.Repository.UsuarioRepository;
import com.alura.foro.AluraForo.dto.Usuario.DatosRegistroUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<String> registrarUsuario(@RequestBody DatosRegistroUsuario datosRegistro) {
        // Verifica si el email ya está en uso
        if (usuarioRepository.existsByEmail(datosRegistro.email())) {
            return ResponseEntity.badRequest().body("El email ya está en uso.");
        }

        // Crea el nuevo usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setEmail(datosRegistro.email());
        nuevoUsuario.setContrasena(passwordEncoder.encode(datosRegistro.contrasena())); // Encripta la contraseña
        usuarioRepository.save(nuevoUsuario);

        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }
}
