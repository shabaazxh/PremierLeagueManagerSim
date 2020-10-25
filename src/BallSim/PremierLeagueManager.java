package BallSim;

import someTesting.Club;

import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {

    /* Adding clubs to PremierLeague through array */
    protected FootballClub[] clubs = new FootballClub[20];
    private int i = 0; //Increment this value to ensure it's smaller than array length

    /* Adding football clubs to the Premier League */
    public void addClub() {
        System.out.println("Name of the club? ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        FootballClub club = new FootballClub();
        club.setClubName(input);

        if(i<clubs.length)
        {
            clubs[i] = club;
            System.out.println(club.getClubName() + " Added to the Premier League");
            i++;
        }
    }

    /* Delete a football club from the Premier League */
    public void deleteClub(FootballClub removeClub[]) {

        System.out.println("Type the name of the club you wish to delete: ");
        Scanner remove = new Scanner(System.in);
        String delete = remove.nextLine();

        for(int x = 0; x < removeClub.length; x++)
        {
            try{
                if(delete.equals(removeClub[x].getClubName()))
                    System.out.println(removeClub[x].getClubName() + " removed");
                try{
                    removeClub[x] = null;
                    i--;
                } catch (NullPointerException e)
                {
                    return;
                }

            } catch (NullPointerException e)
            {
                return;
            }

        }

    }

    /* Display all teams in the Premier League */
    public void displayClubs(FootballClub displayClubs[]) {

        System.out.println("All teams currently in the Premier League: ");
        for(FootballClub x: displayClubs)
        {
            try {
                System.out.println(x.print());
            } catch (NullPointerException e)
            {
                return;
            }
        }
    }

    public void addMatch() {

    }

    public void saveInput() {

    }

    public void readFileResume(String input) {

    }

    protected void menu() {
        System.out.println("Press 'A' to add a team");
        System.out.println("Press 'S' to display all teams");
        System.out.println("Press 'D' to delete a team");
        System.out.println("Press 'Q' to quit out this menu");
    }
}