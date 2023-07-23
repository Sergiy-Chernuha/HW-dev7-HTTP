package ua.goit;

public class WrongStatusException extends Exception {
    private final String message;

    public WrongStatusException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "There is not image for HTTP status " + message;
    }
}
