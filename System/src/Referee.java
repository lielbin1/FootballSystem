import java.util.ArrayList;
import java.util.Date;

public class Referee {
    private String ualification;
    private Boolean isHeadReferee;
    private ArrayList<Game> games;
    private ArrayList<Season> season;

    public void setGameScore(int gameID, Team homeTeamGoals, Team awayTeamGoals){
    }

    public void addEvent(int gameID, Date time, Date gameMinute, GameEvent.EventType eventType, String description){
    }

    public void editEvent(int gameID, Date time, Date gameMinute, GameEvent.EventType  eventType, String description){
    }

}
