package Domain;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

public class Team {
    private String name;
    private Object personalPage;
    private String homeField;
    private ArrayList<Game> games;
    private ArrayList<Player> players;
    private ArrayList<Coach> coaches;
    private ArrayList<TeamManager> teamManagers; /////////not sure
    private ArrayList<TeamOwner> teamOwners;
    private FinancialBook financialBook;
    public Season season;

    public Team(String name, String homeField) {
        this.name = name;
        this.homeField = homeField;
    }

    public String getName() {
        return name;
    }

    public String getHomeField() {
        return homeField;
    }






}
