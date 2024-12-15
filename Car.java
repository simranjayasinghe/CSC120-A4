import java.util.ArrayList;

/**
 * Represents a car with a max passenger capacity, and adds/removes passengers, keeps track of if car is full or not
 */
public class Car {
    private final int maxPassengers;
    public ArrayList<Passenger> passengers;

    /**
     * Constructs a Car with specified details and an associated engine
     *
     * @param maxPassengers the maximum number of passengers
     */
    public Car(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>(maxPassengers);
    }

    /**
     * Gets the maximum passenger capacity of the car
     *
     * @return the maximum passenger capacity
     */
    public int getCapacity() {
        return maxPassengers;
    }

    /**
     * Gets the number of remaining seats in the car
     *
     * @return the number of seats remaining
     */
    public int seatsRemaining() {
        return maxPassengers - passengers.size();
    }

    /**
     * Adds a passenger to the car if there is room
     *
     * @param p the passenger to add
     */
    public boolean addPassenger(Passenger p) {
        if (passengers.size() < maxPassengers) {
            passengers.add(p);
            return true; // Passenger successfully added
        } else {
            return false; // Car is full
        }
    }

    /**
     * Removes a passenger from the car
     *
     * @param p the passenger to remove
     */
    public boolean removePassenger(Passenger p) {
        if (passengers.contains(p)) {
            passengers.remove(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints list of passengers in the car
     */
    public void printManifest() {
        if (passengers.isEmpty()) {
            System.out.println("This car is EMPTY.");
        } else {
            System.out.println(passengers);
        }
    }

    
}

