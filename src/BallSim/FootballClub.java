package BallSim;

import test.Item;

public class FootballClub extends SportsClub implements Comparable <FootballClub> {

    int wins = 0;
    int goals = 0;
    int points = 0;
    String matchDate;

    FootballClub(String name, int wins, int goals, int points)
    {
        // Calls constructor of SportsClub, passing name from this constructor as name for club
        super(name);
    }
    public void setWins(int setWins)
    {
        wins = setWins;
    }
    public void setPoints(int setPoints)
    {
        points = setPoints;
    }

    public int getWins()
    {
        return wins;
    }

    public int getGoals()
    {
        return goals;
    }

    public int getPoints()
    {
        return points;
    }

    public String getMatchDate()
    {
        return matchDate;
    }

    @Override
    public int compareTo(FootballClub o) {
        int compareGoals=((FootballClub)o).getGoals();
        return this.goals-compareGoals;
    }

    public int compareToWins(FootballClub o) {
        int compareWins=((FootballClub)o).getWins();
        return this.wins-compareWins;
    }

    public String toString()
    {
       //return "Club: " + clubName + ": Goals: " + goals + " Points: " + points + " Wins: " + wins;
       return clubName + " " + goals + " " +  points + " " + wins;
    }


/*    public int compareTo(Item o) {

        int compareWins=((Item)o).getWins();
        return this.wins-compareWins; // descending order
        //return compareWins-this.wins; // ascending order
    }*/
}
