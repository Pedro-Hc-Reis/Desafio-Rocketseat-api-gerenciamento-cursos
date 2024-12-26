package br.com.rocketseat.sistema_de_cursos.controller;

import br.com.rocketseat.sistema_de_cursos.dto.CursoDTO;
import br.com.rocketseat.sistema_de_cursos.model.Curso;
import br.com.rocketseat.sistema_de_cursos.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ( "/cursos" )
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public Curso create ( @Valid @RequestBody CursoDTO cursoDTO ) {
        Curso curso = new Curso ( );
        curso.setName ( cursoDTO.getName ( ) );
        curso.setCategory ( cursoDTO.getCategory ( ) );
        return cursoService.create ( curso );
    }

    @GetMapping
    public List<Curso> findAll ( ) {
        return cursoService.findAll ( );
    }

    @GetMapping ( "/search" )
    public List<Curso> search ( @RequestParam ( required = false ) String name ,
                                @RequestParam ( required = false ) String category ) {
        if ( name != null && category != null ) {
            return cursoService.findByNameAndCategory ( name , category );
        } else if ( name != null ) {
            return cursoService.findByName ( name );
        } else if ( category != null ) {
            return cursoService.findByCategory ( category );
        }
        return cursoService.findAll ( );
    }

    @PutMapping ( "/{id}" )
    public Curso update ( @PathVariable Long id , @RequestBody CursoDTO cursoDTO ) {
        Curso curso = new Curso ( );
        curso.setName ( cursoDTO.getName ( ) );
        curso.setCategory ( cursoDTO.getCategory ( ) );
        return cursoService.update ( id , curso );
    }

    @DeleteMapping ( "/{id}" )
    public void delete ( @PathVariable Long id ) {
        cursoService.delete ( id );
    }

    @PatchMapping ( "/{id}/active" )
    public Curso toggleActive ( @PathVariable Long id ) {
        return cursoService.toggleActive ( id );
    }
}