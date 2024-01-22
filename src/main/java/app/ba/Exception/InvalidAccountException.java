package app.ba.Exception;
public class InvalidAccountException extends RuntimeException {
    public InvalidAccountException(String message) {
        super(message);
    }
    @Override
    public String toString() {
        return getMessage();
    }
}
