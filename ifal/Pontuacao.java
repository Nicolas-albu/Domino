package ifal;

public class Pontuacao {
    public int punctuation(int[] sidesOfPiece){
      if(sidesOfPiece[0] == sidesOfPiece[1]){
        return 4*sidesOfPiece[0]; // 2*(1 + 1) = 2*(2*1) = 4*1 = 4
      }
      else if(sidesOfPiece[0] % 2 != 0 && sidesOfPiece[1] % 2 != 0 && sidesOfPiece[0] != sidesOfPiece[1]) {
          return (2*Math.max(sidesOfPiece[0], sidesOfPiece[1]) - Math.min(sidesOfPiece[0], sidesOfPiece[1]));
      }
      else{
        return (sidesOfPiece[0] + sidesOfPiece[1]);
      }
    }

    public int[] evaluatesScores(int pontOne, int pontTwo, int pontThree){
      int[] maxFinal  = new int[3]; //[jogador 1, jogador 2, jogador 3]
      int decisionOfPosition;

      if(pontOne > pontTwo && pontOne > pontThree){
        maxFinal[0] = 3; // pontOne foi o maior de todos

        decisionOfPosition = (Math.max(pontTwo, pontThree) == pontTwo) ? 1 : 2;
        maxFinal[decisionOfPosition] = 2;

        decisionOfPosition = (Math.min(pontTwo, pontThree) == pontThree) ? 2 : 1;
        maxFinal[decisionOfPosition] = 1;
        
      } else if(pontTwo > pontOne && pontTwo > pontThree){
        maxFinal[1] = 3;

        decisionOfPosition = (Math.max(pontOne, pontThree) == pontOne) ? 0 : 2;
        maxFinal[decisionOfPosition] = 2;

        decisionOfPosition = (Math.min(pontOne, pontThree) == pontThree) ? 2 : 0;
        maxFinal[decisionOfPosition] = 1;

      } else{
        maxFinal[2] = 3;

        decisionOfPosition = (Math.max(pontOne, pontTwo) == pontOne) ? 0 : 1;
        maxFinal[decisionOfPosition] = 2;

        decisionOfPosition = (Math.min(pontOne, pontTwo) == pontTwo) ? 1 : 0;
        maxFinal[decisionOfPosition] = 1;
      }

      if(pontOne == pontTwo && pontOne == pontThree){
        maxFinal[0] = maxFinal[1] = maxFinal[2] = 2;
      } else if(pontOne == pontTwo && pontTwo > pontThree){
        maxFinal[0] = 2; maxFinal[1] = 2; maxFinal[2] = 1;
      } else if(pontTwo == pontThree && pontThree > pontOne){
        maxFinal[0] = 1; maxFinal[1] = 2; maxFinal[2] = 2;
      } else if(pontOne == pontThree && pontOne > pontTwo){
        maxFinal[0] = 2; maxFinal[1] = 1; maxFinal[2] = 2;
      } else if(pontOne == pontTwo && pontTwo < pontThree){
        maxFinal[0] = 2; maxFinal[1] = 2; maxFinal[2] = 3;
      } else if(pontTwo == pontThree && pontThree < pontOne){
        maxFinal[0] = 3; maxFinal[1] = 2; maxFinal[2] = 2;
      } else if(pontOne == pontThree && pontOne < pontTwo){
        maxFinal[0] = 2; maxFinal[1] = 3; maxFinal[2] = 2;
      }

      return maxFinal;
    }

    public void addRanking(int[][] arrayRanking, Jogador[] arrayPlayers){
      int assistanceName;
      int assistancePoint;

      for(int numberPlayer = 0; numberPlayer < arrayPlayers.length; numberPlayer++){
          arrayRanking[numberPlayer][0] = numberPlayer;
          arrayRanking[numberPlayer][1] = arrayPlayers[numberPlayer].getPunctuation();
      }

      for (int player = 0; player < arrayPlayers.length; player++) {
          for (int otherPlayer = 0; otherPlayer < arrayPlayers.length; otherPlayer++) {
              if (arrayRanking[player][1] > arrayRanking[otherPlayer][1]) {
                  assistanceName = arrayRanking[player][0];
                  assistancePoint = arrayRanking[player][1];
                  arrayRanking[player][0] = arrayRanking[otherPlayer][0];
                  arrayRanking[player][1] = arrayRanking[otherPlayer][1];
                  arrayRanking[otherPlayer][0] = assistanceName;
                  arrayRanking[otherPlayer][1] = assistancePoint;
              }
          }
      }
    }
}