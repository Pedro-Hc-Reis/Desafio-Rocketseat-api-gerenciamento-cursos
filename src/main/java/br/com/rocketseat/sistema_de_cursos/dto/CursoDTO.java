package br.com.rocketseat.sistema_de_cursos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CursoDTO {

    @NotBlank ( message = "O nome é obrigatório" )
    private String name;

    @NotBlank ( message = "A categoria é obrigatória" )
    private String category;

    @NotBlank ( message = "O professor é obrigatório" )
    private String teacher;
}