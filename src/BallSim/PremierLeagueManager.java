package BallSim;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.*;
import java.util.Random;

public class PremierLeagueManager implements LeagueManager {

    fileWrite writeInput = new fileWrite();

    private RandomDate randDate = new RandomDate();
    protected Random randomGenerator = new Random();
    Scanner userInput = new Scanner(System.in);

    protected ArrayList<FootballClub> clubs = new ArrayList<FootballClub>();
    ArrayList<Matches> matchPlayed = new ArrayList<Matches>();
    DefaultTableModel model;
    JTable teamTable;

    public PremierLeagueManager() {
    }

    /* Adding football clubs to the Premier League */
    public void addClub() {
        System.out.println("Name of the club? ");
        String input = userInput.nextLine();

        writeInput.appendString(input);

        clubs.add(new FootballClub(input, 0, 0, 0));
        System.out.println(input + " has been added to the League.");
    }


    /* Delete a football club from the Premier League */
    public void deleteClub(ArrayList<FootballClub> removeClub) {

        System.out.println("Type the name of the club you wish to delete: ");
        String delete = userInput.nextLine();

        writeInput.appendString(delete);

        for(FootballClub x: removeClub)
        {
            if(x.getClubName().equals(delete)){
                removeClub.remove(x);
                break;
            }
        }

    }
    public void addMatchStatistic(ArrayList<FootballClub> addStats) {
        int team1Goals;
        int team2Goals;

        if (addStats.size() == 0) {
            System.out.println("There are no teams to add statistics to");
            return;
        } else {
            System.out.println("Match date? FORMAT: DD/MM/YYYY: ");
            String date = userInput.nextLine();

            writeInput.appendString(date); //Store date

            System.out.println("Team name: ");
            String team1 = userInput.nextLine();

            writeInput.appendString(team1); //Store first team entered

            System.out.println("Second team name: ");
            String team2 = userInput.nextLine();

            writeInput.appendString(team2); //Store second team entered

            /* Check if team name entered is a valid team in the club ArrayList */
            for(FootballClub checkTeam1: addStats)
            {
                if(checkTeam1.clubName.equals(team1))
                {
                    break;
                } else {
                    System.out.println(team1 + " team does not exist in the league, try again");
                    return;
                }
            }

            try {
                System.out.println("How many goals did " + team1 + " team score? ");
                team1Goals = userInput.nextInt();
                writeInput.appendInt(team1Goals); //Store first team goals

            } catch (InputMismatchException e) {
                System.out.println("This is not the correct value, try again.");
                return;
            }

            try {
                System.out.println("How many goals did " + team2 + " team score? ");
                team2Goals = userInput.nextInt();
                writeInput.appendInt(team2Goals); //Store second team goals

            } catch (InputMismatchException e) {
                System.out.println("This is not the correct value, try again.");
                return;
            }

            Matches match = new Matches(date, team1, team2, team1Goals, team2Goals);
            matchPlayed.add(match);

            for (FootballClub x : addStats) {
                x.matchDate = date;
                if (x.getClubName().equals(team1)) {
                    x.goals = x.goals + team1Goals;
                    if (team1Goals > team2Goals) {
                        x.points = x.points + 3;
                        x.wins = x.wins + 1;
                    } else if (team1Goals < team2Goals) {
                        x.points = x.points;
                    } else {
                        x.points = x.points + 1;
                    }
                }
            }

            for (FootballClub i : addStats) {
                i.matchDate = date;
                if (i.getClubName().equals(team2)) {
                    i.goals = i.goals + team2Goals;
                    if (team2Goals > team1Goals) {
                        i.points = i.points + 3;
                        i.wins = i.wins + 1;
                    } else if (team2Goals < team1Goals) {
                        i.points = i.points;
                    } else {
                        i.points = i.points + 1;
                    }
                }
            }
            System.out.println("Statistics updated for both teams");
        }
    }

    public void viewStatistics(ArrayList<FootballClub> showStats)
    {
        System.out.println("Team to view stats?: ");
        String teamInfo = userInput.nextLine();
        writeInput.appendString(teamInfo); //Store the name of the team user wanted to view statistics of

        for(FootballClub x: showStats)
        {
            if(x.getClubName().equals(teamInfo))
            {
                System.out.println("Club " + x.getClubName() + " Goals " +
                x.getGoals() + " Points " + x.getPoints() + " Wins " + x.getWins());
            }
        }
    }

