package Service;

import Tests.unitTest;
import Tests.TestRunner;

public class main {

        public static void main(String[] args) throws Exception {

           //ASPresentation asPresentation = new ASPresentation();
           //asPresentation.addReferee("Ayelet","number 2.6","maybe");
           //asPresentation.scheduleGamesPolicyPresentation("3","1","title","test","0");
           //Team team = new Team("real madrid",null,null,null,null,null,null,null,null);
           //Team team2 = new Team("barcelona",null,null,null,null,null,null,null,null);
           //Referee referee = new Referee("george","tt","no");
           //asPresentation.addGamePresentaion("1990/12/12",team,team2,"anfield",referee,"3","12","1990/06/06","3","6");
           //Logger log = new Logger();
           //log.writeToLog("new referee added");
           //log.readFromLog();
           //associationRepresentatives as = new associationRepresentatives();
           //as.createLeagueSeasonPolicyDomain("2","0","6");
           // User user = new User("noam2","abcd");
           //user.logInDomain(user.getUserName(),user.getPassword());
           //acceptanceTest acceptanceTest = new acceptanceTest();
           //testJunit.ShouldAddNewRefereeToDB();
           //testJunit.ShoulderturnException();
           //testJunit.ShouldAddNewRefereeToDB();
            unitTest unitTest = new unitTest();
            TestRunner testRunner = new TestRunner();
            testRunner.run();

        }

}

//final version