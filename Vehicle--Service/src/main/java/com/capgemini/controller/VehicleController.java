
/*package com.capgemini.controller;

import com.capgemini.dto.VehicleDTO;
import com.capgemini.dto.VehicleWithDriverDTO;
import com.capgemini.entity.VehicleStatus;
import com.capgemini.service.VehicleServiceImpul;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleServiceImpul vehicleService;

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable int id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }
    @GetMapping("/{id}/with-driver")
    public ResponseEntity<VehicleWithDriverDTO> getVehicleWithDriver(@PathVariable int id) {
        VehicleWithDriverDTO vehicleWithDriver = vehicleService.getVehicleWithDriver(id);
        return ResponseEntity.ok(vehicleWithDriver);
    }

    @PostMapping("/register")
    public ResponseEntity<VehicleDTO> registerVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO createdVehicle = vehicleService.registerVehicle(vehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable int id, @Valid @RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok("Vehicle with ID " + id + " deleted successfully");
    }

    @GetMapping("/available")
    public ResponseEntity<List<VehicleDTO>> getAvailableVehicles() {
        return ResponseEntity.ok(vehicleService.getAvailableVehicles());
    }

    @GetMapping("/allvehicles")
    public ResponseEntity<List<VehicleDTO>> getAll() {
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<VehicleDTO> updateVehicleStatus( @PathVariable int id,
                                                           @Valid @RequestBody VehicleStatusUpdateRequest request) {
    
        VehicleStatus status = VehicleStatus.valueOf(request.getStatus().toUpperCase());

        return ResponseEntity.ok(vehicleService.updateVehicleStatus(id, status));
    }

    // Request body class for updating vehicle status
    public static class VehicleStatusUpdateRequest {

        // Using @Pattern to validate status input
        @Pattern(regexp = "AVAILABLE|BOOKED|MAINTENANCE", message = "Invalid status. Valid values are AVAILABLE, BOOKED, or MAINTENANCE.")
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
*/

/*
package com.capgemini.controller;

import com.capgemini.dto.VehicleDTO;
import com.capgemini.dto.VehicleWithDriverDTO;
import com.capgemini.entity.VehicleStatus;
import com.capgemini.service.VehicleServiceImpul;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleServiceImpul vehicleService;


     // Retrieves a vehicle by its ID.

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable int id) {
        logger.info("Fetching vehicle details for ID: {}", id);
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }


     // Retrieves a vehicle along with its assigned driver details.

    @GetMapping("/{id}/with-driver")
    public ResponseEntity<VehicleWithDriverDTO> getVehicleWithDriver(@PathVariable int id) {
        logger.info("Fetching vehicle with driver details for ID: {}", id);
        VehicleWithDriverDTO vehicleWithDriver = vehicleService.getVehicleWithDriver(id);
        return ResponseEntity.ok(vehicleWithDriver);
    }


     //Registers a new vehicle.

    @PostMapping("/register")
    public ResponseEntity<VehicleDTO> registerVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) {
        logger.info("Registering new vehicle: {}", vehicleDTO);
        VehicleDTO createdVehicle = vehicleService.registerVehicle(vehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }


     // Updates vehicle details by ID.

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable int id, @Valid @RequestBody VehicleDTO vehicleDTO) {
        logger.info("Updating vehicle with ID: {}", id);
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDTO));
    }


     // Deletes a vehicle by ID.

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
        logger.info("Deleting vehicle with ID: {}", id);
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok("Vehicle with ID " + id + " deleted successfully");
    }

       // Retrieves all available vehicles.

    @GetMapping("/available")
    public ResponseEntity<List<VehicleDTO>> getAvailableVehicles() {
        logger.info("Fetching all available vehicles");
        return ResponseEntity.ok(vehicleService.getAvailableVehicles());
    }


     // Retrieves a list of all vehicles.

    @GetMapping("/allvehicles")
    public ResponseEntity<List<VehicleDTO>> getAll() {
        logger.info("Fetching all vehicles");
        return ResponseEntity.ok(vehicleService.getAll());
    }


     // Updates the status of a vehicle by ID.

    @PutMapping("/{id}/status")
    public ResponseEntity<VehicleDTO> updateVehicleStatus(@PathVariable int id,
                                                          @Valid @RequestBody VehicleStatusUpdateRequest request) {
        logger.info("Updating status of vehicle with ID: {} to {}", id, request.getStatus());
        VehicleStatus status = VehicleStatus.valueOf(request.getStatus().toUpperCase());
        return ResponseEntity.ok(vehicleService.updateVehicleStatus(id, status));
    }


     // Request body class for updating vehicle status.

    public static class VehicleStatusUpdateRequest {

        @Pattern(regexp = "AVAILABLE|BOOKED|MAINTENANCE", message = "Invalid status. Valid values are AVAILABLE, BOOKED, or MAINTENANCE.")
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
*/

