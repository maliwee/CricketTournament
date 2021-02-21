package coursework01;

import java.util.List;

public class Team {
    private String teamName;
    private Player[] playersList = new Player[11];
    private int playerCount = 0;

    public void setTeamName(String name){
        this.teamName = name;
    }

    public String getTeamName() { return this.teamName; }

    public int getPlayerCount() { return this.playerCount; }

    public void addPlayer(Player player){
        if(playerCount < 11){
            playersList[playerCount] = player;
            playersList[playerCount].setTeamName(this.teamName);
            playerCount++;
        }
    }

    public Player getPlayer(int index){
        return playersList[index];
    }

    public void addMatchRecord(int player, MatchRecord record){
        playersList[player-1].addMatchRecord(record);
    }

    public Player topScorer(){
        int max = 0;
        int maxIndex = 0;
        for(int i=0; i <11; i++){
            if(playersList[i] != null){
                if (playersList[i].getTotalMarks() > max){
                    max = playersList[i].getTotalMarks();
                    maxIndex = i;
                }
            }
        }
        return playersList[maxIndex];
    }

    public Player topBoundaries(){
        int max = 0;
        int maxIndex = 0;
        for(int i=0; i <11; i++){
            if(playersList[i] != null){
                if (playersList[i].getBoundariesCount() > max){
                    max = playersList[i].getBoundariesCount();
                    maxIndex = i;
                }
            }
        }
        return playersList[maxIndex];
    }
}
