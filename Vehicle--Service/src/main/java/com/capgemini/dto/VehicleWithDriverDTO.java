/*package com.capgemini.dto;

public class VehicleWithDriverDTO {
    private VehicleDTO vehicle;
    private DriverDTO driver;

    public VehicleWithDriverDTO(VehicleDTO vehicle, DriverDTO driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }
}*/

package com.capgemini.dto;

// Data Transfer Object (DTO) combining Vehicle and Driver details
public class VehicleWithDriverDTO {

    private VehicleDTO vehicle; // Vehicle details
    private DriverDTO driver; // Driver details

    // Parameterized constructor
    public VehicleWithDriverDTO(VehicleDTO vehicle, DriverDTO driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }

    // Getter for vehicle details
    public VehicleDTO getVehicle() {
        return vehicle;
    }

    // Setter for vehicle details
    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    // Getter for driver details
    public DriverDTO getDriver() {
        return driver;
    }

    // Setter for driver details
    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }
}
