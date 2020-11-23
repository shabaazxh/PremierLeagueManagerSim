package BallSim;
import java.io.*;
import java.util.*;


public class fileWrite {

    PrintWriter outFile;

    {
        try {
            outFile = new PrintWriter("footclubs.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File failed to be created.");
        }
    }

    public fileWrite()  {

    }

    public void storeClubs(ArrayList<FootballClub> footballClubsList)
    {
        for(FootballClub x: footballClubsList)
        {
            outFile.println(x.toString());
        }
        outFile.close();
    }

}
