package com.ControleDeContatos.ApiControleDeContatos.exception;

public class ContatoNotFoundException extends RuntimeException{
    public ContatoNotFoundException(String message){
        super(message);
    }
}
