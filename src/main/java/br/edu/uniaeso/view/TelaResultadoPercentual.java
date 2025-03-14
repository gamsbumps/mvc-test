package br.edu.uniaeso.view;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.awt.Frame;

public class TelaResultadoPercentual extends Window{
    
    private Map <String, Label>labels = new HashMap();
    
    public TelaResultadoPercentual(Frame parent){
        super(parent);
        this.setSize(110,120);
        this.setLayout(new GridLayout(0,2)); // Grid com qualquer numero
                                              // de linhas e duas colunas
        this.add(new Label("Votos"));
        this.add(new Label());
    }

    /**
     * Recebe a lista de opcoes inicial
     */
    public void inicializar(ArrayList <String> opcoes) {
        
        Label label;
        Label votos;
        for(String opcao : opcoes){
            if(!labels.containsKey(opcao)){
                label = new Label(opcao+" - ");
                votos = new Label(""+0);
                labels.put(opcao,votos);
                this.add(label);
                this.add(votos);
            }
        }
    }

    /**
     * Atualiza a quantidade de votos para uma determinada opcao
     */
    public void novoVoto(String opcao, int nvotos) {
        
    }

    public void novoVoto(String opcao, int nvotos, int totalVotos) {
        Label votos;
        votos = labels.get(opcao);
        votos.setText(""+ (nvotos/totalVotos)*100);
    }
}
