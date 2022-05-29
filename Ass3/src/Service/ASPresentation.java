package Service;


import Domain.Referee;
import Domain.associationRepresentatives;


;

 //associationRepresentatives presentation

public class ASPresentation {
    private associationRepresentatives arDomain;

    public ASPresentation() {
        this.arDomain = new associationRepresentatives();
    }


    //add referee to the database, check the service layer
    public String addReferee(String userName, String qualification , String isHeadReferee) throws Exception { // add referee to the database

        // check if any parameter is null
        if(userName == null ){
            return("userName is null. try again");
        }
        else if( qualification == null){
            return ("qualification is null. try again");
        }
        else if(isHeadReferee == null){
            return ("isHeadReferee is null. try again");
        }
        //no parameter is null so we send the parameters to the domain layer
        if(this.arDomain.addReferee(userName, qualification, isHeadReferee)){
            System.out.println("The referee " + userName +" was added successfully");
        }
        else
        {
            return("The referee " + userName +" was not added, because he already exists");
        }

        return "The referee "+userName +" was added successfully";

    }

    // adds game policy,season id and league id to the domain, checks the service layer
    public String scheduleGamesPolicyPresentation(String gamePolicyId, String leagueId, String seasonId) throws Exception {

        //check if the parameters are null or not what is expected
        if(gamePolicyId == null || (Integer.parseInt(gamePolicyId) != 1 && Integer.parseInt(gamePolicyId) != 2)){
            return ("game policy id must be 1 or 2");
        }
        else if(leagueId == null || Integer.parseInt(leagueId) <= 0){
            return ("league id must be a positive number");
        }
        else if(seasonId == null || Integer.parseInt(seasonId) <= 0){
            return ("season id must be a positive number");
        }
        //send the parameters to the domain layer to create a new policy
        arDomain.createLeagueSeasonPolicyDomain(gamePolicyId, leagueId, seasonId);

        return ("game policy " +gamePolicyId+ " added for league " +leagueId + " in season " + seasonId);

    }


}

