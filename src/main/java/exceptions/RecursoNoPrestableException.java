package exceptions;

public class RecursoNoPrestableException
        extends Exception {

    public RecursoNoPrestableException(
            String mensaje) {

        super(mensaje);
    }
}
