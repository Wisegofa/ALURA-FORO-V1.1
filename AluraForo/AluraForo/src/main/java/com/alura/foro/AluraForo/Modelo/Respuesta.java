package com.alura.foro.AluraForo.Modelo;

import com.alura.foro.AluraForo.dto.respuesta.DatosActualizarRespuesta;
import com.alura.foro.AluraForo.dto.respuesta.DatosRegistroRespuesta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topic topico;
    @Column(name = "Fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")

    private Usuario autor;

    private Boolean Solucion = false;

    public Respuesta(DatosRegistroRespuesta datosRegistro, Topic topico, Usuario autor) {

        this.mensaje = datosRegistro.mensaje();
        this.topico = topico;
        this.autor = autor;
        this.Solucion = datosRegistro.solucion();
        if (datosRegistro.solucion()) {
            this.topico.setStatusTopic(StatusTopic.SOLUCIONADO);
        } else {
            this.topico.setStatusTopic(StatusTopic.NO_SOLUCIONADO);
        }
    }


    public void actualizarDatos(DatosActualizarRespuesta datosActualizar, Topic topico, Usuario autor) {

        if (datosActualizar.mensaje() != null) {
            this.mensaje = datosActualizar.mensaje();
        }
        if (topico != null) {
            this.topico = topico;
        }
        if (autor != null) {
            this.autor = autor;
        }
        if (datosActualizar.solucion() != this.Solucion) {
            this.Solucion = datosActualizar.solucion();
        }

    }
}

