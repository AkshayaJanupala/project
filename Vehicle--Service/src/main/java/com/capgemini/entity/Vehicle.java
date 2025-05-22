/*     package com.capgemini.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;

	@Column(nullable = false)
	private String brand;

	@Column(nullable = false)
	private String model;

	@Column(nullable = false)
	private String type; // Car, Bike, Truck

	@Column(nullable = false)
	private String registrationNumber;

	@Column(nullable = false)
	private Integer driverId;

	@Enumerated(EnumType.STRING)
	private VehicleStatus status; // AVAILABLE, BOOKED, MAINTENANCE

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

	public Vehicle(int vehicleId, String brand, String model, String type, String registrationNumber, Integer driverId,
			VehicleStatus status) {
		super();
		this.vehicleId = vehicleId;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.registrationNumber = registrationNumber;
		this.driverId = driverId;
		this.status = status;
	}

	public Vehicle() {
		super();
	}

	// Getters and Setters

}



*/






//package com.capgemini.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.*;
//
//@Entity
//@Table(name = "vehicles")
//public class Vehicle {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int vehicleId;
//
//	@Column(nullable = false)
//	private String brand;
//
//	@Column(nullable = false)
//	private String model;
//
//	@Column(nullable = false)
//	private String type; // Car, Bike, Truck
//
//	@Column(nullable = false)
//	private String registrationNumber;
//
//	@Column(nullable = false)
//	private int driverId;
//
//	@Enumerated(EnumType.STRING)
//	private VehicleStatus status; // AVAILABLE, BOOKED, MAINTENANCE
//
//	public int getVehicleId() {
//		return vehicleId;
//	}
//
//	public void setVehicleId(int vehicleId) {
//		this.vehicleId = vehicleId;
//	}
//
//	public String getBrand() {
//		return brand;
//	}
//
//	public void setBrand(String brand) {
//		this.brand = brand;
//	}
//
//	public String getModel() {
//		return model;
//	}
//
//	public void setModel(String model) {
//		this.model = model;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public String getRegistrationNumber() {
//		return registrationNumber;
//	}
//
//	public void setRegistrationNumber(String registrationNumber) {
//		this.registrationNumber = registrationNumber;
//	}
//
//	public int getDriverId() {
//		return driverId;
//	}
//
//	public void setDriverId(int driverId) {
//		this.driverId = driverId;
//	}
//
//	public VehicleStatus getStatus() {
//		return status;
//	}
//
//	public void setStatus(VehicleStatus status) {
//		this.status = status;
//	}
//
//	public Vehicle(int vehicleId, String brand, String model, String type, String registrationNumber, Integer driverId,
//			VehicleStatus status) {
//		super();
//		this.vehicleId = vehicleId;
//		this.brand = brand;
//		this.model = model;
//		this.type = type;
//		this.registrationNumber = registrationNumber;
//		this.driverId = driverId;
//		this.status = status;
//	}
//
//	public Vehicle() {
//		super();
//	}
//
//	// Getters and Setters
//
//}



/*
package com.capgemini.entity;

import com.capgemini.entity.VehicleStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "vehicles")
public class Vehicle {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;


	private String brand;


	private String model;


	private String type;


	private String registrationNumber;


	private Integer driverId;


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
	public Vehicle(int vehicleId, String brand, String model, String type,
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
	public Vehicle() {
		super();
	}
}
*/

/*
package com.capgemini.entity;

import com.capgemini.entity.VehicleStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

// Entity class representing a Vehicle
@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId; // Unique identifier for the vehicle

	private String brand; // Brand of the vehicle

	private String model; // Model of the vehicle

	private String type; // Type of the vehicle (e.g., Sedan, SUV)

	private String registrationNumber; // Registration number of the vehicle

	private Integer driverId; // ID of the assigned driver

	private VehicleStatus status; // Status of the vehicle (e.g., Available, Rented)

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
	public Vehicle(int vehicleId, String brand, String model, String type,
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
	public Vehicle() {
		super();
	}
}
*/



package com.capgemini.entity;

import com.capgemini.entity.VehicleStatus;
import jakarta.persistence.*;
		import jakarta.validation.constraints.*;

// Entity class representing a Vehicle
@Entity
@Table(name = "vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId; // Unique identifier for the vehicle

	private String brand; // Brand of the vehicle

	private String model; // Model of the vehicle

	private String type; // Type of the vehicle (e.g., Sedan, SUV)

	private String registrationNumber; // Registration number of the vehicle

	private Integer driverId; // ID of the assigned driver

	private VehicleStatus status; // Status of the vehicle (e.g., Available, Rented)

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
	public Vehicle(int vehicleId, String brand, String model, String type,
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
	public Vehicle() {
		super();
	}
}
