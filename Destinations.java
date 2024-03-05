import java.util.ArrayList;
import java.util.List;

//Destinations class to create the destination entities
public class Destinations {
    private String destinationName;
    private List<Activity> activityList = new ArrayList<>();

    Destinations(String destinationName) {
        this.destinationName = destinationName;
    }

    // Getter and setter functions
    protected String getDestinationName() {
        return destinationName;
    }

    protected List<Activity> getActivityList() {
        return activityList;
    }

    protected void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
}
