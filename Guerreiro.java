public class Guerreiro extends Peca {
    public Guerreiro(int posicaoX, int posicaoY, Jogador jogadorDono){
        super("Guerreiro", "G", posicaoX, posicaoY, jogadorDono);
    }


    @Override
    public boolean podeMoverPara(int novoX, int novoY, Peca[][] tabuleiro){
        int distanciaX = Math.abs(novoX - getPosicaoX());
        int distanciaY = Math.abs(novoY - getPosicaoY());

        boolean movimentoHorizontal = (distanciaY == 0) && (distanciaX <= 3);
        boolean movimentoVertical = (distanciaX == 0) && (distanciaY <=3);

        return movimentoHorizontal || movimentoVertical;
    }
}

