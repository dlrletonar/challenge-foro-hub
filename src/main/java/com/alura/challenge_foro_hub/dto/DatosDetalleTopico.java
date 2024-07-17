package com.alura.challenge_foro_hub.dto;

import com.alura.challenge_foro_hub.model.Curso;
import com.alura.challenge_foro_hub.model.Topico;

import java.time.LocalDate;

public record DatosDetalleTopico(

        String titulo,
        String mensaje,
        LocalDate fechaCreacion,
        Curso curso
) {
    public DatosDetalleTopico(Topico topico){
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getCurso());
    }
}
