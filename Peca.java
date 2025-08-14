public abstract class Peca{

    private String nome;
    private String simbolo;
    private int posicaoX;
    private int posicaoY;
    private Jogador jogadorDono;

    public Peca(String nome, String simbolo, int posicaoX, int posicaoY, Jogador jogadorDono){
        this.nome = nome;
        this.simbolo = simbolo;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.jogadorDono = jogadorDono;

    }

    //getters
    public String getNome(){
        return nome;
    }
    public String getSimbolo(){
        return simbolo;
    }
    public int getPosicaoX(){
        return posicaoX;
    }
    public int getPosicaoY(){
        return posicaoY;
    }
    public Jogador getJogadoDono(){
        return jogadorDono;
    }

    //setts
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setSimbolo(String simbolo){
        this.simbolo = simbolo;
    }
    public void setPosicaoX(int posicaoX){
        this.posicaoX = posicaoX;
    }
    public void setPosicaoY(int posicaoY){
        this.posicaoY = posicaoY;
    }
    public void setJogadorDono(Jogador jogadorDono){
        this.jogadorDono = jogadorDono;
    }
 
    // metodo abstrato
    //ainda n sei oq fazer aqui
    public abstract boolean podeMoverPara(int novoX, int novoY, Peca[][] tabuleiro);
    
    
    
    public boolean moverPara(int novoX, int novoY, Peca[][] tabuleiro){
        if (novoX < 0 || novoX > 7 || novoY < 0 || novoY > 7){
            System.out.println("Posição fora do tabuleiro!");
            return false;
        }

        if(!podeMoverPara(novoX, novoY, tabuleiro)){
            System.out.println("Movimento inválido para " + this.nome);
            return false;
        }

        
        Peca pecaAlvo = tabuleiro[novoX][novoY];

        if(pecaAlvo != null && pecaAlvo.getJogadoDono().equals(this.jogadorDono)){
            System.out.println("Você já tem uma peça nessa posição.");
            return false;
        }
        //captura
        if(pecaAlvo != null && !pecaAlvo.getJogadoDono().equals(this.jogadorDono)){
            System.out.println(this.nome + " capturou " + pecaAlvo.getNome());
            pecaAlvo.getJogadoDono().removerPeca(pecaAlvo);
        }

        //att posicao
        tabuleiro[this.posicaoX][this.posicaoY] = null;
        this.posicaoX = novoX;
        this.posicaoY = novoY;
        tabuleiro[novoX][novoY] = this;

        return true;
        

    }

    

}
