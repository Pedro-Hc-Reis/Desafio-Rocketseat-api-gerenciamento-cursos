package br.com.rocketseat.sistema_de_cursos.repository;

import br.com.rocketseat.sistema_de_cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByNameContainingIgnoreCase ( String name );

    List<Curso> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase ( String name , String category );

    List<Curso> findByCategoryContainingIgnoreCase ( String category );
}