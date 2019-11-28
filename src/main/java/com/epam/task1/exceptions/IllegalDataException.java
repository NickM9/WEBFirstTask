package com.epam.task1.exceptions;

public class IllegalDataException extends Exception {

    public IllegalDataException() {
        super();
    }

    public IllegalDataException(String message) {
        super(message);
    }

    public IllegalDataException(String message, Exception e) {
        super(message, e);
    }

    public IllegalDataException(Exception e) {
        super(e);
    }

}
