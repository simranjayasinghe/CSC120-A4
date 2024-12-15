/**
 * Represents a passenger in car, stores name
 */
public class Passenger {
    private final String name;

    /**
     * Constructs a Passenger with a specified name
     *
     * @param name the name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the passenger
     *
     * @return the name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     * Attempts to board the passenger onto a specified car (if car is not full)
     *
     * @param c the car the passenger is attempting to board
     */
    public void boardCar(Car c) {
        boolean success = c.addPassenger(this); // Attempt to add this passenger to the car
        if (success) {
            System.out.println(name + " boarded the car");
        } else {
            System.out.println(name + " could not board the car - the car is full");
        }
    }
    
    /**
     * Attempts to remove the passenger from the car
     *
     * @param c the car the passenger is trying to exit
     */
    public void getOffCar(Car c) {
        boolean success = c.removePassenger(this); // Attempt to remove this passenger from the car
        if (success) {
            System.out.println(name + " exited the car");
        } else {
            System.out.println(name + " is not in the car, could not be removed.");
        }
    }
    
    /**
     * Returns the passenger's name as a string
     *
     * @return passenger's name
     */
    @Override
    public String toString() {
        return name;
    }

}
