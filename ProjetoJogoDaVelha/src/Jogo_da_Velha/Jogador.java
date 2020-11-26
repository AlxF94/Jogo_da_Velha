package Jogo_da_Velha;

public abstract  class Jogador {

    protected int[] tentativa = new int[2];
    protected int jogador;

    public Jogador(int jogador){
        this.jogador = jogador;
    }
// verifica��o da jogada que o jogador humano pode fazer.
    public abstract void jogar(Tabuleiro tabuleiro);

    public abstract void Tentativa(Tabuleiro tabuleiro);

    public boolean checarTentativa(int[] tentativa, Tabuleiro tabuleiro){
        if(tabuleiro.getPosicao(tentativa) == 0)
            return true;
        else
            return false;
    }

}