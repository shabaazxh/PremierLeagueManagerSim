package BallSim;

import java.util.Scanner;

public class PremierLeague {


    public static void main(String[] args) {

        /* Display user menu, select from menu */
        String menuSelect;
        Scanner selectfromMenu = new Scanner(System.in);
        PremierLeagueManager PLM = new PremierLeagueManager();
        PLM.menu();

        /* dowhile to allow multiple functionality through menu */
        do {
            menuSelect = selectfromMenu.nextLine().toUpperCase();
            switch(menuSelect){
                case "A":
                    PLM.addClub();
                    break;
                case "S":
                    PLM.displayClubs(PLM.clubs);
                    break;
                case "D":
                    PLM.deleteClub(PLM.clubs);
                    break;
                case "Q":
                    System.exit(0);
                    break;

                default:
                    break;
            }
        } while(menuSelect != "q");
    }


}
