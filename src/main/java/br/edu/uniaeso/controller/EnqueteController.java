package br.edu.uniaeso.controller;

import br.edu.uniaeso.model.Enquete;

import java.util.ArrayList;
import java.util.List;

public class EnqueteController {
    Enquete enquete = new Enquete();

    //vai ao controller a qualquer momento
    public ArrayList<String> getListaOpcoes() {
        ArrayList<String> listaOpcoes = new ArrayList<String>();
        for (String opt : getOpcoes()) {
            listaOpcoes.add(opt);
        }
        return listaOpcoes;
    }

    public void criarEnquete(List<String> opcoes) {

    }

    public int getVotos(String opcao) {
        return enquete.getVotos(opcao);
    }

    public int getTotalVotos() {
        return enquete.getTotalVotos();
    }

    //model nao pode ser acessado diretamente pela view. Quem acessa é o controller
    public void adicionaOpcao(String opcao) {
        enquete.adicionaOpcao(opcao);
    }

    public String[] getOpcoes() {
        return enquete.getOpcoesMap().keySet().toArray(new String[enquete.getOpcoesMap().size()]);
    }

    public void votar(String opcao) {
        enquete.votar(opcao);
    }
}
