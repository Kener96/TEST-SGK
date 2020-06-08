package controller;

public class RegisterNotFoundExeption extends Exception {

    public RegisterNotFoundExeption() {
    }

    public RegisterNotFoundExeption(String message) {
        super(message);
    }

    public RegisterNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisterNotFoundExeption(Throwable cause) {
        super(cause);
    }


}
