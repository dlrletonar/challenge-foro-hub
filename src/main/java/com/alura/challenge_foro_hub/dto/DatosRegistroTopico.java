package com.alura.challenge_foro_hub.dto;

import com.alura.challenge_foro_hub.model.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank @Valid
        Curso curso
) {
}
