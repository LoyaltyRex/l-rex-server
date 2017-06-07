package org.loyaltyrex.domain.exception;

public class DatabaseOperationFailedException extends Exception {

    private static final long serialVersionUID = 1L;

    public DatabaseOperationFailedException(String message) {
        super(message);
    }

    public DatabaseOperationFailedException(Throwable cause) {
        super(cause);
    }

    public DatabaseOperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
