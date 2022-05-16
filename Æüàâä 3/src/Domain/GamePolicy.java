package Domain;

public class GamePolicy {
    private String gamePolicyId;
    private String title;
    private String description;
    private String seasonId;
    //private Season season;


    public GamePolicy(String gamePolicyId, String title, String description, String seasonId) {
        this.gamePolicyId = gamePolicyId;
        this.title = title;
        this.description = description;
        this.seasonId = seasonId;
    }
}
