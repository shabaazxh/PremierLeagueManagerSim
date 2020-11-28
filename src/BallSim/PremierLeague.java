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

        PremierLeagueManager PLM = new PremierLeagueManager();
        readFile resumeProgram = new readFile("save.txt",PLM.clubs);

        PLM.menu();

        /* dowhile to allow multiple functionality through menu */
        do {
            menuSelector = PLM.userInput.nextLine().toUpperCase();
            switch(menuSelector){
                case "A":
                    PLM.writeInput.appendString(menuSelector);
                    PLM.addClub();
                    break;
                case "V":
                    PLM.writeInput.appendString(menuSelector);
                    PLM.displayClubs(PLM.clubs);
                    break;
                case "D":
                    PLM.writeInput.appendString(menuSelector);
                    PLM.deleteClub(PLM.clubs);
                    break;
                case "S":
                    PLM.writeInput.appendString(menuSelector);
                    PLM.addMatchStatistic(PLM.clubs);
                    break;
                case "F":
                    PLM.writeInput.appendString(menuSelector);
                    PLM.viewStatistics(PLM.clubs);
                    break;
                case "E":
                    PLM.writeInput.appendString(menuSelector);
                    PLM.writeInput.storeClubs(PLM.clubs);
                    break;
                case "G":
                    PLM.writeInput.appendString(menuSelector);
                    GUInterface GUI = new GUInterface(PLM);
                    break;
                case "Q":
                    PLM.writeInput.appendString(menuSelector);
                    PLM.writeInput.closeFile();
                    System.exit(0);
                    break;

                default:
                    break;
            }
        } while(menuSelector != "q");
    }


}
