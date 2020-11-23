package BallSim;

import java.time.LocalDate;

public class RandomDate
{
    public static int randomDate(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static String initRandomDate(int start, int end)
    {
        int day = randomDate(1, 28);
        int month = randomDate(1, 12);
        int year = randomDate(start, end);
        return day + "/" + month + "/" + year;
    }
}
