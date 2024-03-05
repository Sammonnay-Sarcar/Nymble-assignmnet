import java.util.ArrayList;
import java.util.List;

public class Passenger {
    // Passenger class to create the passenger entities
    private String passengerName;
    private String passengerNumber;
    private PassengerType passengerType;
    private double balance;
    private List<Activity> activityList;
    private List<TravelPackage> travelPackageList;

    Passenger(String passengerName, String passengerNumber, PassengerType passengerType, double balance) {
        this.passengerName = passengerName;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.passengerType = passengerType;
        activityList = new ArrayList<>();
        travelPackageList = new ArrayList<>();
    }

    // Getter and setter functions for the fields
    protected String getPassengerName() {
        return passengerName;
    }

    protected String getPassengerNumber() {
        return passengerNumber;
    }

    protected PassengerType getPassengerType() {
        return passengerType;
    }

    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected void setTravelPackageList(List<TravelPackage> travelPackageList) {
        this.travelPackageList = travelPackageList;
    }

    protected List<TravelPackage> getTravelPackageList() {
        return travelPackageList;
    }

    protected List<Activity> getActivityList() {
        return activityList;
    }

    protected void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

}
