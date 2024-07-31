package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String login;
    private String ultimaNotificacao;

    public Cliente(String login) {
        this.login = login;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void assinarServico(ServicoStreaming servicoStreaming) {
        servicoStreaming.addObserver(this);
    }

    public void update(Observable servicoStreaming, Object arg1) {
        this.ultimaNotificacao = this.login + ", novo filme adicionado no " + servicoStreaming.toString();
    }
}