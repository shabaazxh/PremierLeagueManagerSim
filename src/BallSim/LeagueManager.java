package BallSim;

public interface LeagueManager {

    void addClub();
    void deleteClub(FootballClub removeClub[]);
    void displayClubs(FootballClub displayClubs[]);
    void addMatch();
    void saveInput();
    void readFileResume(String input);

}