    /* Display all teams in the Premier League */
    public void displayClubs(ArrayList<FootballClub> display) {

        Collections.sort(display, Collections.reverseOrder());
        if(display.isEmpty()) {
            System.out.println("There are no teams in the league");
        } else {

            System.out.println("Teams in the League");
            /*for(FootballClub x: display)
            {
                System.out.println(x.toString());
            }*/
            for(int i =0; i < display.size(); i++)
            {
                System.out.println("Club " + display.get(i).getClubName() + " Goals " + display.get(i).getGoals() + " Points " + display.get(i).getPoints() + " Wins " +
                        display.get(i).getWins());
            }
        }
    }


    public void displayTable(ArrayList<FootballClub> footballClubs)
    {
        String[] columnNames = {"Club name", "Goals", "Points", "Wins", "Date"};
        model = new DefaultTableModel(columnNames, 0);

        for(int i = 0; i < footballClubs.size(); i++)
        {
            String date = footballClubs.get(i).getMatchDate();
            String name = footballClubs.get(i).getClubName();
            int goals = footballClubs.get(i).getGoals();
            int points = footballClubs.get(i).getPoints();
            int wins = footballClubs.get(i).getWins();
            Object[] row = {name, goals, points, wins,date};
            model.addRow(row);
        }

        teamTable = new JTable(model);
        teamTable.repaint();
        teamTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamTable);
        panel.add(scrollPane);


