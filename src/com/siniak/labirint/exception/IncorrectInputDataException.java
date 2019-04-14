package com.siniak.labirint.exception;

public class IncorrectInputDataException extends Exception {
    public IncorrectInputDataException() {
    }

    public IncorrectInputDataException(String message) {
        super(message);
    }

    public IncorrectInputDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectInputDataException(Throwable cause) {
        super(cause);
    }
}
