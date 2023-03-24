package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import pieces.NormalPiece;
import system.Pontuacao;
import system.Jogador;

public class App {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int[][] ranking = new int[3][2];

        Pontuacao createPunctuation = new Pontuacao();
         
        List<Jogador> players = new ArrayList<>();
        NormalPiece normalPiece = new NormalPiece();
        
        System.out.print("Nome do jogador 1: ");
        players.add(new Jogador(read.nextLine(), 0, false));

        System.out.print("Nome do jogador 2: ");
        players.add(new Jogador(read.nextLine(), 0, false));

        players.add(new Jogador("Computador", 0, false));

        for(int gameRound = 0; gameRound < 3; gameRound++){
            players.get(0).piece = normalPiece.generatePiece();
            players.get(1).piece = normalPiece.generatePiece();
            players.get(2).piece = normalPiece.generatePiece();
            
            int[] arrayPunctuation = createPunctuation.evaluatesScores(createPunctuation.punctuation(players[0].piece), createPunctuation.punctuation(players[1].piece), createPunctuation.punctuation(players[2].piece));

            for(int positionOfPlayers = 0; positionOfPlayers < arrayPunctuation.length; positionOfPlayers++){
                players[positionOfPlayers].setPunctuation(arrayPunctuation[positionOfPlayers]);
            }
    
            System.out.println("\nRODADA " + (gameRound + 1) + ":");

            for(int player = 0; player < players.length; player++){
                System.out.println(players[player].getName() + ": " + normalPiece.createVisuatizationpiece(players[player].piece));
                System.out.println("Avaliação da pedra " + normalPiece.createVisuatizationpiece(players[player].piece) + ": " + createPunctuation.punctuation(players[player].piece) + "\n");
            }
    
            System.out.println("Nesta rodada:");
            for(int i = 0; i < players.length; i++){
                System.out.println(players[i].getName() + " ganhou " + arrayPunctuation[i] + " pontos");    
            }

            System.out.print("Tecle ENTER para presseguir para a próxima rodada. ");
            String enter = read.nextLine(); 
        }

        System.out.println("\n======== RANKING FINAL ========");

        createPunctuation.addRanking(ranking, players);

        for (int positionPlayer = 0; positionPlayer < players.length; positionPlayer++) {
            System.out.println((positionPlayer + 1) + "º - " + players[positionPlayer].getName() + " com " + ranking[positionPlayer][1] + " pontos");
        }
        System.out.println("===============================\n");
    }
}