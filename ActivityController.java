import java.util.List;
import java.util.Scanner;

public class ActivityController implements Print {
    static Scanner sc = new Scanner(System.in);

    public static void createActivity(Destinations destination) {
        // Take inputs for an activity
        String activityName = Input.getInput(sc, "Enter name of activity::");
        String activityDescription = Input.getInput(sc, "Enter activity description::");
        double activityCost = Input.getDoubleInput(sc, "Enter activity cost::");
        int activityCapacity = Input.getIntInput(sc, "Enter activity capacity::");
        // Create an activity
        Activity activity = new Activity(activityName, activityDescription, activityCost, activityCapacity);
        // Add the new activity to a destination
        List<Activity> activityList = destination.getActivityList();
        activityList.add(activity);
        destination.setActivityList(activityList);
        // Consume the empty line after it
        sc.nextLine();
    }

    public static Activity getChosenActivity(List<Activity> activityList) throws EmptyListException {
        if (activityList.isEmpty()) {
            throw new EmptyListException("Activity list is empty.");
        }
        // Choose an activity
        for (int i = 0; i < activityList.size(); i++) {
            System.out.println((i + 1) + ":\t" + activityList.get(i).getName());
        }
        int activityChoice = Input.getIntInput(sc, "Enter your selected activity::");
        Activity chosenActivity = activityList.get(activityChoice - 1);
        // Consume the empty line after it
        sc.nextLine();
        return chosenActivity;
    }

    public static void print(List<TravelPackage> packageList) {
        // Print all the activities having space for booking
        for (TravelPackage travelPackage : packageList) {
            for (Destinations destination : travelPackage.getDestinationList()) {
                for (Activity activity : destination.getActivityList()) {
                    if (activity.getCapacity() > 0) {
                        System.out.println("NAME::" + activity.getName() + "\tCAPACITY::" + activity.getCapacity());
                    }
                }
            }
        }
    }
}
