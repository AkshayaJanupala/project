
/*package com.capgemini.dto;

import com.capgemini.entity.VehicleStatus;
import jakarta.validation.constraints.*;

public class VehicleDTO {

	private int vehicleId;

	@NotBlank(message = "{vehicle.brand.required}")
	private String brand;

	@NotBlank(message = "{vehicle.model.required}")
	private String model;

	@NotBlank(message = "{vehicle.type.required}")
	private String type;

	@NotBlank(message = "{vehicle.registration.required}")
	@Size(min = 10, max = 10, message = "{vehicle.registration.size}")
	@Pattern(regexp = "^[A-Z]{2}\\d{2}[A-Z]{2}\\d{4}$", message = "{vehicle.registration.pattern}")
	private String registrationNumber;

	@PositiveOrZero(message = "{vehicle.driverId.positive}")
	@NotNull(message = "{vehicle.driverId.required}")
	private Integer driverId;

	@NotNull(message = "{vehicle.status.required}")
	private VehicleStatus status;



	// Getters and Setters
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public VehicleStatus getStatus() {
		return status;
	}

	public void setStatus(VehicleStatus status) {
		this.status = status;
	}



	// Parameterized Constructor
	public VehicleDTO(int vehicleId, String brand, String model, String type,
					  String registrationNumber, Integer driverId, VehicleStatus status) {
		this.vehicleId = vehicleId;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.registrationNumber = registrationNumber;
		this.driverId = driverId;
		this.status = status;

	}

	// No-argument Constructor
	public VehicleDTO() {
		super();
	}
}

*/

package com.capgemini.dto;

import com.capgemini.entity.VehicleStatus;
import jakarta.validation.constraints.*;
//data transfer object for vehicle
public class VehicleDTO {

	private int vehicleId; // Unique identifier for the vehicle

	@NotBlank(message = "{vehicle.brand.required}")
	private String brand; // Vehicle brand name

	@NotBlank(message = "{vehicle.model.required}")
	private String model; // Vehicle model name

	@NotBlank(message = "{vehicle.type.required}")
	private String type; // Type of vehicle (e.g., sedan, SUV, truck)

	@NotBlank(message = "{vehicle.registration.required}")
	@Size(min = 10, max = 10, message = "{vehicle.registration.size}")
	@Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$", message = "{vehicle.registration.pattern}")
	private String registrationNumber; // Vehicle registration number format: XX00XX0000

	@PositiveOrZero(message = "{vehicle.driverId.positive}")
	@NotNull(message = "{vehicle.driverId.required}")
	private Integer driverId; // Associated driver's ID

	@NotNull(message = "{vehicle.status.required}")
	private VehicleStatus status; // Current status of the vehicle

	// Getters and Setters
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public VehicleStatus getStatus() {
		return status;
	}

	public void setStatus(VehicleStatus status) {
		this.status = status;
	}

	// Parameterized Constructor
	public VehicleDTO(int vehicleId, String brand, String model, String type,
					  String registrationNumber, Integer driverId, VehicleStatus status) {
		this.vehicleId = vehicleId;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.registrationNumber = registrationNumber;
		this.driverId = driverId;
		this.status = status;
	}

	// No-argument Constructor
	public VehicleDTO() {
		super();
	}
}
