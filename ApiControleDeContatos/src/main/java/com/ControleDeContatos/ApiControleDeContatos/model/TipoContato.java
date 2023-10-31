package com.ControleDeContatos.ApiControleDeContatos.model;

public enum TipoContato {
    TELETONE(0),
    CELULAR(1);

    private final int valor;
    TipoContato(int valor) {
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }
    public static TipoContato valueOf(int valor){
        for(TipoContato tipo : values()){
            if(tipo.valor == valor){
                return tipo;
            }
        }
        throw new IllegalArgumentException("O Tipo do Contato foi inválido: " + valor);
    }

}
