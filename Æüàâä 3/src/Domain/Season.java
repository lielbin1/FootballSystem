package Domain;

import java.util.ArrayList;

public class Season {
    private String year;
    private ArrayList<Game> games;
    private GamePolicy gamePolicy;
    private ScoringCalculationPolicy scoringCalculationPolicy;
    private League league;
    private ArrayList<Referee> referees;
    private ArrayList<Team> teams;
}
