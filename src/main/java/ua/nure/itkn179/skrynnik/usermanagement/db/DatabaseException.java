package main.java.ua.nure.itkn179.skrynnik.usermanagement.db;

public class DatabaseException extends Exception {

    private static final long serialVersionUID = 7378460121888205153L;

    public DatabaseException() {

    }

    public DatabaseException(String message) {
        super(message);

    }

    public DatabaseException(Throwable cause) {
        super(cause);

    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);

    }

    public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

}
