package com.capgemini.service;

import java.util.List;
import com.capgemini.dto.VehicleDTO;
import com.capgemini.dto.VehicleWithDriverDTO;
import com.capgemini.entity.VehicleStatus;

// Interface defining vehicle-related operations
public interface Ivehicle {

    // Method to register a new vehicle
    public VehicleDTO registerVehicle(VehicleDTO vehicleDTO);

    // Method to retrieve a list of available vehicles
    public List<VehicleDTO> getAvailableVehicles();

    // Method to retrieve a list of all vehicles
    public List<VehicleDTO> getAllVehicles();

    // Method to get a vehicle by its ID
    public VehicleDTO getVehicleById(int id);

    // Method to update the status of a vehicle
    public VehicleDTO updateVehicleStatus(int id, VehicleStatus status);

    // Method to delete a vehicle by its ID
    void deleteVehicle(int id);

    // Method to update vehicle details
    VehicleDTO updateVehicle(int id, VehicleDTO vehicleDTO);

    // Method to retrieve vehicle details along with assigned driver
    public VehicleWithDriverDTO getVehicleWithDriver(int id);
}
