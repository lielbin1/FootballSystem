package Presentation;

import Domain.Referee;
import Domain.Team;

public class main {

        public static void main(String[] args) {

            ASPresentation asPresentation = new ASPresentation();
            //asPresentation.addReferee("Ayelet","number 2.6","maybe");
            //asPresentation.scheduleGamesPolicyPresentation("3","1","title","test","0");

           Team team = new Team("real madrid",null,null,null,null,null,null,null,null);
           Team team2 = new Team("barcelona",null,null,null,null,null,null,null,null);
           Referee referee = new Referee("george","tt","no");
           asPresentation.addGamePresentaion("1990/12/12",team,team2,"anfield",referee,"3","12","1990/06/06","3","6");


        }

}
