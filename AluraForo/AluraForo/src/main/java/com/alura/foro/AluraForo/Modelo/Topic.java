package com.alura.foro.AluraForo.Modelo;

import com.alura.foro.AluraForo.dto.topic.DatosRegistroTopic;
import com.alura.foro.AluraForo.dto.topic.DatosActualizarTopic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopic statusTopic = StatusTopic.NO_RESPONDIDO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private List<Respuesta> respuestas = new ArrayList<>();

    // Constructor principal
    public Topic(DatosRegistroTopic datos, Usuario autor, Curso curso) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autor = autor;
        this.curso = curso;
    }

    // Método para agregar respuestas a un tópico
    public void agregarRespuesta(Respuesta respuesta) {
        this.respuestas.add(respuesta);
        if(respuesta.getSolucion()) {
            this.statusTopic = StatusTopic.SOLUCIONADO;
        } else {
            this.statusTopic = StatusTopic.NO_SOLUCIONADO;
        }
    }

    // Método para cerrar un tópico
    public void cerrarTopico(){
        this.statusTopic = StatusTopic.CERRADO;
    }

    // Método para actualizar el estado del tópico
    public void setStatusTopic(StatusTopic status){
        this.statusTopic = status;
    }

    // Método para actualizar los datos de un tópico
    public void actualizarDatos(DatosActualizarTopic datosActualizar, Usuario autor, Curso curso) {
        if (datosActualizar.titulo() != null) {
            this.titulo = datosActualizar.titulo();
        }
        if (datosActualizar.mensaje() != null) {
            this.mensaje = datosActualizar.mensaje();
        }
        if (datosActualizar.estado() != null) {
            this.statusTopic = datosActualizar.estado();
        }
        if (autor != null) {
            this.autor = autor;
        }
        if (curso != null) {
            this.curso = curso;
        }
    }
}
