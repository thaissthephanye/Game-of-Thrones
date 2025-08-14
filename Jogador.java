import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Peca> pecas;
    private boolean primeiroJogador; //se for false é o jogador 2 se for true é o jogador 1 ainda n sei se isso da certo

    public Jogador(String nome, boolean primeiroJogador){
        this.nome = nome;
        this.pecas = new ArrayList<>();
        this.primeiroJogador = primeiroJogador;
    }

    public boolean temPecas(){
        return !pecas.isEmpty();
    }

    public void adicionarPeca(Peca peca){
        pecas.add(peca);
    }

    public void removerPeca(Peca peca){
        pecas.remove(peca);
    }

    public String getNome(){
        return nome;
    }

    public void mostrarPecas(){
        System.out.println("Peças de " + nome + ":"); 
    }

}
