package system;

public class Jogador {
    private String name;
    private int punctuation;
    private boolean stateOnGame; // 1 para vencedor
    public int[] piece;
  
    public String getName(){
      return name;
    }
  
    public int getPunctuation(){
      return punctuation;
    }
  
    public boolean isStateOnGame(){
      return stateOnGame;
    }
    
    public void setName(String newName) {
      this.name = newName;
    }
  
    public void setPunctuation(int newPunctuation) {
      this.punctuation += newPunctuation;
    }
  
    public void setStateOnGame(boolean state) {
      this.stateOnGame = state;
    }

    public int winningPlayerPosition(int[] punctuationsOfPlayers){
      int position = 0;
      
      if(punctuationsOfPlayers[0] > punctuationsOfPlayers[1] && punctuationsOfPlayers[0] > punctuationsOfPlayers[2]){
        position = 0;
      } else if(punctuationsOfPlayers[1] > punctuationsOfPlayers[0] && punctuationsOfPlayers[1] > punctuationsOfPlayers[2]){
        position = 1;
      } else{
        position = 2;
      }

      return position;
    }
  
    public Jogador(String namePlayer, int punctuation, boolean state) {
      this.name = namePlayer;
      this.punctuation = punctuation;
      this.stateOnGame = state;
    }

    public Jogador(int punctuation, boolean state) {
      this.punctuation = punctuation;
      this.stateOnGame = state;
    }
  }