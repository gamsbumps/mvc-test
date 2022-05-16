package br.edu.uniaeso.model;

import java.util.HashMap;
import java.util.Map;

public class Enquete {
    private Map<String, Integer> opcoes;

    public Enquete() {
        this.opcoes = new HashMap<String, Integer>();
    }

    /**
     * Adiciona uma opcao à enquete
     **/
    public void adicionaOpcao(String opcao) {
        this.opcoes.put(opcao, new Integer(0));
    }

    /**
     * Incrementa o voto da opção entrada
     */
    public void votar(String opcao) {
        int votoAtual = ((Integer) this.opcoes.get(opcao)).intValue();
        this.opcoes.put(opcao, new Integer(++votoAtual));
    }

    /**
     * Retorna a soma dos votos de todas as opções da enquete
     *
     * @return int soma dos votos de todas as opções da enquete
     */
    public int getTotalVotos() {
        int total = 0;
        for (Integer votos : opcoes.values()) {
            total += votos.intValue();
        }
        return total;
    }

    /**
     * Retorna a quantidade de votos de uma opção individual
     */
    public int getVotos(String opcao) {
        return ((Integer) this.opcoes.get(opcao)).intValue();
    }


    public Map<String, Integer> getOpcoesMap() {
        return this.opcoes;
    }
}
