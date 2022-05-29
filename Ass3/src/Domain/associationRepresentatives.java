package Domain;


import DataAccess.arAccess;
import DataAccess.refereeAccess;
import DataAccess.randomDate;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

public class associationRepresentatives  {
    private Logger logFile;
    private refereeAccess refAccess;
    private arAccess araccess;

    public associationRepresentatives() {

        this.logFile = new Logger();
        this.araccess = new arAccess();
        this.refAccess = new refereeAccess();
    }

    //add a referee to the database
    public boolean addReferee(String userName, String qualification ,String isHeadReferee){
        Referee referee = new Referee(userName, qualification, isHeadReferee);

        // check if the referee is already logged in
        boolean isRefereeLoggedIn = refAccess.refereeTable(referee);
        if(isRefereeLoggedIn){

            this.logFile.writeToLog("The referee " + userName +" was added successfully");
        }
        else
        {
            this.logFile.writeToLog("The referee " + userName +" was not added because " + userName + " was already added");
        }
        return isRefereeLoggedIn;
    }

    @SuppressWarnings("Duplicates")
    public void createLeagueSeasonPolicyDomain(String gamePolicyId, String leagueId, String seasonId) throws Exception {

        //get policy fro the DB
        GamePolicy gamePolicy = araccess.getGamePolicy(gamePolicyId);

        //declare a referee
        Referee referee = null;

        //declare a list of referees
        ArrayList<String> referees = new ArrayList<>();


        String date = "";
        ArrayList<String> dates = new ArrayList<>();

        //hold the instances of league and season to
        League league = araccess.getLeague(leagueId); //get the league from the database
        String checkIfSeasonInLeague = league.getSeason(seasonId); //get the season from league class
        if (checkIfSeasonInLeague == null) {
            this.logFile.writeToLog("there is no Season " + seasonId + " in league " + leagueId);
            throw new Exception("there is no Season " + seasonId + " in league " + leagueId);
        }

        //create a new season
        Season season = new Season(seasonId,gamePolicy,league);

        //declare a list of games
        ArrayList<Game> games = new ArrayList<>();

        //a list that holds all the teams that are in the database
        ArrayList<Team> teams = araccess.getTeamsFromDataBase();

        //go over all the teams
        for(int i = 0; i < teams.size(); i++){
            for(int j = i+1; j< teams.size(); j++){
                if(teams.get(i).getName()== teams.get(j).getName()){
                    continue;
                }
                //select a random date
                while(true) {
                    date = randomDate.getDate(2022, 2022);
                    if (!dates.contains(date)) {
                        dates.add(date);
                        break;
                    }
                }
                //select random referee from the database
                while(true) {
                    referee = araccess.getRandomReferee();
                    String refString = referee.getUserName() + referee.getQualification() + referee.getIsHeadReferee();
                    if (!referees.contains(refString)) {
                        referees.add(refString);
                        break;
                    }
                }


                //game policy 1 and 2
                if(this.gameIsValid(teams.get(i), teams.get(j), teams.get(i).getHomeField(), referee, date, games,gamePolicyId)){
                    Game game = new Game(date, teams.get(i), teams.get(j),  teams.get(i).getHomeField(), referee, seasonId,date) ;
                    games.add(game);
                    this.addGameToDB(game);
                }

                //only for game policy 2
                if(gamePolicyId == "2"){
                    while(true) {
                        date = randomDate.getDate(2022, 2022);
                        if (!dates.contains(date)) {
                            dates.add(date);
                            break;
                        }
                    }
                    //check if the game is valid
                    if(this.gameIsValid(teams.get(j), teams.get(i), teams.get(j).getHomeField() , referee,date, games,gamePolicyId)){
                        Game game = new Game(date, teams.get(j), teams.get(i),  teams.get(j).getHomeField(), referee, seasonId,date) ;
                        games.add(game);
                        this.addGameToDB(game);
                    }
                }
            }
        }
        season.setGames(games);


    }


    // check if a game is valid
    private boolean gameIsValid(Team t1, Team t2, String field, Referee referee, String date, ArrayList<Game> games,String gamePolicyID) throws Exception { //this function check if the game can create
        //if already this game exist
        for (Game game : games){
            if(gamePolicyID != "2" && game.awayTeam.getName() == t1.getName() && game.homeTeam.getName() == t2.getName()){
                throw new Exception("This game already exists" );
            }
            if(gamePolicyID != "2" && game.awayTeam.getName() == t2.getName() && game.homeTeam.getName() == t1.getName()){
                throw new Exception("The game is already exist" );
            }
            if(game.field == field && game.getGameDateTime() == date){
                throw new Exception("This field is taken" );
            }
            if(gamePolicyID != "2" && game.referee.getUserName() == referee.getUserName() && game.getGameDateTime() == date){
                throw new Exception("This referee is busy" );
            }
            if(game.gameDateTime == date ){
                throw new Exception("This date is not available" );
            }

        }
        return true;
    }

    //adds a game to the database
    public void addGameToDB(Game gameToAdd) throws Exception {
        //check if the game already exists in the Database
        if(!araccess.addGameToDBAccess(gameToAdd)){
            throw new Exception("The game " + gameToAdd.getGameID() + " already exist in the db");
        }
        else{
            java.lang.System.out.println("Game " + gameToAdd.getGameID()+ " added to the database, "
                    +gameToAdd.getHomeTeam().getName() + " vs " + gameToAdd.getAwayTeam().getName()
            +", referee: " + gameToAdd.getReferee().getUserName());

            this.logFile.writeToLog("Game " + gameToAdd.getGameID()+ " added to the database, "
                    +gameToAdd.getHomeTeam().getName() + " vs " + gameToAdd.getAwayTeam().getName()
                    +", referee: " + gameToAdd.getReferee().getUserName());
        }
    }
}
