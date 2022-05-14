package Presentation;
import Domain.associationRepresentatives;

 //associationRepresentatives presentation

public class ASPresentation {
    private associationRepresentatives ar;

    public ASPresentation() {
        this.ar = new associationRepresentatives();
    }


    //send to
    public void addReferee(String userName, String qualification , Boolean isHeadReferee){ // add referee to the database
        if(userName == null || qualification == null || isHeadReferee == null){
            System.out.println("One or more of the arguments is null. try again");
            return;
        }
        if(this.ar.addReferee(userName, qualification, isHeadReferee)){
            System.out.println("The referee" + userName +"was added successfully");
        }


    }


    public void scheduleGames(){

    }
}
