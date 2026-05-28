package model;

import exceptions.*;

public class Revista
        extends Recurso
        implements Prestable {

    private int numero_edicion;
    private String editorial;
    private String autor;
    private String isbn;
    private String usuarioPrestado;

    public Revista(
            String codigo,
            String titulo,
            int anio,
            int numero_edicion,
            String editorial)
            throws RecursoNoPrestableException {

        super(codigo, titulo, anio);

        if (anio < 1923) {
            throw new
                    RecursoNoPrestableException(
                    "No puede prestarse"
            );
        }

        this.numero_edicion = numero_edicion;
        this.editorial = editorial;
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