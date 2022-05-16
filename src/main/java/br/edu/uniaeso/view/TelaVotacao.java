package br.edu.uniaeso.view;

import br.edu.uniaeso.controller.EnqueteController;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Map;

import java.awt.Frame;

public class TelaVotacao extends Frame implements ActionListener {

    private EnqueteController votacaoController;
    private TelaResultado telaResult;
    private TelaResultadoPercentual telaResultPerc;

    private Map <String,Integer>opcoes;
    private ArrayList <String>listaOpcoes; // para obter as opções em ordem

    public TelaVotacao() {
        super("Tela de Votação - Enquete");
        votacaoController = new EnqueteController();

        telaResult = new TelaResultado(this);
        telaResult.setLocation(120, 5); // posicao na tela

        telaResultPerc = new TelaResultadoPercentual(this);
        telaResultPerc.setLocation(250, 5); // posicao na tela

        votacaoController.adicionaOpcao("Opção 1");
        votacaoController.adicionaOpcao("Opção 2");
        votacaoController.adicionaOpcao("Opção 3");
        votacaoController.adicionaOpcao("Opção 4");
        criarBotoes();

        telaResult.inicializar(votacaoController.getListaOpcoes());
        telaResultPerc.inicializar(votacaoController.getListaOpcoes());

        this.setSize(100, 120);
        this.setLayout(new GridLayout(0, 1));
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                e.getWindow().hide();
                System.exit(0);
            }
        });
        this.show();
        telaResult.show();
        telaResultPerc.show();
    }

    /**
     * Cria os botoes da tela de votos
     **/

    public void criarBotoes() {
        Button botao;
        for (String opcao : votacaoController.getOpcoes()) {
            botao = new Button(opcao);
            botao.setActionCommand(opcao);
            botao.addActionListener(this);
            this.add(botao);
        }
    }

    /**
     * Método executado ao clicar nos botões
     */
    public void actionPerformed(ActionEvent event) {
        String opcao = event.getActionCommand();
        votacaoController.votar(opcao); // incrementando o voto

        // Atualizando a tela de resultados absolutos
        telaResult.novoVoto(opcao, votacaoController.getVotos(opcao));

        // Atualizando a tela de resultados percentuais
        telaResultPerc.novoVoto(opcao, votacaoController.getVotos(opcao), votacaoController.getTotalVotos());
    }
}