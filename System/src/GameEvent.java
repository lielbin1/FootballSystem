import java.util.Date;

public class GameEvent {
    private Date time;
    private int gameMinute;
    private String description;
    private GameSchedule gameSchedule;

    enum  EventType{
        GOAL;
    }
}
