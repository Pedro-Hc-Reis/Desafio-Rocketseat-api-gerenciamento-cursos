package br.com.rocketseat.sistema_de_cursos.service;

import br.com.rocketseat.sistema_de_cursos.exception.CursoNotFoundException;
import br.com.rocketseat.sistema_de_cursos.model.Curso;
import br.com.rocketseat.sistema_de_cursos.model.StatusCurso;
import br.com.rocketseat.sistema_de_cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso create ( Curso curso ) {
        return cursoRepository.save ( curso );
    }

    public List<Curso> findAll ( ) {
        return cursoRepository.findAll ( );
    }

    public Curso findById ( Long id ) {
        return cursoRepository.findById ( id ).orElse ( null );
    }

    public List<Curso> findByName ( String name ) {
        return cursoRepository.findByNameContainingIgnoreCase ( name );
    }

    public List<Curso> findByNameAndCategory ( String name , String category ) {
        return cursoRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase ( name , category );
    }

    public List<Curso> findByCategory ( String category ) {
        return cursoRepository.findByCategoryContainingIgnoreCase ( category );
    }

    public Curso update ( Long id , Curso updatedCurso ) {
        Curso curso = cursoRepository.findById ( id )
                .orElseThrow ( ( ) -> new RuntimeException ( "Curso não encontrado" ) );

        if ( updatedCurso.getName ( ) != null ) {
            curso.setName ( updatedCurso.getName ( ) );
        }

        if ( updatedCurso.getCategory ( ) != null ) {
            curso.setCategory ( updatedCurso.getCategory ( ) );
        }

        if ( updatedCurso.getTeacher ( ) != null ) {
            curso.setTeacher ( updatedCurso.getTeacher ( ) );
        }

        return cursoRepository.save ( curso );
    }

    public void delete ( Long id ) {
        Curso curso = cursoRepository.findById ( id )
                .orElseThrow ( ( ) -> new CursoNotFoundException ( id ) );
        cursoRepository.delete ( curso );
    }

    public Curso toggleActive ( Long id ) {
        Curso curso = cursoRepository.findById ( id )
                .orElseThrow ( ( ) -> new CursoNotFoundException ( id ) );
        curso.setStatus ( curso.getStatus ( ) == StatusCurso.ATIVO ? StatusCurso.INATIVO : StatusCurso.ATIVO );
        return cursoRepository.save ( curso );
    }
}