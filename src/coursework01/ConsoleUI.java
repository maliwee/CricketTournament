package coursework01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    public static ConsoleUI cricket = new ConsoleUI();
    public static void main(String[] args) {
        cricket.main();
    }
    private void main() {
        Team[] teams = new Team[10];
        for(int i=0; i<10; i++){
            Team t = new Team();
            t.setTeamName("Team "+i+1);
            teams[i] = t;
        }
        //
        System.out.println("Please add player details");
        Scanner uInput = new Scanner(System.in);
        System.out.print("Continue? [Y/N] :");
        String response = uInput.nextLine();
        if(response.equals("Y")){
            inputPlayerDetails(teams);
            inputMatchRecords(teams);
            showMenu(teams);
        }else if (response.equals("N")){
            System.exit(0);
            //finish
        }else{
            System.out.println("Invalid Response!");
            main();
        }

}

    static void inputPlayerDetails(Team[] teams){
        while(true){
            Scanner teamInput = new Scanner(System.in);
            System.out.print("Enter the team number : ");
            int teamNumber = teamInput.nextInt();
            while (teamNumber<0){
                System.out.println("Invalid Input!");
                System.out.print("Enter the team number : ");
                teamNumber = teamInput.nextInt();
            }

            Scanner playerDetailsInput = new Scanner(System.in);
            System.out.print("Enter the player name : ");
            String pName = playerDetailsInput.nextLine();
            while (!pName.matches("[a-zA-Z]+")){
                System.out.println("Invalid Input");
                System.out.print("Enter the player name : ");
                pName = playerDetailsInput.nextLine();
            }

            System.out.print("Enter the player age : ");
            int pAge = Integer.parseInt(playerDetailsInput.nextLine());
            while (pAge<0){
                System.out.println("Invalid Input!");
                System.out.print("Enter the player age : ");
                pAge = Integer.parseInt(playerDetailsInput.nextLine());
            }
            System.out.print("Enter the player role : ");
            String pRole = playerDetailsInput.nextLine();
            while (!pRole.matches("[a-zA-Z]+")){
                System.out.println("Invalid Input");
                System.out.print("Enter the player role : ");
                pRole = playerDetailsInput.nextLine();
            }

            Player p = new Player();
            p.setName(pName);
            p.setRole(pRole);
            p.setAge(pAge);

            teams[teamNumber-1].addPlayer(p);

            System.out.println("Player added");
            System.out.println("Team "+teamNumber+" has "+teams[teamNumber-1].getPlayerCount()+" players");

            System.out.println("Continue Adding Players?[Y/N]");
            Scanner teamInput2 = new Scanner(System.in);
            String response = teamInput2.nextLine();
            if(response.equals("Y")){
                //do nothing
            }else{
                System.out.println("Finished adding players");
                break;
            }
        }
    }
    static void inputMatchRecords(Team[] teams){
        while(true){
            System.out.println("Entering Player Records...");
            Scanner teamInput = new Scanner(System.in);
            System.out.print("Enter the team number : ");
            int teamNumber = teamInput.nextInt();
            while (teamNumber<0){
                System.out.println("Invalid Input!");
                System.out.print("Enter the team number : ");
                teamNumber =teamInput.nextInt();
            }

            System.out.print("Enter the player number : ");
            int playerNumber = teamInput.nextInt();
            while (playerNumber<0){
                System.out.println("Invalid Input!");
                System.out.print("Enter the player number : ");
                playerNumber =teamInput.nextInt();
            }
            Scanner matchRecordsInput = new Scanner(System.in);
            System.out.print("Enter the player Runs : ");
            int pRuns = Integer.parseInt(matchRecordsInput.nextLine());
            while (pRuns<0){
                System.out.println("Invalid Input!");
                System.out.print("Enter the player Runs : ");
                pRuns =Integer.parseInt(matchRecordsInput.nextLine());
            }
            System.out.print("Enter the boundaries : ");
            int pBoundaries = Integer.parseInt(matchRecordsInput.nextLine());
            while (pBoundaries<0){
                System.out.println("Invalid Input!");
                System.out.print("Enter the boundaries : ");
                pBoundaries =Integer.parseInt(matchRecordsInput.nextLine());
            }
            System.out.print("Enter the player strikeRate : ");
            double pStrikeRate = Double.parseDouble(matchRecordsInput.nextLine());
            while (pStrikeRate<0){
                System.out.println("Invalid Input!");
                System.out.print("Enter the boundaries : ");
                pStrikeRate =Double.parseDouble(matchRecordsInput.nextLine());
            }
            System.out.print("Enter the player Remarks (Any important incident that needs to record)  : ");
            String  pRemarks = matchRecordsInput.nextLine();
            while (!pRemarks.matches("[a-zA-Z]+")){
                System.out.println("Invalid Input");
                System.out.print("Enter the player Remarks (Any important incident that needs to record)  : ");
                pRemarks = matchRecordsInput.nextLine();
            }


            System.out.print("Enter the Venue : ");
            String matchVenue = matchRecordsInput.nextLine();
            while (!matchVenue.matches("[a-zA-Z]+")){
                System.out.println("Invalid Input");
                System.out.print("Enter the Venue : ");
                matchVenue = matchRecordsInput.nextLine();
            }

            MatchRecord r = new MatchRecord();

            r.setRuns(pRuns);
            r.setBoundaries(pBoundaries);
            r.setStrikeRate(pStrikeRate);
            r.setRemarks(pRemarks);
            r.setVenue(matchVenue);

            teams[teamNumber-1].addMatchRecord(playerNumber,r);
            System.out.println("Player record added");

            System.out.println("Continue Adding Records?[Y/N]");
            Scanner teamInput2 = new Scanner(System.in);
            String response = teamInput2.nextLine();
            if(response =="Y"|| response=="y" ){
                //do nothing
            }else{
                System.out.println("Finished adding records");
                break;
            }
        }
}

    static void showMenu(Team[] teams) {
        while(true){
            Scanner userInput = new Scanner(System.in);

            System.out.println("<===Select an option===>");
            System.out.println("Enter 1 for display the player who scored the highest total marks during the tournament");
            System.out.println("Enter 2 for display the player with the highest boundaries during the tournament");
            System.out.println("Enter 3 to view all players of a certain team");
            System.out.println("Enter 4 to view view all winners");
            System.out.println("Enter 5 to view match information ");
            System.out.println("Enter 0 to end the programme");
            System.out.print("============================\n Enter your option here: ");

            int option = userInput.nextInt();
            System.out.println("============================");

            switch (option) {
                case 1: {
                    System.out.println("<===The player who scored the highest total marks during the tournament===>");
                    Player highestTotal = getHighestTotal(teams);
                    System.out.println("Player Name:"+highestTotal.getName());
                    System.out.println("Player Team:"+highestTotal.getTeamName());
                    System.out.println("Player Age:"+highestTotal.getAge());
                    break;
                }
                case 2: {
                    System.out.println("<===The player with the highest boundaries during the tournament===>");
                    Player highestBoundaries = getHighestBoundaries(teams);
                    System.out.println("Player Name:"+highestBoundaries.getName());
                    System.out.println("Player Team:"+highestBoundaries.getTeamName());
                    System.out.println("Player Age:"+highestBoundaries.getAge());
                    break;

                }
                case 3: {
                    Scanner userInput1 = new Scanner(System.in);
                    System.out.print("Enter the team number : ");
                    int teamNumber = userInput1.nextInt();

                    for(int i = 0; i<11; i++){
                        Player p = teams[teamNumber-1].getPlayer(i);
                        if(p != null){
                            System.out.println("Player Name:"+p.getName());
                            System.out.println("Player Team:"+p.getTeamName());
                            System.out.println("Player Age:"+p.getAge());
                            System.out.println("Player Role:"+p.getRole());
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("<===The player who scored the highest total marks during the tournament===>");
                    Player highestTotal = getHighestTotal(teams);
                    System.out.println("Player Name:"+highestTotal.getName());
                    System.out.println("Player Team:"+highestTotal.getTeamName());
                    System.out.println("Player Age:"+highestTotal.getAge());
                    System.out.println("<============================================================================>");

                    System.out.println("<===The player with the highest boundaries during the tournament===>");
                    Player highestBoundaries = getHighestBoundaries(teams);
                    System.out.println("Player Name:"+highestBoundaries.getName());
                    System.out.println("Player Team:"+highestBoundaries.getTeamName());
                    System.out.println("Player Age:"+highestBoundaries.getAge());
                    System.out.println("<============================================================================>");
                    break;



                }
                case 5: {
                    Scanner userInput2 = new Scanner(System.in);
                    System.out.print("Enter the team number : ");
                    int teamNumber = userInput2.nextInt();

                    Scanner userInput3 = new Scanner(System.in);
                    System.out.print("Enter the player number : ");
                    int playerNumber = userInput3.nextInt();


                    ArrayList<MatchRecord> records = teams[teamNumber-1].getPlayer(playerNumber-1).getRecords();
                    for(MatchRecord m : records){
                        System.out.println("Runs: "+m.getRuns());
                        System.out.println("Boundaries: "+m.getBoundaries());
                        System.out.println("Strike Rate: "+m.getStrikeRate());
                        System.out.println("Remarks: "+m.getRemarks());
                        System.out.println("Venue: "+m.getVenue());

                    }
                    break;
                }

                case 0: {
                    System.out.println("Programme has ended!");
                    System.out.println("============================");
                    System.exit(0);





                }

                default: {
                    System.out.println("Please Enter a Valid Choice");
                    System.out.println("============================");

                }
            }
        }
    }

    static Player getHighestTotal(Team[] teams){
        Player[] topScorers = new Player[10];
        for(int i=0;i<10;i++){
            topScorers[i] = teams[i].topScorer();
        }
        int max = 0;
        int maxIndex = 0;
        for(int i=0; i <10; i++){
            if(topScorers[i] != null){
                if (topScorers[i].getTotalMarks() > max){
                    max = topScorers[i].getTotalMarks();
                    maxIndex = i;
                }
            }
        }
        return topScorers[maxIndex];
    }

    static Player getHighestBoundaries(Team[] teams){
        Player[] topBoundaries = new Player[10];
        for(int i=0;i<10;i++){
            topBoundaries[i] = teams[i].topBoundaries();
        }
        int max = 0;
        int maxIndex = 0;
        for(int i=0; i <10; i++){
            if(topBoundaries[i] != null){
                if (topBoundaries[i].getBoundariesCount() > max){
                    max = topBoundaries[i].getBoundariesCount();
                    maxIndex = i;
                }
            }
        }
        return topBoundaries[maxIndex];
    }


}
