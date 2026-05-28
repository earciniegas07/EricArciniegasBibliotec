import model.*;
import service.*;

public class Main {

    public static void main(String[] args)
            throws Exception {

        Catalogo<Recurso> catalogo =
                new Catalogo<>();

        Libro l1 =
                new Libro(
                        "L1",
                        "Clean Code",
                        2008,
                        "Robert Martin",
                        "123"
                );

        Revista r1 =
                new Revista(
                        "R1",
                        "Nature",
                        2020,
                        15,
                        "Science"
                );

        RecursoDigital d1 =
                new RecursoDigital(
                        "D1",
                        "Java PDF",
                        2024,
                        "www.java.com"
                );

        catalogo.agregar(l1);
        catalogo.agregar(r1);
        catalogo.agregar(d1);

        l1.prestar("Eric");

        System.out.println(
                catalogo
                        .librosDisponiblesMayusculas()
        );

        System.out.println(
                catalogo.contarPrestados(
                        Libro.class
                )
        );

        System.out.println(
                catalogo.ordenar()
        );
    }
}