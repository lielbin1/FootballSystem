package DataAccess;


//associationRepresentatives access


import Domain.*;

import java.lang.System;
import java.security.Policy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class arAccess {

    public League getLeague(String leagueID){

        League league = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM leaguetable WHERE leagueID = "  +leagueID;
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                league = new League(resultSet.getString(1),resultSet.getString(2));
            }

            return league;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public GamePolicy getGamePolicy(String id){
        GamePolicy gamePolicy =null;
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM policyTable WHERE policyID = "  +id;

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                 gamePolicy = new GamePolicy(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
            }

           return gamePolicy;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public Referee getRandomReferee(){
        Referee referee = null;
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            Statement statement = connection.createStatement();

            String sql = "SELECT userName,qualification,isHeadReferee FROM refereetable ORDER BY RAND() LIMIT 1";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                referee = new Referee(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
            }
            return  referee;


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //add to the database  policy
    public boolean addGameToDBAccess(Game game) { //add new game to database

        boolean gameExists = false;
        try {
            //connect to mysql database locally
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            Statement statement = connection.createStatement();
            //create an sql commands
            String sql = "select * from gameTable";
            //execute the command
            ResultSet resultSet = statement.executeQuery(sql);

            //check information in our database
            while (resultSet.next()) {
                // get user name and password from users in the database
                String gameIDInDB = (resultSet.getString("gameID"));
                if (gameIDInDB == null) {
                    continue;
                }
                //check if the user exists in the database
                if (gameIDInDB.compareTo(game.getGameID()) == 0 ) {
                    gameExists = true;
                    break;
                }
            }

            //if the user exists in the database
            if (gameExists) {
                return false;
            }

            //create proper sql command to chenge the status of the user to be connected to the system
            String quote_gameID = '"' + game.getGameID() + '"';
            String quote_gameAwayScore = '"' + game.getAwayTeamScore() + '"';
            String quote_gameDate = '"' + game.getGameDateTime()+ '"';
            String quote_away_team = '"' + game.awayTeam.getName() + '"';
            String quote_field = '"' + game.getField() + '"';
            String quote_gameSchedule = '"' + game.getGameSchedule() + '"';
            String quote_gameHomeTeam = '"' + game.homeTeam.getName() + '"';
            String quote_gameHomeScore = '"' + game.getHomeTeamScore() + '"';
            String quote_gameReferee = '"' + game.referee.getUserName() + '"';
            String quote_seasonID = '"' + game.getSeasonId() + '"';
            //if the user dosent exist we will create him
            System.out.println("saving game " + game.getGameID());

            // prepare and execute sql command to insert the new user to the database

            String sql1 = "INSERT INTO gameTable VALUES(";
            String sql2 = quote_gameID + "," + quote_gameAwayScore + "," + quote_gameDate + "," +quote_away_team+"," +quote_field +"," +quote_gameSchedule
            +"," +quote_gameHomeTeam+"," + quote_gameHomeScore+ "," +quote_gameReferee +"," +quote_seasonID +")";

            sql = sql1 + sql2;

            statement.executeUpdate(sql);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public ArrayList<Team> getTeamsFromDataBase() {
        ArrayList<Team> teams = new ArrayList<>();
        //connect to mysql database locally
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
            Statement statement = connection.createStatement();
            //create an sql commands
            String sql = "select * from teamTable";
            //execute the command
            ResultSet resultSet = statement.executeQuery(sql);

            //check information in our database
            while (resultSet.next()) {
                Team team = new Team(resultSet.getString(1),resultSet.getString(2));
                teams.add(team);
            }
            return  teams;
        }catch (Exception e ){
            e.printStackTrace();
        }

        return null;
    }


}



//    @SuppressWarnings("Duplicates")
//    public void addPolicy(String gamePolicyId, String title, String description, String seasonId) {
//        try {
//
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
//            Statement statement = connection.createStatement();
//            //add the new policy to db
//            //create proper sql command to chenge the status of the user to be connected to the system
//            String quote_policyID = '"' + gamePolicyId + '"';
//            String quote_title = '"' + title + '"';
//            String quote_description = '"' + description + '"';
//            String quote_sesasonID = '"' + seasonId + '"';
//            //if the user dosent exist we will create him
//            System.out.println("creating policy " + gamePolicyId + " " + title);
//
//            // prepare and execute sql command to insert the new user to the database
//
//            String sql1 = "INSERT INTO policyTable VALUES(";
//            String sql2 = quote_policyID + "," + quote_title + "," + quote_description + "," + quote_sesasonID + ")";
//
//            String sql = sql1 + sql2;
//
//            statement.executeUpdate(sql);
//            System.out.println("policy added");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public boolean checkGamePolicy(String gamePolicyId) {
//        boolean userExists = false;
//        if (gamePolicyId == null) {
//            return false;
//        }
//        //check in database if we already have this policy
//        //connect to mysql database locally
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
//            Statement statement = connection.createStatement();
//            //create an sql command
//            String sql = "select * from policyTable";
//            //execute the command
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                // get user name and password from users in the database
//                String policyIDINDB = (resultSet.getString("policyID"));
//
//                if (policyIDINDB == null) {
//                    continue;
//                }
//                //check if the user exists in the database
//                if (policyIDINDB.compareTo(gamePolicyId) == 0) {
//                    userExists = true;
//                    break;
//                }
//            }
//
//            //if the user exists in the database
//            if (userExists) {
//                return true;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }

