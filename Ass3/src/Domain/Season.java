package Domain;

import java.util.ArrayList;

public class Season {
    private String seasonId;
    private ArrayList<Game> games;
    private GamePolicy gamePolicy;
    private ScoringCalculationPolicy scoringCalculationPolicy;
    private League league;
    private ArrayList<Referee> referees;
    private ArrayList<Team> teams;

    public ArrayList<Game> getGames() {
        return games;
    }

    public Season(String seasonId, GamePolicy gamePolicy, League league) {
        this.seasonId = seasonId;
        this.gamePolicy = gamePolicy;
        this.league = league;
    }

    public String getSeasonId() {
        return seasonId;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
}
