package BallSim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class PremierLeague {

    public static void main(String[] args) {
        /* Display user menu, select from menu */

        String menuSelector;

        Scanner selectfromMenu = new Scanner(System.in);
        fileWrite writer = new fileWrite();
        PremierLeagueManager PLM = new PremierLeagueManager();
        PLM.menu();

        /* dowhile to allow multiple functionality through menu */
        do {
            menuSelector = PLM.userInput.nextLine().toUpperCase();
            switch(menuSelector){
                case "A":
                    PLM.addClub();
                    break;
                case "V":
                    PLM.displayClubs(PLM.clubs);
                    break;
                case "D":
                    PLM.deleteClub(PLM.clubs);
                    break;
                case "S":
                    PLM.addMatchStatistic(PLM.clubs);
                    break;
                case "F":
                    PLM.displayStatistics(PLM.clubs);
                    break;
                case "G":
                    GUInterface GUI = new GUInterface(PLM);
                    break;
                case "E":
                    writer.storeClubs(PLM.clubs);
                    break;
                case "Q":
                    System.exit(0);
                    break;

                default:
                    break;
            }
        } while(menuSelector != "q");
    }


}
