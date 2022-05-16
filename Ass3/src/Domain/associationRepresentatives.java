package Domain;


import DataAccess.arAccess;
import DataAccess.refereeAccess;

public class associationRepresentatives {
    private Logger logFile;
    private refereeAccess refereeAccess;
    private arAccess araccess;

    public associationRepresentatives() {
        this.logFile = new Logger();
        this.araccess = new arAccess();
    }

    public boolean addReferee(String userName, String qualification ,String isHeadReferee){
        Referee referee = new Referee(userName, qualification, isHeadReferee);
        //this.logFile.writeToLog("The referee" + userName +"was added successfully");
        refereeAccess ra = new refereeAccess();
        boolean isRefereeLoggedIn = ra.refereeTable(userName,qualification,isHeadReferee);

        //here: send to database
        return isRefereeLoggedIn;
    }
    public void scheduleGamesPolicyDomain(String gamePolicyId, String title, String description, String seasonId){

        //check in database if we already have this policy. 1 is exist
        if(araccess.checkGamePolicy(gamePolicyId)){
            java.lang.System.out.println("this policy already exists in the database");
            return;
        }

        GamePolicy gp = new GamePolicy( gamePolicyId,  title,  description,  seasonId);

        araccess.addPolicy( gamePolicyId,  title,  description,  seasonId);//add to the database if we already have this policy

        //send to database
    }

    public void addGameDomain(String gameDateTime, Team homeTeam, Team awayTeam, String field, Referee referee, String homeTeamScore, String awayTeamScore, String gameSchedule, String seasonId, String gameID){

        Game game = new Game(gameDateTime,  homeTeam,  awayTeam,  field,  referee,  homeTeamScore,  awayTeamScore,  gameSchedule,  seasonId,  gameID);

        if(!araccess.addGame(game)){
            java.lang.System.out.println("Game already exists in the database");
        }
        else{
            java.lang.System.out.println("Game " + game.getGameID()+ " added to the database");
        }
    }
}
