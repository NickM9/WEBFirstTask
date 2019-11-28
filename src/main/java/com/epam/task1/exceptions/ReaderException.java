package com.epam.task1.exceptions;

public class ReaderException extends Exception{

    public ReaderException() {
        super();
    }

    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(String message, Exception e) {
        super(message, e);
    }

    public ReaderException(Exception e) {
        super(e);
    }
}
