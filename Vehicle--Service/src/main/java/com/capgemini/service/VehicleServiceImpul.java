package com.capgemini.service;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.client.DriverClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.dto.VehicleDTO;
import com.capgemini.dto.VehicleWithDriverDTO;
import com.capgemini.dto.DriverDTO;
import com.capgemini.entity.Vehicle;
import com.capgemini.entity.VehicleStatus;
import com.capgemini.exception.VehicleNotFoundException;
import com.capgemini.repository.VehicleRepository;

@Service
public class VehicleServiceImpul implements Ivehicle {

    private static final Logger logger = LoggerFactory.getLogger(VehicleServiceImpul.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DriverClient driverClient; // Feign Client for driver-service

    //To get the vehicle by id
    @Override
    public VehicleDTO getVehicleById(int id) {
        logger.info("Fetching vehicle with ID: {}", id);
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with ID: " + id));
        logger.info("Vehicle retrieved successfully: {}", vehicle);
        return convertToDTO(vehicle);
    }

    @Override
    @Transactional
    //to register the vehicle
    public VehicleDTO registerVehicle(VehicleDTO vehicleDTO) {
        logger.info("Registering new vehicle: {}", vehicleDTO);
        Vehicle vehicle = convertToEntity(vehicleDTO);
        vehicle = vehicleRepository.save(vehicle);
        logger.info("Vehicle registered successfully with ID: {}", vehicle.getVehicleId());
        return convertToDTO(vehicle);
    }

    @Override
    @Transactional
    //to update the vehicle details
    public VehicleDTO updateVehicle(int id, VehicleDTO vehicleDTO) {
        logger.info("Updating vehicle with ID: {}", id);
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with ID: " + id));

        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setType(vehicleDTO.getType());
        vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        vehicle.setDriverId(vehicleDTO.getDriverId());
        vehicle.setStatus(vehicleDTO.getStatus());

        vehicle = vehicleRepository.save(vehicle);
        logger.info("Vehicle updated successfully: {}", convertToDTO(vehicle));
        return convertToDTO(vehicle);
    }

    //to update  just vehicle status
    @Override
    @Transactional
    public void deleteVehicle(int id) {
        logger.info("Deleting vehicle with ID: {}", id);
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with ID: " + id));
        vehicleRepository.delete(vehicle);
        logger.info("Vehicle with ID: {} deleted successfully.", id);
    }
    //to get the vehicles with vehiclestatus as available
    @Override
    public List<VehicleDTO> getAvailableVehicles() {
        logger.info("Fetching all available vehicles.");
        List<Vehicle> availableVehicles = vehicleRepository.findByStatus(VehicleStatus.AVAILABLE);
        logger.info("Found {} available vehicles.", availableVehicles.size());
        return availableVehicles.stream().map(this::convertToDTO).collect(Collectors.toList());
    }


    //to update only the  vehiclestatus
    @Override
    @Transactional
    public VehicleDTO updateVehicleStatus(int id, VehicleStatus status) {
        logger.info("Updating vehicle status for ID: {} to status: {}", id, status);
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with ID: " + id));

        if (vehicle.getStatus() == status) {
            logger.info("Vehicle ID: {} already has status: {}. No update required.", id, status);
            return convertToDTO(vehicle);
        }

        vehicle.setStatus(status);
        vehicle = vehicleRepository.save(vehicle);
        logger.info("Vehicle status updated successfully: {}", vehicle);
        return convertToDTO(vehicle);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        logger.info("Fetching all vehicles.");
        List<Vehicle> vehicles = vehicleRepository.findAll();
        logger.info("Total vehicles found: {}", vehicles.size());
        return vehicles.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public VehicleWithDriverDTO getVehicleWithDriver(int id) {
        logger.info("Fetching vehicle with driver details for ID: {}", id);
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with ID: " + id));

        DriverDTO driver = null;
        if (vehicle.getDriverId()!=null) {
            try {
                driver = driverClient.getDriverDetails(vehicle.getDriverId());
                logger.info("Driver details fetched successfully for vehicle ID: {}", id);
            } catch (Exception e) {
                logger.warn("Failed to fetch driver details for vehicle ID: {}. Error: {}", id, e.getMessage());
            }}

        else
        {
            logger.info("No driver assigned for vehicle ID: {}", id);
        }

        VehicleDTO vehicleDTO = convertToDTO(vehicle);
        return new VehicleWithDriverDTO(vehicleDTO, driver);
    }

    private VehicleDTO convertToDTO(Vehicle vehicle) {
        return new VehicleDTO(vehicle.getVehicleId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getType(),
                vehicle.getRegistrationNumber(), vehicle.getDriverId(), vehicle.getStatus());
    }

    private Vehicle convertToEntity(VehicleDTO vehicleDTO) {
        return new Vehicle(vehicleDTO.getVehicleId(), vehicleDTO.getBrand(), vehicleDTO.getModel(),
                vehicleDTO.getType(), vehicleDTO.getRegistrationNumber(), vehicleDTO.getDriverId(),
                vehicleDTO.getStatus());
    }
}