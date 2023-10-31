package com.ControleDeContatos.ApiControleDeContatos.exception;

public class PessoaNotFoundException extends RuntimeException {
    public PessoaNotFoundException(String message){
        super(message);
    }
}
