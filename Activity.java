
public class Activity {
    // Activity class to create Activity entities
    private String name, description;
    private double cost;
    private int capacity;

    Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
    }

    // Getter and setter for the fields
    protected String getName() {
        return name;
    }

    protected String getDescription() {
        return description;
    }

    protected double getCost() {
        return cost;
    }

    protected int getCapacity() {
        return capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
