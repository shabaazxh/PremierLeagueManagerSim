package BallSim;

import java.util.ArrayList;

public interface LeagueManager {

    void addClub();
    void deleteClub(ArrayList<FootballClub> removeClub);
    void addMatchStatistic(ArrayList<FootballClub> addStats);
    void displayClubs(ArrayList<FootballClub> display);
    void viewStatistics(ArrayList<FootballClub> showStats);

}
