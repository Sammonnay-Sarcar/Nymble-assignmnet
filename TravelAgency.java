import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelAgency {
    private List<TravelPackage> travelPackageList = new ArrayList<>();
    private List<Passenger> PassengerList = new ArrayList<>();

    public static void main(String[] args) {
        TravelPackage chosenPackage;
        Passenger chosenPassenger;
        Destinations chosenDestination;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int x;
        TravelAgency obj = new TravelAgency();
        while (flag) {
            System.out.print("press 1 to continue, or 0 to quit::");
            x = sc.nextInt();
            if (x == 0) {
                flag = false;
            } else if (x == 1) {
                System.out.print("Enter::\n" +
                        "\t1 to get travel package details" + "\n" +
                        "\t2 to get passenger list of the travel package" + "\n" +
                        "\t3 to get passenger detail" + "\n" +
                        "\t4 to get the details of all the activities that still have spaces available, including how many spaces are available"
                        + "\n" +
                        "\t5 to get more options\nEnter your choice::");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:// working
                        try {
                            TravelPackageController
                                    .print(TravelPackageController.getTravelPackages(obj.travelPackageList));
                        } catch (Exception e) {
                            System.err.println("Error occurred: " + e.getMessage());
                            // Continue to the next iteration of the while loop
                            continue;
                        }
                        break;
                    case 2:// working
                        try {
                            TravelPackageController.print(obj.travelPackageList);
                        } catch (Exception e) {
                            System.err.println("Error occurred: " + e.getMessage());
                            continue;
                        }
                        break;
                    case 3:// working
                        try {
                            System.out.println("Fetching all the passengers...");
                            System.out.print("Choose from the following::\n");
                            PassengerController.print(PassengerController.getPassenger(obj.PassengerList));
                        } catch (Exception e) {
                            System.err.println("Error occurred: " + e.getMessage());
                            continue;
                        }
                        break;
                    case 4:// working
                        try {
                            ActivityController.print(obj.travelPackageList);
                        } catch (Exception e) {
                            System.err.println("Error occurred: " + e.getMessage());
                            continue;
                        }
                        break;
                    case 5:// working
                        System.out.print("Enter:\n" + "\t1 to create travel package\n " +
                                "\t2 to create a destination\n" +
                                "\t3 to create activity\n" +
                                "\t4 to create a passenger\n" +
                                "\t5 to book a travel package\n" +
                                "\t6 to book an activity\nEnter your choice::");
                        int moreChoice = sc.nextInt();
                        switch (moreChoice) {
                            case 1:// working
                                try {
                                    TravelPackage travelPackage = TravelPackageController.createTravelPackage();
                                    obj.travelPackageList.add(travelPackage);
                                } catch (Exception e) {
                                    System.err.println("Error occurred: " + e.getMessage());
                                    continue;
                                }
                                break;
                            case 2:// working
                                try {
                                    System.out.println("Fetching all travel packages...");
                                    System.out.print("Choose from the following::\n");
                                    chosenPackage = TravelPackageController.getTravelPackages(obj.travelPackageList);
                                    DestinationsController.createDestination(chosenPackage);
                                } catch (Exception e) {
                                    System.err.println("Error occurred: " + e.getMessage());
                                    continue;
                                }
                                break;
                            case 3:// working
                                try {
                                    System.out.println("Fetching all travel packages...");
                                    System.out.print("Choose from the following::\n");
                                    chosenPackage = TravelPackageController.getTravelPackages(obj.travelPackageList);
                                    chosenDestination = DestinationsController.getDestination(chosenPackage);
                                    ActivityController.createActivity(chosenDestination);
                                } catch (Exception e) {
                                    System.err.println("Error occurred: " + e.getMessage());
                                    continue;
                                }
                                break;
                            case 4:// working
                                try {
                                    Passenger passenger = PassengerController.createPassenger();
                                    obj.PassengerList.add(passenger);
                                } catch (Exception e) {
                                    System.err.println("Error occurred: " + e.getMessage());
                                    continue;
                                }
                                break;
                            case 5:// working
                                try {
                                    System.out.println("Fetching all the passengers...\nChoose from the following::");
                                    chosenPassenger = PassengerController.getPassenger(obj.PassengerList);
                                    System.out
                                            .println("Fetching all travel packages...\nChoose from the following::\n");
                                    chosenPackage = TravelPackageController.getTravelPackages(obj.travelPackageList);
                                    List<TravelPackage> travelPackageList = chosenPassenger.getTravelPackageList();
                                    travelPackageList.add(chosenPackage);
                                    chosenPassenger.setTravelPackageList(travelPackageList);
                                    int capacity = chosenPackage.getPackageCapacity();
                                    chosenPackage.setPackageCapacity(capacity - 1);
                                    List<Passenger> passengerList = chosenPackage.getPassengerList();
                                    passengerList.add(chosenPassenger);
                                    chosenPackage.setPassengerList(passengerList);
                                } catch (Exception e) {
                                    System.err.println("Error occurred: " + e.getMessage());
                                    continue;
                                }
                                break;
                            case 6:// working
                                try {
                                    System.out.print("Fetching all the passengers...\nChoose from the following::\n");
                                    chosenPassenger = PassengerController.getPassenger(obj.PassengerList);
                                    System.out.print("Choose from the following::");
                                    chosenPackage = TravelPackageController
                                            .getTravelPackages(chosenPassenger.getTravelPackageList());
                                    System.out.print("Choose from the following::");
                                    chosenDestination = DestinationsController
                                            .getDestination(chosenPackage);
                                    Activity chosenActivity = ActivityController
                                            .getChosenActivity(chosenDestination.getActivityList());
                                    // booking
                                    List<Activity> passengerActivityList = chosenPassenger.getActivityList();
                                    passengerActivityList.add(chosenActivity);
                                    chosenPassenger.setActivityList(passengerActivityList);
                                    // Calculate Balance
                                    if (chosenPassenger.getPassengerType().equals(PassengerType.STANDARD)) {
                                        chosenPassenger.setBalance(chosenPassenger.getBalance() -
                                                chosenActivity.getCost());
                                    } else if (chosenPassenger.getPassengerType().equals(PassengerType.GOLD)) {
                                        chosenPassenger.setBalance(
                                                chosenPassenger.getBalance() - (chosenActivity.getCost() * 0.9));
                                    }
                                    int activityCapacity = chosenActivity.getCapacity();
                                    chosenActivity.setCapacity(activityCapacity - 1);
                                } catch (Exception e) {
                                    System.err.println("Error occurred: " + e.getMessage());
                                    continue;
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                }

            }

            System.out.println("Done");
        }
        sc.close();
    }
}
