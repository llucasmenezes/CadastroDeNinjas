package dev.java10x.CadastroDeNinjas.exceptions;

public class IdExistsException extends RuntimeException {
    public IdExistsException(String message) {
        super(message);
    }
}
