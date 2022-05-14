package Domain;


import DataAccess.refereeAccess;

public class associationRepresentatives {
    private Logger logFile;
    private refereeAccess refereeAccess;


    public boolean addReferee(String userName, String qualification ,String isHeadReferee){
        Referee referee = new Referee(userName, qualification, isHeadReferee);
        //this.logFile.writeToLog("The referee" + userName +"was added successfully");
        refereeAccess ra = new refereeAccess();
        boolean isRefereeLoggedIn = ra.refereeTable(userName,qualification,isHeadReferee);

        //here: send to database
        return isRefereeLoggedIn;
    }
}
