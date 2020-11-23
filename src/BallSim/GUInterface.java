package BallSim;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GUInterface {
    JFrame frame;
    JPanel jPanel = new JPanel();
    Container c;

    GUInterface(PremierLeagueManager plm)
    {
        frame = new JFrame("PremierLeageGUI");
        JButton leagueTable = new JButton("Premier League Table");
        JButton sortGoals = new JButton("Sort by goals scored, descending order");
        JButton sortWins = new JButton("Sort by wins scored, descending order");
        JButton addRandomMatch = new JButton("Add random match");
        JButton matchesPlayed = new JButton("Matches Played");
        JButton searchButton = new JButton("Search");
        JTextField searchbox = new JTextField(30);

        c = frame.getContentPane();
        c.setLayout(new FlowLayout());

        c.add(leagueTable);
        c.add(sortGoals);
        c.add(sortWins);
        c.add(addRandomMatch);
        c.add(matchesPlayed);
        c.add(searchButton);
        c.add(searchbox);

        ActionEvents eventListener = new ActionEvents(frame, leagueTable, sortGoals, sortWins, addRandomMatch, matchesPlayed, searchButton,
                searchbox, plm);
        leagueTable.addActionListener(eventListener);
        sortGoals.addActionListener(eventListener);
        sortWins.addActionListener(eventListener);
        addRandomMatch.addActionListener(eventListener);
        matchesPlayed.addActionListener(eventListener);
        searchButton.addActionListener(eventListener);
        searchbox.addActionListener(eventListener);

        frame.setSize(400,400);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
        frame.addWindowListener(new WindowListener());
    }

}
