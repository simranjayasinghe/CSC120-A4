import java.util.ArrayList;

/**
 * A train with an engine and a list of cars.
 */
public class Train {
    private final Engine engine;
    private final ArrayList<Car> cars;

    /**
     * Constructs a Train with fuel type, fuel capacity, number of cars, and passenger capacity per car
     *
     * @param fuelType           the type of fuel used by the train's engine
     * @param fuelCapacity       capacity of the train's fuel tank
     * @param nCars              number of cars in the train
     * @param passengerCapacity  passenger capacity for each car
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++) {
            this.cars.add(new Car(passengerCapacity));
        }
    }

    /**
     *  Gets the engine of the train
     *
     * @return  engine of the train
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Gets the car at an index
     * 
     * @param i the index of car to get
     * @return car at the index i
     */
    public Car getCar(int i){
        if (i >= 0 && i < cars.size()) {
            return cars.get(i);
        } else {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
    }

    /**
     * Gets the max total capacity of train, across all cars
     * 
     * @return maximum passenger capacity of train
     */
    public int getMaxCapacity()  {
        int totalCapacity = 0;
        for (Car car:cars) {
            totalCapacity += car.getCapacity();
        }
        return totalCapacity;
    }

    /**
     * Gets the total number of remaining seats on train, across all cars
     * 
     * @return number of remaining seats
     */
    public int seatsRemaining() {
        int totalSeatsRemaining = 0;
        for (Car car:cars) {
            totalSeatsRemaining += car.seatsRemaining();
        }
        return totalSeatsRemaining;
    }

    /**
     * Prints manifest of all passengers on train
     */
    public void printManifest(){
        System.out.println("Train Passenger Manifest: ");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.println("Car" + (i + 1) + ":");
            car.printManifest();
        }
    }

    /**
     * Testing things!
     * Refuel engine, run engine
     * Make a train, have passenger board
     * print max capacity, seats remaining, and manifest for each car in train
     *
     * @return number of remaining seats
     */
    public static void main(String[] args) {
        // Create a Train with 3 cars, each having a capacity of 5 passengers
        Train myTrain = new Train(FuelType.ELECTRIC, 5.0, 3, 5);

        //Refuel and run engine
        myTrain.getEngine().refuel();
        while (myTrain.getEngine().go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.\n");

        // Make and board passenger simran
        Passenger simran = new Passenger("Simran");
        simran.boardCar(myTrain.getCar(0)); // Car 1

        // Print train details
        System.out.println("\nTrain Maximum Capacity: " + myTrain.getMaxCapacity());
        System.out.println("Train Seats Remaining: " + myTrain.seatsRemaining());

        // Print the passenger manifest
        myTrain.printManifest();
    }
}
