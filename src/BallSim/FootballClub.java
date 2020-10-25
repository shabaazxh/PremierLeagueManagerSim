package BallSim;

public class FootballClub extends SportsClub {

    int wins = 0;
    int goals = 0;
    int points = 0;

    FootballClub()
    {

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

    public String print()
    {
        return"Footclub name: "+clubName+","+" Number of wins: "+wins;
    }



}
