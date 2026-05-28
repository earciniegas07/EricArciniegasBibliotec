package model;

import exceptions.*;

public class Revista
        extends Recurso
        implements Prestable {

    private int numero;
    private String tema;
    private String autor;
    private String isbn;
    private String usuarioPrestado;

    public Revista(
            String codigo,
            String titulo,
            int anio,
            int numero,
            String tema)
            throws RecursoNoPrestableException {

        super(codigo, titulo, anio);

        if (anio < 1923) {
            throw new
                    RecursoNoPrestableException(
                    "No puede prestarse"
            );
        }

        this.numero = numero;
        this.tema = tema;
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