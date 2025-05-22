package com.capgemini;

import com.capgemini.client.DriverClient;
import com.capgemini.dto.VehicleDTO;
import com.capgemini.dto.VehicleWithDriverDTO;
import com.capgemini.dto.DriverDTO;
import com.capgemini.entity.Vehicle;
import com.capgemini.entity.VehicleStatus;
import com.capgemini.exception.VehicleNotFoundException;
import com.capgemini.repository.VehicleRepository;
import com.capgemini.service.VehicleServiceImpul;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImpulTest {

	@Mock
	private VehicleRepository vehicleRepository;

	@Mock
	private DriverClient driverClient; // Mock Feign Client

	@InjectMocks
	private VehicleServiceImpul vehicleService;

	private Vehicle vehicle;
	private VehicleDTO vehicleDTO;

	@BeforeEach
	void setUp() {
		vehicle = new Vehicle(1, "Toyota", "Camry", "Sedan", "AB1234", 101, VehicleStatus.AVAILABLE);
		vehicleDTO = new VehicleDTO(1, "Toyota", "Camry", "Sedan", "AB1234", 101, VehicleStatus.AVAILABLE);
	}

	//  1. Test fetching a vehicle by ID (Success)
	@Test
	void testGetVehicleById_Success() {
		when(vehicleRepository.findById(1)).thenReturn(Optional.of(vehicle));

		VehicleDTO result = vehicleService.getVehicleById(1);

		assertNotNull(result);
		assertEquals("Toyota", result.getBrand());
		assertEquals("Camry", result.getModel());

		verify(vehicleRepository, times(1)).findById(1);
	}

	// 2. Test fetching a vehicle by ID (Not Found)
	@Test
	void testGetVehicleById_NotFound() {
		when(vehicleRepository.findById(1)).thenReturn(Optional.empty());

		assertThrows(VehicleNotFoundException.class, () -> vehicleService.getVehicleById(1));

		verify(vehicleRepository, times(1)).findById(1);
	}

	// 3. Test registering a vehicle
	@Test
	void testRegisterVehicle() {
		when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);

		VehicleDTO result = vehicleService.registerVehicle(vehicleDTO);

		assertNotNull(result);
		assertEquals("Toyota", result.getBrand());

		verify(vehicleRepository, times(1)).save(any(Vehicle.class));
	}

	//  4. Test updating a vehicle (Success)
	@Test
	void testUpdateVehicle_Success() {
		when(vehicleRepository.findById(1)).thenReturn(Optional.of(vehicle));
		when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);

		VehicleDTO updatedDTO = new VehicleDTO(1, "Honda", "Civic", "Sedan", "XY9876", 102, VehicleStatus.BOOKED);

		VehicleDTO result = vehicleService.updateVehicle(1, updatedDTO);

		assertNotNull(result);
		assertEquals("Honda", result.getBrand());
		assertEquals("Civic", result.getModel());

		verify(vehicleRepository, times(1)).findById(1);
		verify(vehicleRepository, times(1)).save(any(Vehicle.class));
	}

	// 5. Test updating a vehicle (Not Found)
	@Test
	void testUpdateVehicle_NotFound() {
		when(vehicleRepository.findById(1)).thenReturn(Optional.empty());

		assertThrows(VehicleNotFoundException.class, () -> vehicleService.updateVehicle(1, vehicleDTO));

		verify(vehicleRepository, times(1)).findById(1);
	}

	//  6. Test deleting a vehicle (Success)
	@Test
	void testDeleteVehicle_Success() {
		when(vehicleRepository.findById(1)).thenReturn(Optional.of(vehicle));
		doNothing().when(vehicleRepository).delete(vehicle);

		assertDoesNotThrow(() -> vehicleService.deleteVehicle(1));

		verify(vehicleRepository, times(1)).findById(1);
		verify(vehicleRepository, times(1)).delete(vehicle);
	}

	//  7. Test deleting a vehicle (Not Found)
	@Test
	void testDeleteVehicle_NotFound() {
		when(vehicleRepository.findById(1)).thenReturn(Optional.empty());

		assertThrows(VehicleNotFoundException.class, () -> vehicleService.deleteVehicle(1));

		verify(vehicleRepository, times(1)).findById(1);
	}

	//  8. Test updating vehicle status
	@Test
	void testUpdateVehicleStatus() {
		when(vehicleRepository.findById(1)).thenReturn(Optional.of(vehicle));
		when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);

		VehicleDTO result = vehicleService.updateVehicleStatus(1, VehicleStatus.BOOKED);

		assertNotNull(result);
		assertEquals(VehicleStatus.BOOKED, result.getStatus());

		verify(vehicleRepository, times(1)).findById(1);
		verify(vehicleRepository, times(1)).save(any(Vehicle.class));
	}

	//  9. Test fetching all available vehicles
	@Test
	void testGetAvailableVehicles() {
		when(vehicleRepository.findByStatus(VehicleStatus.AVAILABLE)).thenReturn(Arrays.asList(vehicle));

		List<VehicleDTO> result = vehicleService.getAvailableVehicles();

		assertFalse(result.isEmpty());
		assertEquals(1, result.size());

		verify(vehicleRepository, times(1)).findByStatus(VehicleStatus.AVAILABLE);
	}

	//  10. Test fetching all vehicles
	@Test
	void testGetAllVehicles() {
		when(vehicleRepository.findAll()).thenReturn(Arrays.asList(vehicle));

		List<VehicleDTO> result = vehicleService.getAllVehicles();

		assertFalse(result.isEmpty());
		assertEquals(1, result.size());

		verify(vehicleRepository, times(1)).findAll();
	}

	//  11. Test fetching a vehicle with driver (Success)
	@Test
	void testGetVehicleWithDriver_Success() {
		DriverDTO driverDTO = new DriverDTO(101, "John", "Doe", "123 Street", "9876543210", "john.doe@example.com", "DL123456");

		when(vehicleRepository.findById(1)).thenReturn(Optional.of(vehicle));
		when(driverClient.getDriverDetails(101)).thenReturn(driverDTO);

		VehicleWithDriverDTO result = vehicleService.getVehicleWithDriver(1);

		assertNotNull(result);
		assertEquals("Toyota", result.getVehicle().getBrand());
		assertEquals("John", result.getDriver().getFirstName());
		assertEquals("Doe", result.getDriver().getLastName());
		assertEquals("123 Street", result.getDriver().getAddress());
		assertEquals("9876543210", result.getDriver().getMobileNumber());
		assertEquals("john.doe@example.com", result.getDriver().getEmailId());
		assertEquals("DL123456", result.getDriver().getLicenseNo());

		verify(vehicleRepository, times(1)).findById(1);
		verify(driverClient, times(1)).getDriverDetails(101);
	}

	// 12. Test fetching a vehicle with driver (Vehicle Not Found)
	@Test
	void testGetVehicleWithDriver_NotFound() {
		when(vehicleRepository.findById(1)).thenReturn(Optional.empty());

		assertThrows(VehicleNotFoundException.class, () -> vehicleService.getVehicleWithDriver(1));

		verify(vehicleRepository, times(1)).findById(1);
	}
}

