/**
 * Represents train engine, managing fuel type, fuel level, and engine status.
 */
public class Engine {
    public FuelType FuelType;       // Type of fuel
    private final double maxFuelLevel;   // Maximum fuel level
    public double currentFuelLevel; // Current fuel level

    /**
     * Constructs an Engine with fuel type and maximum fuel capacity.
     *
     * @param FuelType     the type of fuel the engine uses
     * @param maxFuelLevel the maximum fuel capacity of the engine
     */
    public Engine(FuelType FuelType, double maxFuelLevel) {
        this.FuelType = FuelType;
        this.maxFuelLevel = maxFuelLevel;
        this.currentFuelLevel = 0.0; // starting with empty tank
    }

    /**
     * Gets the type of fuel used by the engine
     *
     * @return the FuelType of the engine
     */
    public FuelType getFuelType() {
        return FuelType;
    }

    /**
     * Gets the current fuel level of the engine
     *
     * @return the current fuel level
     */
    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    /**
     * Sets the current fuel level of the engine
     *
     * @param fuelLevel  the fuel level to set
     * @throws IllegalArgumentException if the fuel level is negative
     */
    public void setCurrentFuelLevel(double currentFuelLevel) {
        if (currentFuelLevel < 0) {
            throw new IllegalArgumentException("Fuel level cannot be negative.");
        }
        if (currentFuelLevel > maxFuelLevel) {
            throw new IllegalArgumentException("Fuel level cannot exceed the maximum capacity of " + maxFuelLevel + ".");
        }
        this.currentFuelLevel = currentFuelLevel;
    }

    /**
     * Gets the maximum fuel capacity of the engine
     *
     * @return the maximum fuel level
     */
    public double getMaxFuelLevel() {
        return maxFuelLevel;
    }

    /**
     * Refuels the engine, sets current fuel level back to maximum
     */
    public void refuel() {
        this.currentFuelLevel = maxFuelLevel;
    }

    /**
     * Decreases the current fuel level by 1 and then prints remaining fuel
     */
    public boolean go() {
        if (currentFuelLevel > 0) {
            currentFuelLevel--; // Decrease fuel level by 1
            System.out.println("Engine is running. Remaining fuel: " + currentFuelLevel);
            return true; // Fuel level is above 0
        } else {
            return false; // There is no fuel left
        }
    }

}

