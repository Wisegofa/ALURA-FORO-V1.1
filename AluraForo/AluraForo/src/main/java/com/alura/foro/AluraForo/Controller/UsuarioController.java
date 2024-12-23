package com.alura.foro.AluraForo.Controller;

import com.alura.foro.AluraForo.Modelo.Usuario;
import com.alura.foro.AluraForo.Repository.UsuarioRepository;
import com.alura.foro.AluraForo.dto.Usuario.*;
import com.alura.foro.AluraForo.errores.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registrar(@RequestBody DatosRegistroUsuario datosRegistro, UriComponentsBuilder uri) {
        Usuario usuario = usuarioRepository.save(new Usuario(datosRegistro));
        DatosRespuestaUsuario datosRespuesta = new DatosRespuestaUsuario(usuario);
        URI url = uri.path("/Users/{id}").buildAndExpand(usuario.getId()).toUri(); // Asegurando que la ruta sea consistente
        return ResponseEntity.created(url).body(datosRespuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuario>> listar(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(usuarioRepository.findAll(paginacion).map(DatosListadoUsuario::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaUsuarioId> retornaDatos(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado")); // Manejo de error
        return ResponseEntity.ok(new DatosRespuestaUsuarioId(usuario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaUsuario> actualizar(@RequestBody DatosActualizarUsuario datosActualizar) {
        Usuario usuario = usuarioRepository.findById(datosActualizar.id()).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado")); // Manejo de error
        usuario.actualizarDatos(datosActualizar);
        return ResponseEntity.ok(new DatosRespuestaUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado")); // Manejo de error
        usuarioRepository.delete(usuario);
        return ResponseEntity.noContent().build();
    }
}
