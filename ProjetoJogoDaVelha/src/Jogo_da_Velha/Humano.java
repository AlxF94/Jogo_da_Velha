package Jogo_da_Velha;

import java.util.Scanner;

public class Humano extends Jogador {

    public Scanner entrada = new Scanner(System.in);
//criação de jogador humano.
    public Humano(int jogador){
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador 'Humano' criado!");
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }

    @Override
    // comando tentativa, que sera ativado, quando o jogador fizer uma jogada invalida.
    public void Tentativa(Tabuleiro tabuleiro) {
        do{
            do{
                System.out.println("Linha: ");
                tentativa[0] = entrada.nextInt();

                if(tentativa[0] > 3 || tentativa[0] < 1)
                    System.out.println("Linha invalida. jogue 1, 2 ou 3");
            }while(tentativa[0] > 3 || tentativa[0] < 1);

            do{
                System.out.println("Coluna: ");
                tentativa[1] = entrada.nextInt();

                if(tentativa[1] > 3 || tentativa[1] < 1)
                    System.out.println("Coluna invalida. jogue 1, 2 ou 3");
            }while(tentativa[1] >3 || tentativa[1] < 1);

            tentativa[0]--;
            tentativa[1]--;

            if(!checarTentativa(tentativa, tabuleiro))
                System.out.println("Esse local ja, foi marcado. Tente outro.");
        }while(!checarTentativa(tentativa, tabuleiro));
    }
}
