package tn.esprit.brogram.backend.dao.errors;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String message) {
        super(message);
    }
}
