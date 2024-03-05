import java.util.List;
import java.util.Scanner;

public class DestinationsController {
    static Scanner sc = new Scanner(System.in);

    // Create a new destination for a travel package
    public static void createDestination(TravelPackage chosenPackage) {
        String destinationName = Input.getInput(sc, "Enter Destination name::");
        Destinations destination = new Destinations(destinationName);
        List<Destinations> destinationList = chosenPackage.getDestinationList();
        destinationList.add(destination);
        chosenPackage.setDestinationList(destinationList);
    }

    // Get a destination from a travel package
    public static Destinations getDestination(TravelPackage chosenPackage) throws EmptyListException {
        // choose a Destination
        if (chosenPackage.getDestinationList().isEmpty()) {
            throw new EmptyListException("Destination list is empty.");
        }
        for (int i = 0; i < chosenPackage.getDestinationList().size(); i++) {
            System.out.println(i + 1 + ":\t" + chosenPackage.getDestinationList().get(i).getDestinationName());
        }
        int destinationChoice = Input.getIntInput(sc, "Choose your destination::");
        Destinations chosenDestination = chosenPackage.getDestinationList().get(destinationChoice - 1);
        sc.nextLine();
        return chosenDestination;
    }
}
