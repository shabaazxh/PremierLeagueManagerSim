package BallSim;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {

    readFile(String saveFile, ArrayList<FootballClub> addPrevious)
    {
        try {
            Scanner read = new Scanner(new File(saveFile));

            while(read.hasNextLine())
            {
                String line = read.nextLine();
                String[] splitContents = line.split(" ");

                FootballClub addClub = new FootballClub(splitContents[0],
                        Integer.parseInt(splitContents[1]), Integer.parseInt(splitContents[2]), Integer.parseInt(splitContents[3]));
                addPrevious.add(addClub);
                System.out.print("Previous restored ");
                System.out.print(line +"\n");

                for( FootballClub x: addPrevious)
                {
                    if(x.getClubName().equals(splitContents[0]))
                    {
                        x.goals = x.goals + Integer.parseInt(splitContents[1]);
                        x.points = x.points + Integer.parseInt(splitContents[2]);
                        x.wins = x.wins + Integer.parseInt(splitContents[3]);
                    }
                }

            }
        } catch (FileNotFoundException e)
        {
            System.out.print(" Error: Could not find the file to resume program.");
        }
    }

}
