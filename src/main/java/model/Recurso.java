package model;

import java.util.Objects;

public abstract class Recurso {

    protected String codigo;
    protected String titulo;
    protected int anioPublicacion;
    protected boolean disponible;

    public Recurso(
            String codigo,
            String titulo,
            int anioPublicacion) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public boolean equals(Object o) {

        // dos recursos son igual si tienen el mismo codigo

        if (this == o) return true;

        if (!(o instanceof Recurso))
            return false;

        Recurso r = (Recurso) o;

        return codigo.equals(r.codigo);
    }

    @Override
    public int hashCode() {

        // hashCode basado en codigo porquie identifica el recurso

        return Objects.hash(codigo);
    }

    @Override
    public String toString() {

        return titulo + " (" +
                anioPublicacion + ")";
    }
}
