package br.com.rocketseat.sistema_de_cursos.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Curso {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column ( nullable = false )
    private String name;

    @Column ( nullable = false )
    private String category;

    @Enumerated ( EnumType.STRING )
    @Column ( nullable = false )
    private StatusCurso status = StatusCurso.ATIVO;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
