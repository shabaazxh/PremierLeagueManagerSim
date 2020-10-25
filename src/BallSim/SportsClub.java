package BallSim;

abstract public class SportsClub {
    String clubName;
    String clubLocation;


    public void setClubName(String name)
    {
        clubName = name;
    }

    public String getClubName()
    {
        return clubName;
    }

    public void setClubLocation(String location)
    {
        clubLocation = location;
    }

    public String getClubLocation()
    {
        return clubLocation;
    }
}
