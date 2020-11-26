package Jogo_da_Velha;

import java.util.Scanner;

public class Jogo {

    private Tabuleiro tabuleiro;
    private int rodada=1, vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner entrada = new Scanner(System.in);
//iniciando jogo.
    public Jogo(){
        tabuleiro = new Tabuleiro();
        iniciarJogadores();

        while ( Jogar());
    }
// sele��o de jogadores
    public void iniciarJogadores(){
        System.out.println("Quem sera, o jogador 1?");
        if(escolherJogador() == 1)
            this.jogador1 = new Humano(1);
        else
            this.jogador1 = new Computador(1);

        System.out.println("--------------------------------------------");
        System.out.println("Quem sera, o jogador 2?");

        if(escolherJogador() == 1)
            this.jogador2 = new Humano(2);
        else
            this.jogador2 = new Computador(2);
    }

    public int escolherJogador(){
        int opcao = 0;

        do{
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.println("Op��o: ");
            opcao = entrada.nextInt();
//esse if foi para limitar a escolha entre humano e computador.
            if( opcao != 1 && opcao != 2)
                System.out.println("Op��o Invalida! Tente novamente");
        }while (opcao != 1 && opcao != 2);
            return opcao;
    }
//rodadas do jogo.
    public boolean Jogar(){
        if(ganhou() == 0){
            System.out.println("--------------------------------------------");
            System.out.println("\nRodada " +rodada);
            System.out.println("� a vez do jogador " + vez());

            if(vez() == 1)
                jogador1.jogar(tabuleiro);
            else
                jogador2.jogar(tabuleiro);

            if(tabuleiro.tabuleiroCompleto()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                return false;
            }

            vez++;
            rodada++;

            return true;
        }else {
            if(ganhou() == -1)
                System.out.println("Jogador 1 Ganhou!");
            else
                System.out.println("Jogador 2 Ganhou!");

            return false;
        }
    }

    public int vez(){
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
// resultado do jogo.
    public int ganhou() {
        if(tabuleiro.checaLinhas() == 1)
            return 1;
        if(tabuleiro.checaColunas() == 1)
            return 1;
        if(tabuleiro.checaDiagonais() == 1)
            return 1;

        if(tabuleiro.checaLinhas() == -1)
            return -1;
        if(tabuleiro.checaColunas() == -1)
            return -1;
        if(tabuleiro.checaDiagonais() == -1)
            return -1;

        return 0;
    }
}
