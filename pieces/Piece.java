package pieces;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public abstract class Piece {

    public List<Integer> createPiece(){
        List<Integer> piece = new ArrayList<>();
        Random randomValue = new Random();
        
        piece.add(randomValue.nextInt(7)); // de 0 a 7-1
        piece.add(randomValue.nextInt(7));

        return piece;
    }

    public String createVisuatizationPiece(int[] piece){
        return "[" + piece[0] + ":" + piece[1] + "]";        
    }

    public Piece(){}
}