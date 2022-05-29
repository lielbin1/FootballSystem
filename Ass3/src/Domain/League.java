package Domain;

import java.util.ArrayList;

public class League {
    private String leagueId;
    private  System system;
    //private Season season;
    private String seasons;


    public League(String leagueId, String seasons) {
        this.leagueId = leagueId;
        this.seasons = seasons;
    }

    public String getSeason(String seasonId) {
        String[] arrOfStr = seasons.split("/", -2);

        for (String id : arrOfStr)
            if(seasonId.compareTo(id) == 0)
            {
                return id;
            }

       return null;
  }
}
