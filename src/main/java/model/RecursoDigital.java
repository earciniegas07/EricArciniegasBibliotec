package model;

public class RecursoDigital
        extends Recurso {

    private String url;

    public RecursoDigital(
            String codigo,
            String titulo,
            int anio,
            String url) {

        super(codigo, titulo, anio);

        this.url = url;
    }
}
