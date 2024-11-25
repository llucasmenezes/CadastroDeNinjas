package dev.java10x.CadastroDeNinjas.exceptions;

public class NoExistIdException extends RuntimeException {
    public NoExistIdException(Long id) {
        super("Ops... Ninja não localizado!");
    }
}
