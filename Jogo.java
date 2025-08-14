import java.util.Scanner;

public class Jogo {
    private Peca[][] tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private Scanner scanner;

    public Jogo(){
        tabuleiro = new Peca[8][8];
        scanner = new Scanner(System.in);

        System.out.print("Nome do jogador 1: ");
        jogador1 = new Jogador(scanner.nextLine(), true);

        System.out.print("Nome do jogador 2: ");
        jogador2 = new Jogador(scanner.nextLine(), false);

        jogadorAtual = jogador1; 

        posicionarPecasIniciais();

    } 

    public void posicionarPecasIniciais(){
        tabuleiro[0][0] = new Guerreiro(0, 0, jogador1);
        tabuleiro[1][0] = new Arqueiro(1, 0, jogador1);
        tabuleiro[2][0] = new Cavaleiro(2, 0, jogador1);

        tabuleiro[0][7] = new Guerreiro(0, 7, jogador2);
        tabuleiro[1][7] = new Arqueiro(1, 7, jogador2);
        tabuleiro[2][7] = new Cavaleiro(2, 7, jogador2);

        for(int x = 0; x < 3; x++){
            jogador1.adicionarPeca(tabuleiro[x][0]);
            jogador2.adicionarPeca(tabuleiro[x][7]);
        }
    }

    public void mostrarTabuleiro(){
        System.out.println("\n [0][1][2][3][4][5][6][7]");
        for (int y = 0; y < 8; y++) {
            System.out.print("[" + y + "]");
            for(int x = 0; x < 8; x++){
                Peca peca = tabuleiro[x][y];
                System.out.print(peca != null ? "[" + peca.getSimbolo() + "]" : "[ ]");
            }
            System.out.println();
        }
    }

    public void processarTurno(){
        while(true){
            System.out.print("Escolha uma peça (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(x < 0 || x > 7 || y < 0 || y > 7){
                System.out.println("Posição inválida! use valores de 0 a 7.");
                continue;
            }

            Peca peca = tabuleiro[x][y];

            if(peca == null){
                System.out.println("Não há peças nessa posição.");
                continue;
            }
            if(peca.getJogadoDono() != jogadorAtual){
                System.out.println("Essa peça não é sua, movimente apenas as suas peças!");
                continue;
            }

            //pedir a nova posicao
            System.out.print("MOver para (x y): ");
            int novoX = scanner.nextInt();
            int novoY = scanner.nextInt();

            if(novoX < 0 || novoX > 7 || novoY < 0 || novoY > 7){
                System.out.println("Posição inválida! Use valores de 0 a 7.");
                continue;
            }

            if(peca.moverPara(novoX, novoY, tabuleiro)){
                break;
            } else {
                System.out.println("Movimento inválido para a peça " + peca.getNome());
            }
        }
    }

    public void iniciar(){
        System.out.println("=== Game of Thrones ===");

        while (true) { 
            mostrarTabuleiro();

            if(!jogador1.temPecas()){
                System.out.println(jogador2.getNome() + "venceu o jogo!");
                break;
            }

            if(!jogador2.temPecas()){
                System.out.println(jogador1.getNome() + "venceu o jogo!");
                break;
            }

            System.out.println("\nVez de " + jogadorAtual.getNome());
            processarTurno();

            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        }

        System.out.println("Fim de jogo.");
    }
 
}
