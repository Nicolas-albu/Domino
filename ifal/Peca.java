package ifal;

import java.util.Random;

public class Peca {

    public int[] createPeca(){
        Random randomValue = new Random();
        
        int[] piece = new int[2];

        piece[0] = randomValue.nextInt(7); // de 0 a 7-1
        piece[1] = randomValue.nextInt(7);

        return piece;
    }

    public String createVisuatizationPiece(int[] piece){
        return "[" + piece[0] + ":" + piece[1] + "]";        
    }
}