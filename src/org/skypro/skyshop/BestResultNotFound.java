package org.skypro.skyshop;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(Throwable cause) {
        super(cause);
    }

    public BestResultNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BestResultNotFound(String message) {
        super(message);
    }

    public BestResultNotFound() {
    }
}
