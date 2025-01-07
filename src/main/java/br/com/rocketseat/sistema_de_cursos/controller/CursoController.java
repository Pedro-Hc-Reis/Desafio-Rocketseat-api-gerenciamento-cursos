package br.com.rocketseat.sistema_de_cursos.controller;

import br.com.rocketseat.sistema_de_cursos.dto.CursoDTO;
import br.com.rocketseat.sistema_de_cursos.model.Curso;
import br.com.rocketseat.sistema_de_cursos.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ( "/cursos" )
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public Curso create ( @Valid @RequestBody CursoDTO cursoDTO ) {
        Curso curso = Curso.builder ( )
                .name ( cursoDTO.getName ( ) )
                .category ( cursoDTO.getCategory ( ) )
                .teacher ( cursoDTO.getTeacher ( ) )
                .build ( );
        return cursoService.create ( curso );
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll ( @RequestParam ( required = false ) String name ,
                                                 @RequestParam ( required = false ) String category ) {
        if ( name != null && category != null ) {
            return ResponseEntity.ok ( cursoService.findByNameAndCategory ( name , category ) );
        } else if ( name != null ) {
            return ResponseEntity.ok ( cursoService.findByName ( name ) );
        } else if ( category != null ) {
            return ResponseEntity.ok ( cursoService.findByCategory ( category ) );
        }
        return ResponseEntity.ok ( cursoService.findAll ( ) );
    }

    @GetMapping ( "/{id}" )
    public ResponseEntity<Curso> get ( @PathVariable String id ) {
        var result = cursoService.findById ( Long.valueOf ( id ) );
        return result != null ? ResponseEntity.ok ( result ) : ResponseEntity.noContent ( ).build ( );
    }

    @PutMapping ( "/{id}" )
    public Curso update ( @PathVariable Long id , @Valid @RequestBody CursoDTO cursoDTO ) {
        Curso curso = new Curso ( );
        curso.setName ( cursoDTO.getName ( ) );
        curso.setCategory ( cursoDTO.getCategory ( ) );
        curso.setTeacher ( cursoDTO.getTeacher ( ) );
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