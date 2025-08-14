public class Cavaleiro extends Peca {

    public Cavaleiro(int posicaoX, int posicaoY, Jogador dono){
        super("Cavaleiro", "C", posicaoX, posicaoY, dono);
    }

    @Override
    public boolean podeMoverPara(int novoX, int novoY, Peca[][] tabuleiro){
        int diferencaX = Math.abs(novoX - getPosicaoX());
        int diferencaY = Math.abs(novoY - getPosicaoY());

        //duas casas numa direcao e 1 em outra
        boolean movimentoEmL = (diferencaX == 2 && diferencaY == 1) || (diferencaX == 1 && diferencaY ==2);

        return movimentoEmL;
    }
}
