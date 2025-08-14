public class Arqueiro extends Peca {
    public Arqueiro(int posicaoX, int posicaoY, Jogador jogadorDono){
        super("Arqueiro", "A", posicaoX, posicaoY, jogadorDono); //add o emoji dps
    }
    @Override
    public boolean podeMoverPara(int novoX, int novoY, Peca[][] tabuleiro){
        int distancia = Math.abs(novoX - getPosicaoX());

        boolean movimentoDiagonal = Math.abs(novoX - getPosicaoX()) == Math.abs(novoY - getPosicaoY());

        return movimentoDiagonal && (distancia <= 2);
    }
}
