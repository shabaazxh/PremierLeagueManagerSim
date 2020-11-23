package BallSim;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEvents implements ActionListener {

    JFrame frame;

    JButton showtable;
    JButton sortGoals;
    JButton sortWins;
    JButton randomMatch;
    JButton matchesPlayed;
    JButton searchButton;
    JTextField searchMatch;
    PremierLeagueManager p;

    ActionEvents(JFrame f, JButton table, JButton sortGoalsButton, JButton sortWinsButton, JButton addrandomMatch, JButton matches,
                 JButton search,  JTextField searchTextField, PremierLeagueManager plm)
    {
       frame = f;
       showtable = table;
       sortGoals = sortGoalsButton;
       sortWins = sortWinsButton;
       randomMatch = addrandomMatch;
       matchesPlayed = matches;
       searchButton = search;
       searchMatch = searchTextField;

       p = plm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == showtable)
        {
           p.displayTable(p.clubs);
        }
        else if(e.getSource() == sortGoals)
        {
            p.sortTableGoals(p.clubs);
        }
        else if(e.getSource() == sortWins)
        {
            p.sortTableWins(p.clubs);
        }
        else if (e.getSource() == randomMatch)
        {
            p.addRandomMatch(p.clubs);
        }
        else if(e.getSource() == matchesPlayed)
        {
            p.displayMatchesPlayed(p.matchPlayed);
        }
        else if(e.getSource() == searchButton)
        {
            String userSearch = searchMatch.getText();
            p.searchMatch(p.matchPlayed, userSearch);
        }
    }
}
