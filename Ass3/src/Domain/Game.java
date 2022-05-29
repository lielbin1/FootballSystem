package Domain;

import java.util.Date;

public class Game {
    public String gameDateTime;
    public Team homeTeam;
    public Team awayTeam;
    public String field;
    public Referee referee;
    public String homeTeamScore;
    public String awayTeamScore;
    //public GameSchedule gameSchedule;
    public String gameSchedule;
    public String seasonId;
    public String gameID;

    public Game(String gameDateTime, Team homeTeam, Team awayTeam, String field, Referee referee, String seasonId,String gameID) {
        this.gameDateTime = gameDateTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.field = field;
        this.referee = referee;
        this.seasonId = seasonId;
        this.gameID = gameID;

    }

    public String getGameDateTime() {
        return gameDateTime;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public String getField() {
        return field;
    }

    public Referee getReferee() {
        return referee;
    }

    public String getHomeTeamScore() {
        return homeTeamScore;
    }

    public String getAwayTeamScore() {
        return awayTeamScore;
    }

    public String getGameSchedule() {
        return gameSchedule;
    }

    public String getSeasonId() {
        return seasonId;
    }

    public String getGameID() {
        return gameID;
    }





    public void setScore(String score){

    }
}

