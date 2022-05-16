package Domain;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Team {
    public String name;
    public Object personalPage;
    private ArrayList<Game> games;
    private ArrayList<Player> players;
    private ArrayList<Coach> coaches;
    private ArrayList<TeamManager> teamManagers; /////////not sure
    private ArrayList<TeamOwner> teamOwners;
    private FinancialBook financialBook;
    public Season season;

    public String getName() {
        return name;
    }

    public Object getPersonalPage() {
        return personalPage;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    public ArrayList<TeamManager> getTeamManagers() {
        return teamManagers;
    }

    public ArrayList<TeamOwner> getTeamOwners() {
        return teamOwners;
    }

    public FinancialBook getFinancialBook() {
        return financialBook;
    }

    public Season getSeason() {
        return season;
    }

    public Team(String name, Object personalPage, ArrayList<Game> games, ArrayList<Player> players, ArrayList<Coach> coaches, ArrayList<TeamManager> teamManagers, ArrayList<TeamOwner> teamOwners, FinancialBook financialBook, Season season) {
        this.name = name;
        this.personalPage = personalPage;
        this.games = new ArrayList<Game> ();
        this.players = new ArrayList<Player> ();
        this.coaches = new ArrayList<Coach> ();
        this.teamManagers = new ArrayList<>();
        this.teamOwners = new ArrayList<>();
        this.financialBook = financialBook;
        this.season = season;

    }

}
