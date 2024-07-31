package org.example;

import java.util.Observable;

public class ServicoStreaming extends Observable {

    private Integer precoServico;
    private String nome;

    public ServicoStreaming(Integer precoServico, String nome) {
        this.precoServico = precoServico;
        this.nome = nome;
    }

    public void atualizarCatalogo() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Serviço de Streaming " +
                nome +
                " por " + precoServico + " R$";
    }
}