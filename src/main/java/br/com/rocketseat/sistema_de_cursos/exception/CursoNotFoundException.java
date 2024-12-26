package br.com.rocketseat.sistema_de_cursos.exception;

public class CursoNotFoundException extends RuntimeException {

    public CursoNotFoundException ( Long id ) {
        super ( "Curso com o ID " + id + " não foi encontrado." );
    }
}