
import java.util.List;
import java.util.Scanner;

public class TravelPackageController implements Print {
    static Scanner sc = new Scanner(System.in);

    public static TravelPackage createTravelPackage() {
        String packageName = Input.getInput(sc, "Enter Travel Package name:");
        int packageCapacity = Input.getIntInput(sc, "Enter travel package capacity:");
        sc.nextLine();
        TravelPackage travelPackage = new TravelPackage(packageName, packageCapacity);
        return travelPackage;
    }

    public static void print(TravelPackage travelPackage) {
        System.out.println("Travel Package Name::" + travelPackage.getPackageName());
        System.out.print("Destination::\n\t");
        for (Destinations destination : travelPackage.getDestinationList()) {
            System.out.println(destination.getDestinationName());
            System.out.print("Activity::\n\t");
            for (Activity activity : destination.getActivityList()) {
                System.out.println("Activity Name:" + activity.getName() + "\n" + "Activity Capacity:"
                        + activity.getCapacity() + "\n" + "Activity Cost:" + activity.getCost() + "\n"
                        + activity.getDescription());
            }
        }
    }

    public static void print(List<TravelPackage> travelPackageList) throws EmptyListException {
        if (travelPackageList.isEmpty()) {
            throw new EmptyListException("Travel Package List is Empty");
        }
        for (TravelPackage travelPackageSearch : travelPackageList) {
            System.out.println("Package Name::\t" + travelPackageSearch.getPackageName());
            System.out.println("Package Capacity::\t" + travelPackageSearch.getPackageCapacity());
            System.out.println("Current Package Booking::\t" + travelPackageSearch.getPassengerList().size() + "\n");
            for (Passenger passengerSearch : travelPackageSearch.getPassengerList()) {
                System.out.println("Passenger Name::\t" + passengerSearch.getPassengerName());
                System.out.println("Passenger Number::" + passengerSearch.getPassengerNumber());
            }
        }
    }

    public static TravelPackage getTravelPackages(List<TravelPackage> travelPackageList) throws EmptyListException {
        if (travelPackageList.isEmpty()) {
            throw new EmptyListException("Travel Package List is Empty");
        }
        for (int i = 0; i < travelPackageList.size(); i++) {
            System.out.println(i + 1 + ":\t" + travelPackageList.get(i).getPackageName());
        }
        int packageChoice = sc.nextInt();
        TravelPackage chosenPackage = travelPackageList.get(packageChoice - 1);
        return chosenPackage;
    }
}
