package model;

import exceptions.*;

public class Libro
        extends Recurso
        implements Prestable {

    private String autor;
    private String isbn;
    private String usuarioPrestado;

    public Libro(
            String codigo,
            String titulo,
            int anio,
            String autor,
            String isbn)
            throws RecursoNoPrestableException {

        super(codigo, titulo, anio);

        if (anio < 1923) {
            throw new
                    RecursoNoPrestableException(
                    "No puede prestarse"
            );
        }

        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public void prestar(String usuario) throws Exception {

        if (!disponible) {
            throw new RecursoPrestadoException(
                    "Ya prestado"
            );
        }

        disponible = false;
        usuarioPrestado = usuario;
    }

    @Override
    public void devolver() {

        disponible = true;
        usuarioPrestado = null;
    }
}