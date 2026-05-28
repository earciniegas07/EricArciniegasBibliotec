package service;

import model.*;
import exceptions.*;

import java.util.*;

public class Catalogo<T extends Recurso> {

    private List<T> recursos =
            new ArrayList<>();

    public void agregar(T r) {
        recursos.add(r);
    }

    public void eliminar(T r) {
        recursos.remove(r);
    }

    public T buscarPorCodigo(String codigo)
            throws RecursoNoEncontradoException {

        return recursos.stream()
                .filter(r ->
                        r.getCodigo()
                                .equals(codigo))
                .findFirst()
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "No existe"));
    }

    public List<T> buscarPorTitulo(
            String fragmento) {

        return recursos.stream()
                .filter(r ->
                        r.getTitulo()
                                .toLowerCase()
                                .contains(
                                        fragmento
                                                .toLowerCase()))
                .toList();
    }

    public List<T> disponibles() {

        return recursos.stream()
                .filter(Recurso::isDisponible)
                .toList();
    }

    public List<String>
    librosDisponiblesMayusculas() {

        return recursos.stream()
                .filter(r -> r instanceof Libro)
                .filter(Recurso::isDisponible)
                .map(r ->
                        r.getTitulo()
                                .toUpperCase())
                .toList();
    }

    public List<T> ordenar() {

        return recursos.stream()
                .sorted(
                        Comparator
                                .comparing(
                                        Recurso::getAnioPublicacion)
                                .reversed()
                                .thenComparing(
                                        Recurso::getTitulo)
                ).toList();
    }

    public long contarPrestados(
            Class<?> tipo) {

        return recursos.stream()
                .filter(tipo::isInstance)
                .filter(r -> !r.isDisponible())
                .count();
    }
}