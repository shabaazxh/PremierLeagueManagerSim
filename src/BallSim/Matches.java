package BallSim;

import java.time.LocalDate;

public class Matches {
    String m_date;
    String m_teamName;
    String m_teamName2;
    int goalsTeam1;
    int goalsTeam2;

    Matches(String date, String teamName, String teamName2, int goalsT1, int goalsT2)
    {
        m_date = date;
        m_teamName = teamName;
        m_teamName2 = teamName2;
        goalsTeam1 = goalsT1;
        goalsTeam2 = goalsT2;
    }

    public String getM_date()
    {
        return m_date;
    }

    public String getM_teamName()
    {
        return m_teamName;
    }
    public String getM_teamName2()
    {
        return m_teamName2;
    }
    public int getGoalsTeam1()
    {
        return goalsTeam1;
    }
    public int getGoalsTeam2()
    {
        return goalsTeam2;
    }


}
