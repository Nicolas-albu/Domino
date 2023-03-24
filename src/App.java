package src;

import java.util.Scanner;

import pieces.Piece;
import system.Jogador;
import system.Pontuacao;

public class App {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int[][] ranking = new int[3][2];

        Pontuacao createPunctuation = new Pontuacao();
        Jogador[] players = new Jogador[3];
        Piece Piece = new Piece();
        
        System.out.print("Nome do jogador 1: ");
        players[0] = new Jogador(read.nextLine(), 0, false);

        System.out.print("Nome do jogador 2: ");
        players[1] = new Jogador(read.nextLine(), 0, false);

        players[2] = new Jogador("Computador", 0, false);

        for(int gameRound = 0; gameRound < 3; gameRound++){
            players[0].piece = Piece.createPeca();
            players[1].piece = Piece.createPeca();
            players[2].piece = Piece.createPeca();
            
            int[] arrayPunctuation = createPunctuation.evaluatesScores(createPunctuation.punctuation(players[0].piece), createPunctuation.punctuation(players[1].piece), createPunctuation.punctuation(players[2].piece));

            for(int positionOfPlayers = 0; positionOfPlayers < arrayPunctuation.length; positionOfPlayers++){
                players[positionOfPlayers].setPunctuation(arrayPunctuation[positionOfPlayers]);
            }
    
            System.out.println("\nRODADA " + (gameRound + 1) + ":");

            for(int player = 0; player < players.length; player++){
                System.out.println(players[player].getName() + ": " + Piece.createVisuatizationPiece(players[player].piece));
                System.out.println("Avaliação da pedra " + Piece.createVisuatizationPiece(players[player].piece) + ": " + createPunctuation.punctuation(players[player].piece) + "\n");
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