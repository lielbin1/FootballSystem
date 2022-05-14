package Domain;

public class associationRepresentatives {
    private Logger logFile;


    public boolean addReferee(String userName, String qualification ,Boolean isHeadReferee){
        Referee referee = new Referee(userName, qualification, isHeadReferee);
        this.logFile.writeToLog("The referee" + userName +"was added successfully");
        //here: send to database
        return true;
    }
}
