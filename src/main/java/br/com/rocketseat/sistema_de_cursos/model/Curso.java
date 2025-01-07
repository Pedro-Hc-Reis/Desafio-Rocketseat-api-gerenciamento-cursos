package br.com.rocketseat.sistema_de_cursos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column ( nullable = false )
    private String name;

    @Column ( nullable = false )
    private String teacher;

    @Column ( nullable = false )
    private String category;

    @Builder.Default
    @Enumerated ( EnumType.STRING )
    @Column ( nullable = false )
    @JsonProperty ( "active" )
    private StatusCurso status = StatusCurso.ATIVO;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