package com.capgemini.controller;

import com.capgemini.dto.VehicleDTO;
import com.capgemini.dto.VehicleWithDriverDTO;
import com.capgemini.entity.VehicleStatus;
import com.capgemini.service.VehicleServiceImpul;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleServiceImpul vehicleService;

    /**
     * Retrieves a vehicle by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable int id) {
        logger.info("Fetching vehicle details for ID: {}", id);
        VehicleDTO vehicle = vehicleService.getVehicleById(id);
        if (vehicle == null) {
            logger.warn("Vehicle with ID {} not found.", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(vehicle);
    }

    /**
     * Retrieves a vehicle along with its assigned driver details.
     */
    @GetMapping("/{id}/with-driver")
    public ResponseEntity<VehicleWithDriverDTO> getVehicleWithDriver(@PathVariable int id) {
        logger.info("Fetching vehicle with driver details for ID: {}", id);
        VehicleWithDriverDTO vehicleWithDriver = vehicleService.getVehicleWithDriver(id);
        return ResponseEntity.ok(vehicleWithDriver);
    }

    /**
     * Registers a new vehicle.
     */
    @PostMapping("/register")
    public ResponseEntity<VehicleDTO> registerVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) {
        logger.info("Registering new vehicle: {}", vehicleDTO);



        VehicleDTO createdVehicle = vehicleService.registerVehicle(vehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }

    /**
     * Updates vehicle details by ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable int id, @Valid @RequestBody VehicleDTO vehicleDTO) {
        logger.info("Updating vehicle with ID: {}", id);



        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDTO));
    }

    /**
     * Deletes a vehicle by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
        logger.info("Deleting vehicle with ID: {}", id);
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok("Vehicle with ID " + id + " deleted successfully");
    }

    /**
     * Retrieves all available vehicles.
     */
    @GetMapping("/available")
    public ResponseEntity<List<VehicleDTO>> getAvailableVehicles() {
        logger.info("Fetching all available vehicles");
        return ResponseEntity.ok(vehicleService.getAvailableVehicles());
    }

    /**
     * Retrieves a list of all vehicles.
     */
    @GetMapping("/allvehicles")
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        logger.info("Fetching all vehicles");
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    /**
     * Updates the status of a vehicle by ID.
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<VehicleDTO> updateVehicleStatus(@PathVariable int id,
                                                          @Valid @RequestBody VehicleStatusUpdateRequest request) {
        logger.info("Updating status of vehicle with ID: {} to {}", id, request.getStatus());
        VehicleStatus status;
        try {
            status = VehicleStatus.valueOf(request.getStatus().toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.error("Invalid status provided: {}", request.getStatus());
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(vehicleService.updateVehicleStatus(id, status));
    }

    /**
     * Request body class for updating vehicle status.
     */
    public static class VehicleStatusUpdateRequest {

        @Pattern(regexp = "AVAILABLE|BOOKED|MAINTENANCE", message = "Invalid status. Valid values are AVAILABLE, BOOKED, or MAINTENANCE.")
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}