        JFrame frame = new JFrame("Tableview");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teamTable.setOpaque(true);
        frame.setContentPane(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    public void sortTableGoals(ArrayList<FootballClub> sortClubsDesc)
    {
        Collections.sort(sortClubsDesc, Collections.reverseOrder());

        String[] columnNames = {"Club name", "goals", "points", "wins", "Date"};
        model = new DefaultTableModel(columnNames, 0);

        for(int i = 0; i < sortClubsDesc.size(); i++)
        {
            String date = sortClubsDesc.get(i).getMatchDate();
            String name = sortClubsDesc.get(i).getClubName();
            int goals = sortClubsDesc.get(i).getGoals();
            int points = sortClubsDesc.get(i).getPoints();
            int wins = sortClubsDesc.get(i).getWins();
            Object[] row = {name, goals, points, wins, date};
            model.addRow(row);
        }

        teamTable = new JTable(model);

        teamTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamTable);
        panel.add(scrollPane);


        JFrame frame = new JFrame("SortedTableByGoals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teamTable.setOpaque(true);
        frame.setContentPane(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void sortTableWins(ArrayList<FootballClub> sortClubsWins)
    {
        Collections.sort(sortClubsWins, Collections.reverseOrder(FootballClub::compareToWins));

        String[] columnNames = {"Club name", "goals", "points", "wins", "Date"};
        model = new DefaultTableModel(columnNames, 0);

        for(int i = 0; i < sortClubsWins.size(); i++)
        {
            String date = sortClubsWins.get(i).getMatchDate();
            String name = sortClubsWins.get(i).getClubName();
            int goals = sortClubsWins.get(i).getGoals();
            int points = sortClubsWins.get(i).getPoints();
            int wins = sortClubsWins.get(i).getWins();
            Object[] row = {name, goals, points, wins, date};
            model.addRow(row);
        }

        teamTable = new JTable(model);

        teamTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamTable);
        panel.add(scrollPane);


        JFrame frame = new JFrame("SortedTableByWins");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teamTable.setOpaque(true);
        frame.setContentPane(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void addRandomMatch (ArrayList<FootballClub> randomMatch)
    {
        try {
            String randomDate = RandomDate.initRandomDate(2000, 2020);
            int randomGoals = randomGenerator.nextInt(5);
            int randomGoals2 = randomGenerator.nextInt(5);

            int chooseRandomTeam1 = randomGenerator.nextInt(clubs.size());
            FootballClub selectedTeam1 = clubs.get(chooseRandomTeam1);
            int chooseRandomTeam2 = randomGenerator.nextInt(clubs.size());
            FootballClub selectedTeam2 = clubs.get(chooseRandomTeam2);

            Matches match = new Matches(randomDate, selectedTeam1.getClubName(), selectedTeam2.getClubName(), randomGoals, randomGoals2);
            matchPlayed.add(match);

            for (int i = 0; i < randomMatch.size(); i++) {
                if (selectedTeam1.getClubName().equals(randomMatch.get(i).getClubName())) {
                    selectedTeam1.goals = selectedTeam1.goals + randomGoals;

                    if (randomGoals > randomGoals2) {
                        selectedTeam1.points = selectedTeam1.points + 3;
                    } else if (randomGoals == randomGoals2) {
                        selectedTeam1.points = selectedTeam1.points + 1;
                    } else if (randomGoals < randomGoals2) {
                        selectedTeam1.points = selectedTeam1.points + 0;
                    }
                }
            }
            for (int i = 0; i < randomMatch.size(); i++) {
                if (selectedTeam2.getClubName().equals(randomMatch.get(i).getClubName())) {
                    selectedTeam2.goals = selectedTeam2.goals + randomGoals2;
                    if (randomGoals2 > randomGoals) {
                        selectedTeam2.wins = selectedTeam2.getWins() + 1;
                        selectedTeam2.points = selectedTeam2.points + 3;
                    } else if (randomGoals2 == randomGoals) {
                        selectedTeam2.points = selectedTeam2.points + 1;
                    } else if (randomGoals2 < randomGoals2) {
                        selectedTeam2.points = selectedTeam2.points + 0;
                    }
                }
            }
        } catch (IllegalArgumentException e)
        {
            System.out.println("No teams in the Premier League");
        }

    }

    public void displayMatchesPlayed(ArrayList<Matches> matchesPlayed)
    {
        String[] columnNames = {"Team1", "Team2", "Team_1_Goals", "Team_2_Goals", "Date"};
        model = new DefaultTableModel(columnNames, 0);

        for(int i = 0; i < matchesPlayed.size(); i++)
        {
            String date = matchesPlayed.get(i).getM_date();
            String teamName = matchesPlayed.get(i).getM_teamName();
            String teamName2 = matchesPlayed.get(i).getM_teamName2();
            int goalsScoredTeam1 = matchesPlayed.get(i).getGoalsTeam1();
            int goalsScoredTeam2 = matchesPlayed.get(i).getGoalsTeam2();

            Object[] row = {teamName, teamName2, goalsScoredTeam1, goalsScoredTeam2,date};
            model.addRow(row);
        }


        teamTable = new JTable(model);
        teamTable.repaint();
        teamTable.setFillsViewportHeight(true);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(teamTable);
        panel.add(scrollPane);


        JFrame frame = new JFrame("MatchesPlayed");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teamTable.setOpaque(true);
        frame.setContentPane(panel);

        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void searchMatch(ArrayList<Matches> searchMatch, String userInput)
    {
        String columnName[] = {"Team1", "Team2", "Team_1_Goals", "Team_2_Goals", "Date"};
        DefaultTableModel searchModel = new DefaultTableModel(columnName, 0);

        if(searchMatch.size() == 0){
            System.out.println("No matches played yet");
        } else {
            for(int i = 0; i < searchMatch.size(); i++) {
                if (searchMatch.get(i).getM_date().equals(userInput)) {
                    String date = searchMatch.get(i).getM_date();
                    String teamName = searchMatch.get(i).getM_teamName();
                    String teamName2 = searchMatch.get(i).getM_teamName2();
                    int goalsScoredTeam1 = searchMatch.get(i).getGoalsTeam1();
                    int goalsScoredTeam2 = searchMatch.get(i).getGoalsTeam2();

                    Object[] row = {teamName, teamName2, goalsScoredTeam1, goalsScoredTeam2, date};
                    searchModel.addRow(row);

                    JTable searchTable = new JTable(searchModel);
                    searchTable.setFillsViewportHeight(true);
                    JPanel searchPanel = new JPanel();
                    JScrollPane scrollPane = new JScrollPane(searchTable);
                    searchPanel.add(scrollPane);

                    JFrame frame = new JFrame("Searched Matches");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    searchTable.setOpaque(true);
                    frame.setContentPane(searchPanel);

                    frame.pack();
                    frame.setSize(500, 500);
                    frame.setVisible(true);
                }
            }
        }
    }



    protected void menu() {
        System.out.println("Press 'A' to add a team");
        System.out.println("Press 'V' to display Premier League Table");
        System.out.println("Press 'D' to delete a team");
        System.out.println("Press 'S' to add match statistics");
        System.out.println("Press 'F' to find & view statistics of a team");
        System.out.println("Press 'E' save all club data into file");
        System.out.println("Press 'G' to open GUI");
        System.out.println("Press 'Q' to quit this program");
    }

}