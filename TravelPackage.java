import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    // Travel Package class to create a travel package entity
    private String packageName;
    private int packageCapacity;
    private List<Destinations> destinationList = new ArrayList<>();
    private List<Passenger> passengerList = new ArrayList<>();

    TravelPackage(String packageName, int packageCapacity) {
        this.packageName = packageName;
        this.packageCapacity = packageCapacity;
    }

    // Getter and setter functions
    protected String getPackageName() {
        return packageName;
    }

    protected int getPackageCapacity() {
        return packageCapacity;
    }

    protected void setPackageCapacity(int packageCapacity) {
        this.packageCapacity = packageCapacity;
    }

    protected List<Destinations> getDestinationList() {
        return destinationList;
    }

    protected void setDestinationList(List<Destinations> destinationList) {
        this.destinationList = destinationList;
    }

    protected List<Passenger> getPassengerList() {
        return passengerList;
    }

    protected void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
}