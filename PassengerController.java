import java.util.List;
import java.util.Scanner;

public class PassengerController implements Print {
    static Scanner sc = new Scanner(System.in);

    // Create a new passenger entity
    public static Passenger createPassenger() {
        String passengerName = Input.getInput(sc, "Enter name of passenger:");
        String passengerNumber = Input.getInput(sc, "Enter passenger number:");
        System.out.println("Enter passenger type:\n\t 1.STANDARD\n\t 2.GOLD\n\t 3.PREMIUM");
        int passengerType = Input.getIntInput(sc, "Enter your choice::");
        double balance = Double.MAX_VALUE;
        PassengerType passengerTypeActual = PassengerType.STANDARD;
        // Check for the Passenger Type
        switch (passengerType) {
            case 1:
                System.out.print("Balance:");
                balance = sc.nextDouble();
                passengerTypeActual = PassengerType.STANDARD;
                break;
            case 2:
                System.out.print("Balance:");
                balance = sc.nextDouble();
                passengerTypeActual = PassengerType.GOLD;
                break;
            case 3:
                passengerTypeActual = PassengerType.PREMIUM;
            default:
                break;
        }
        sc.nextLine();
        Passenger passenger = new Passenger(passengerName, passengerNumber, passengerTypeActual, balance);
        return passenger;
    }

    // parameter: Passenger object
    // Prints the details of a passenger entity
    public static void print(Passenger passenger) {
        System.out.println(passenger.getPassengerName());
        System.out.println(passenger.getPassengerNumber());

        // check if the passanger needs to have a balance, i.e., Standard, Gold member
        // or Premium member
        if (passenger.getPassengerType().equals(PassengerType.STANDARD)
                || passenger.getPassengerType().equals(PassengerType.GOLD)) {
            System.out.println("Balance::" + passenger.getBalance());
        } else {
            System.out.println("Balance:: Not Applicable");
        }

        // print the list of destinations
        for (Activity activity : passenger.getActivityList()) {
            System.out.println("\tActivity name::" + activity.getName());
            // Get the name of destination, 1. Choose a travel package, search for
            // destinations in each, search for activities in each destination and iff an
            // activity name matches a activity from the passenger's list, print the
            // destination.
            for (TravelPackage travelPackageSearch : passenger.getTravelPackageList()) {
                for (Destinations destination : travelPackageSearch.getDestinationList()) {
                    for (Activity activitySearch : destination.getActivityList()) {
                        if (activity.getName().equals(activitySearch.getName())) {
                            System.out.println("\tDestination name::" + destination.getDestinationName());
                        }
                    }
                }
            }
            if (passenger.getPassengerType().equals(PassengerType.STANDARD)
                    || passenger.getPassengerType().equals(PassengerType.GOLD)) {
                if (passenger.getPassengerType().equals(PassengerType.GOLD)) {
                    System.out.println("\tPrice paid::" + activity.getCost() * 0.9);
                } else {
                    System.out.println("\tPrice paid::" + activity.getCost());
                }
            } else {
                System.out.println("\tPrice paid:: NONE");
            }
        }
    }

    public static Passenger getPassenger(List<Passenger> passengerList) throws EmptyListException {
        // choose a passenger
        if (passengerList.isEmpty()) {
            throw new EmptyListException("Passenger list is empty.");
        }
        for (int i = 0; i < passengerList.size(); i++) {
            System.out.println(i + 1 + ":\t" + passengerList.get(i).getPassengerName() + "\t\t"
                    + passengerList.get(i).getPassengerNumber());
        }
        int passengerChoice = sc.nextInt();
        Passenger chosenPassenger = passengerList.get(passengerChoice - 1);
        sc.nextLine();
        return chosenPassenger;

    }
}
