package Presentation;


import Domain.associationRepresentatives;
import Domain.Team;
import Domain.Referee;


;

 //associationRepresentatives presentation

public class ASPresentation {
    private associationRepresentatives ar;

    public ASPresentation() {
        this.ar = new associationRepresentatives();
    }


    //send to
    public void addReferee(String userName, String qualification , String isHeadReferee){ // add referee to the database
        if(userName == null || qualification == null || isHeadReferee == null){
            System.out.println("One or more of the arguments is null. try again");
            return;
        }
        if(this.ar.addReferee(userName, qualification, isHeadReferee)){
            System.out.println("The referee " + userName +" was added successfully");
        }
        else
        {
            System.out.println("The referee " + userName +" was not added, because he already exists");
        }


    }

    // adds game policy season id and leage it to the domain
    public void scheduleGamesPolicyPresentation(String gamePolicyId, String leagueId, String title, String description, String seasonId){
        if(Integer.parseInt(gamePolicyId) <0 || Integer.parseInt(seasonId)<0 || Integer.parseInt(leagueId) <0){
            System.out.println("Id must be equal or bigger then 0");
            return;
        }
        ar.scheduleGamesPolicyDomain(gamePolicyId, title, description,seasonId);



    }


    public void addGamePresentaion(String gameDateTime, Team homeTeam, Team awayTeam, String field, Referee referee, String homeTeamScore, String awayTeamScore, String gameSchedule, String seasonId, String gameID){
        if(homeTeam == null || awayTeam == null || field == null || referee == null || seasonId == null){
            System.out.println("one or more of the arguments are null. try again");
            return;
        }
        ar.addGameDomain(gameDateTime,  homeTeam,  awayTeam,  field,  referee,  homeTeamScore,  awayTeamScore,  gameSchedule,  seasonId,  gameID);
    }
}

