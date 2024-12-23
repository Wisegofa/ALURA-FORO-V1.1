package com.alura.foro.AluraForo.Controller;

import com.alura.foro.AluraForo.Modelo.Curso;
import com.alura.foro.AluraForo.Modelo.Topic;
import com.alura.foro.AluraForo.Modelo.Usuario;
import com.alura.foro.AluraForo.Repository.CursoRepository;
import com.alura.foro.AluraForo.Repository.TopicRepository;
import com.alura.foro.AluraForo.Repository.UsuarioRepository;
import com.alura.foro.AluraForo.dto.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/Topic")
public class TopicoController {

    private final TopicRepository topicRepository;
    private final UsuarioRepository usuarioRepository;

    private final CursoRepository cursoRepository;

    public TopicoController(TopicRepository topicRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicRepository = topicRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    @PostMapping

    public ResponseEntity<DatosRespuestaTopic> registrar(@RequestBody @Valid DatosRegistroTopic datosRegistroTopic, UriComponentsBuilder uri){
        Usuario autor = usuarioRepository.getReferenceById(datosRegistroTopic.autorId());
        Curso curso = cursoRepository.getReferenceById(datosRegistroTopic.cursoId());
        Topic topic = topicRepository.save(new Topic(datosRegistroTopic, autor, curso));
        DatosRespuestaTopic datosRespuestaTopic = new DatosRespuestaTopic(topic);
        URI url = uri.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopic);
    }


    @GetMapping
    public ResponseEntity<Page<DatosListadoTopic>> listar(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(topicRepository.findAll(paginacion).map(DatosListadoTopic::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopicId> retornaDatos(@PathVariable Long id) {
        Topic topico = topicRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaTopicId(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopic> actualizar(@RequestBody @Valid DatosActualizarTopic datosActualizar) {
        Usuario autor = usuarioRepository.getReferenceById(datosActualizar.autorId());
        Curso curso = cursoRepository.getReferenceById(datosActualizar.cursoId());
        Topic topico = topicRepository.getReferenceById(datosActualizar.id());
        topico.actualizarDatos(datosActualizar, autor, curso);
        return ResponseEntity.ok( new DatosRespuestaTopic(topico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Topic topico = topicRepository.getReferenceById(id);
        //topicoRepository.delete(topico);
        topico.cerrarTopico();
        return ResponseEntity.noContent().build();
    }
}
