package BallSim;
import java.io.*;
import java.util.*;


public class fileWrite {

    /* Init writing file PrintWriter objects */
    PrintWriter outFile;
    PrintWriter writeUserInput;

    {
        /* init writer to store all user input */
    try{
        writeUserInput = new PrintWriter("userinput.txt");
    } catch (FileNotFoundException e){
        System.out.println("File failed to be created to store user input");
    }
        /* init writer to store all footclubs current in the league */
        try {
            outFile = new PrintWriter("footclubs.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File failed to be created.");
        }
    }

    public fileWrite()  {

    }

    /* Append a String to the file */
    public void appendString(String s)
    {
        writeUserInput.write(s+"\n");
        writeUserInput.flush();
    }
    /* Append an Int to the file */
    public void appendInt(int number)
    {
        writeUserInput.print(number+"\n");
        writeUserInput.flush();
    }
    /* Loop through clubs array and save all information regarding clubs inside file */
    public void storeClubs(ArrayList<FootballClub> footballClubsList)
    {
        for(FootballClub x: footballClubsList)
        {
            outFile.println(x.toString());
        }
        outFile.close();
    }
    /* Close the file writing object */
    public void closeFile()
    {
        outFile.close();
    }

}
