/*package com.capgemini.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.exception.BookingDateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.capgemini.dto.BookingDTO;
import com.capgemini.dto.VehicleDTO;
import com.capgemini.dto.UserDTO;
import com.capgemini.entity.Booking;
import com.capgemini.exception.BookingNotFoundException;
import com.capgemini.exception.VehicleNotFoundException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.service.IBookingService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/bookings")
@Slf4j
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    @PostMapping("/register")
    public ResponseEntity<?> addBooking(@Valid @RequestBody BookingDTO bookingDTO, BindingResult result) {
        log.info("Received request to add booking: {}", bookingDTO);

        if (result.hasErrors()) {
            List<String> errorMessages = result.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            log.warn("Validation errors: {}", errorMessages);
            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }

        try {
            Booking newBooking = bookingService.addBooking(bookingDTO);
            log.info("Booking added successfully with ID: {}", newBooking.getBookingId());
            return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
        } catch (VehicleNotFoundException | UserNotFoundException e) {
            log.error("Error: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<?> updateBooking(@PathVariable int bookingId, @Valid @RequestBody BookingDTO bookingDTO, BindingResult result) {
        log.info("Received request to update booking ID: {}", bookingId);

        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Booking updatedBooking = bookingService.updateBooking(bookingId, bookingDTO);
            log.info("Booking updated successfully: {}", updatedBooking);
            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        } catch (BookingNotFoundException | VehicleNotFoundException | UserNotFoundException e) {
            log.error("Error updating booking: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
        log.info("Received request to cancel booking ID: {}", bookingId);

        try {
            bookingService.cancelBooking(bookingId);
            log.info("Booking canceled successfully: {}", bookingId);
            return new ResponseEntity<>("Booking canceled successfully", HttpStatus.OK);
        } catch (BookingNotFoundException e) {
            log.error("Booking not found: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<?> viewBooking(@PathVariable int bookingId) {
        log.info("Fetching booking details for ID: {}", bookingId);

        try {
            Booking booking = bookingService.viewBooking(bookingId);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } catch (BookingNotFoundException e) {
            log.error("Booking not found: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<?> viewAllBookingsByVehicle(@PathVariable Integer vehicleId) {
        log.info("Fetching all bookings for vehicle ID: {}", vehicleId);

        try {
            List<Booking> bookings = bookingService.viewAllBookingsByVehicle(vehicleId);
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } catch (VehicleNotFoundException e) {
            log.error("Vehicle not found: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/date/{bookingDate}")
    public ResponseEntity<?> viewAllBookingsByDate(@PathVariable String bookingDate) {
        log.info("Fetching bookings for date: {}", bookingDate);

        try {
            LocalDate date = LocalDate.parse(bookingDate);
            List<Booking> bookings = bookingService.viewAllBookingsByDate(date);
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } catch (BookingDateNotFoundException e) {
            log.error("No bookings found: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("Invalid date format: {}", e.getMessage());
            return new ResponseEntity<>("Invalid date format. Use YYYY-MM-DD.", HttpStatus.BAD_REQUEST);
        }
    }

    // Fetch vehicle details using Feign Client
    @GetMapping("/vehicle/details/{vehicleId}")
    public ResponseEntity<?> getVehicleDetails(@PathVariable int vehicleId) {
        log.info("Fetching vehicle details for vehicle ID: {}", vehicleId);

        try {
            VehicleDTO vehicle = bookingService.getVehicleDetails(vehicleId);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } catch (VehicleNotFoundException e) {
            log.error("Vehicle not found", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Fetch user details using Feign Client
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserDetails(@PathVariable Long userId) {
        log.info("Fetching user details for user ID: {}", userId);

        try {
            UserDTO user = bookingService.getUserById(userId);  // Fetch user details from User Service
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            log.error("User not found: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
*/
//package com.capgemini.controller;
//
//import com.capgemini.dto.BookingDTO;
//import com.capgemini.dto.VehicleDTO;
//import com.capgemini.entity.Booking;
//import com.capgemini.exception.BookingNotFoundException;
//import com.capgemini.service.IBookingService;
// // Assuming this service is responsible for fetching vehicle details
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@RestController
//@RequestMapping("/bookings")
//public class BookingController {
//
//    @Autowired
//    private IBookingService bookingService;
//
//    // Endpoint to add a new booking
//    @PostMapping("/register")
//    public ResponseEntity<Booking> addBooking(@RequestBody BookingDTO bookingDTO) {
//        Booking booking = bookingService.addBooking(bookingDTO);
//        return new ResponseEntity<>(booking, HttpStatus.CREATED);
//    }
//
//    // Endpoint to update an existing booking
//    @PutMapping("/{bookingId}")
//    public ResponseEntity<Booking> updateBooking(@PathVariable int bookingId, @RequestBody BookingDTO bookingDTO) {
//        Booking updatedBooking = bookingService.updateBooking(bookingId, bookingDTO);
//        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
//    }
//
//    // Endpoint to cancel a booking
//    @DeleteMapping("/{bookingId}")
//    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
//        try {
//            // Call the service method to cancel the booking
//            bookingService.cancelBooking(bookingId);
//
//            // Return a success message with HTTP status OK
//            return new ResponseEntity<>("Booking cancelled successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            // In case of an error, such as the booking not found, return an error message
//            return new ResponseEntity<>("Booking cancellation failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    // Endpoint to view a single booking by its ID
//    @GetMapping("/{bookingId}")
//    public ResponseEntity<Booking> viewBooking(@PathVariable int bookingId) {
//        Booking booking = bookingService.viewBooking(bookingId);
//        return new ResponseEntity<>(booking, HttpStatus.OK);
//    }
//
//    // Endpoint to view all bookings for a specific vehicle
//    @GetMapping("/vehicle/{vehicleId}")
//    public ResponseEntity<List<Booking>> viewAllBookingsByVehicle(@PathVariable int vehicleId) {
//        List<Booking> bookings = bookingService.viewAllBookingsByVehicle(vehicleId);
//        return new ResponseEntity<>(bookings, HttpStatus.OK);
//    }
//
//    // Endpoint to view all bookings on a specific date
//    @GetMapping("/date/{bookingDate}")
//    public ResponseEntity<List<Booking>> viewAllBookingsByDate(@PathVariable String bookingDate) {
//        LocalDate date = LocalDate.parse(bookingDate);  // Parse the string into LocalDate
//        List<Booking> bookings = bookingService.viewAllBookingsByDate(date);
//        return new ResponseEntity<>(bookings, HttpStatus.OK);
//    }
//
//    // Endpoint to get vehicle details by its ID along with associated booking details
////    @GetMapping("/vehicle-details/{vehicleId}")
////    public ResponseEntity<VehicleDTO> getVehicleAndBookingDetails(@PathVariable int vehicleId) {
////        VehicleDTO vehicle = vehicleService.getVehicleById(vehicleId); // Fetch vehicle details
////
////        // If vehicle is found, fetch associated bookings
////        if (vehicle != null) {
////            List<Booking> bookings = bookingService.viewAllBookingsByVehicle(vehicleId);
////            // Assuming vehicleDTO has a method to set bookings
////            vehicle.setBookings(bookings);  // Set the associated bookings in the vehicle DTO
////            return new ResponseEntity<>(vehicle, HttpStatus.OK);
////        } else {
////            // If the vehicle doesn't exist, return an error response
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////    }
//
//    // Feign client method to fetch vehicle details from an external service
//    @GetMapping("/vehicle/details/{vehicleId}")
//    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable int vehicleId) {
//        VehicleDTO vehicle = bookingService.getVehicleById(vehicleId); // Fetch vehicle using service method
//        if (vehicle != null) {
//            return new ResponseEntity<>(vehicle, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}



//package com.capgemini.controller;
//
//import com.capgemini.dto.BookingDTO;
//import com.capgemini.dto.VehicleDTO;
//import com.capgemini.entity.Booking;
//import com.capgemini.exception.BookingNotFoundException;
//import com.capgemini.service.IBookingService;
//import jakarta.validation.Valid;
//import lombok.extern.slf4j.Slf4j; // Import the Lombok annotation
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Slf4j  // Lombok annotation automatically creates a logger named 'log'
//@RestController
//@RequestMapping("/bookings")
//public class BookingController {
//
//    @Autowired
//    private IBookingService bookingService;
//
//    // Endpoint to add a new booking
//    @PostMapping("/register")
//    public ResponseEntity<Booking> addBooking(@Valid @RequestBody BookingDTO bookingDTO) {
//        log.info("Received request to add a new booking: {}", bookingDTO);
//        Booking booking = bookingService.addBooking(bookingDTO);
//        log.info("Booking added successfully with ID: {}", booking.getBookingId());
//        return new ResponseEntity<>(booking, HttpStatus.CREATED);
//    }
//
//    // Endpoint to update an existing booking
//    @PutMapping("/{bookingId}")
//    public ResponseEntity<Booking> updateBooking(@PathVariable int bookingId, @RequestBody BookingDTO bookingDTO) {
//        log.info("Received request to update booking with ID: {}", bookingId);
//        Booking updatedBooking = bookingService.updateBooking(bookingId, bookingDTO);
//        log.info("Booking updated successfully with ID: {}", updatedBooking.getBookingId());
//        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
//    }
//
//    // Endpoint to cancel a booking
//    @DeleteMapping("/{bookingId}")
//    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
//        try {
//            log.info("Received request to cancel booking with ID: {}", bookingId);
//            bookingService.cancelBooking(bookingId);
//            log.info("Booking with ID: {} cancelled successfully", bookingId);
//            return new ResponseEntity<>("Booking cancelled successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Failed to cancel booking with ID: {}. Error: {}", bookingId, e.getMessage());
//            return new ResponseEntity<>("Booking cancellation failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    // Endpoint to view a single booking by its ID
//    @GetMapping("/{bookingId}")
//    public ResponseEntity<Booking> viewBooking(@PathVariable int bookingId) {
//        log.info("Received request to view booking with ID: {}", bookingId);
//        Booking booking = bookingService.viewBooking(bookingId);
//        log.info("Retrieved booking details for ID: {}", bookingId);
//        return new ResponseEntity<>(booking, HttpStatus.OK);
//    }
//
//    // Endpoint to view all bookings for a specific vehicle
//    @GetMapping("/vehicle/{vehicleId}")
//    public ResponseEntity<List<Booking>> viewAllBookingsByVehicle(@PathVariable int vehicleId) {
//        log.info("Received request to view all bookings for vehicle with ID: {}", vehicleId);
//        List<Booking> bookings = bookingService.viewAllBookingsByVehicle(vehicleId);
//        log.info("Retrieved {} bookings for vehicle with ID: {}", bookings.size(), vehicleId);
//        return new ResponseEntity<>(bookings, HttpStatus.OK);
//    }
//
//    // Endpoint to view all bookings on a specific date
//    @GetMapping("/date/{bookingDate}")
//    public ResponseEntity<List<Booking>> viewAllBookingsByDate(@PathVariable String bookingDate) {
//        log.info("Received request to view all bookings for the date: {}", bookingDate);
//        LocalDate date = LocalDate.parse(bookingDate);  // Parse the string into LocalDate
//        List<Booking> bookings = bookingService.viewAllBookingsByDate(date);
//        log.info("Retrieved {} bookings for the date: {}", bookings.size(), bookingDate);
//        return new ResponseEntity<>(bookings, HttpStatus.OK);
//    }
//
//    // Feign client method to fetch vehicle details from an external service
//    @GetMapping("/vehicle/details/{vehicleId}")
//    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable int vehicleId) {
//        log.info("Received request to fetch details for vehicle with ID: {}", vehicleId);
//        VehicleDTO vehicle = bookingService.getVehicleById(vehicleId); // Fetch vehicle using service method
//        if (vehicle != null) {
//            log.info("Successfully fetched vehicle details for vehicle ID: {}", vehicleId);
//            return new ResponseEntity<>(vehicle, HttpStatus.OK);
//        } else {
//            log.error("Vehicle not found with ID: {}", vehicleId);
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}



package com.capgemini.controller;

import com.capgemini.dto.BookingDTO;
import com.capgemini.dto.VehicleDTO;
import com.capgemini.dto.UserDTO;
import com.capgemini.entity.Booking;
import com.capgemini.exception.BookingDateNotFoundException;
import com.capgemini.exception.BookingNotFoundException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.exception.VehicleNotFoundException;
import com.capgemini.service.IBookingService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    // Endpoint to add a new booking
    @PostMapping("/register")
    public ResponseEntity<Booking> addBooking(@Valid @RequestBody BookingDTO bookingDTO) {
        try {
            Booking booking = bookingService.addBooking(bookingDTO);
            return new ResponseEntity<>(booking, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error adding booking: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to update an existing booking
    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int bookingId, @RequestBody BookingDTO bookingDTO) {
        try {
            Booking updatedBooking = bookingService.updateBooking(bookingId, bookingDTO);
            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        } catch (BookingNotFoundException e) {
            log.error("Booking not found: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to cancel a booking
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable int bookingId) {
        try {
            bookingService.cancelBooking(bookingId);
            return new ResponseEntity<>("Booking cancelled successfully", HttpStatus.OK);
        } catch (BookingNotFoundException e) {
            return new ResponseEntity<>("Booking cancellation failed: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to view a single booking by its ID
    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> viewBooking(@PathVariable int bookingId) {
        try {
            Booking booking = bookingService.viewBooking(bookingId);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } catch (BookingNotFoundException e) {
            log.error("Booking not found: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to view all bookings for a specific vehicle
    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<Booking>> viewAllBookingsByVehicle(@PathVariable int vehicleId) {
        try {
            List<Booking> bookings = bookingService.viewAllBookingsByVehicle(vehicleId);
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } catch (VehicleNotFoundException e) {
            log.error("No bookings found for vehicle: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to view all bookings on a specific date
    @GetMapping("/date/{bookingDate}")
    public ResponseEntity<List<Booking>> viewAllBookingsByDate(@PathVariable String bookingDate) {
        try {
            LocalDate date = LocalDate.parse(bookingDate);
            List<Booking> bookings = bookingService.viewAllBookingsByDate(date);
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } catch (BookingDateNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to fetch user details with associated bookings
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        try {
            UserDTO user = bookingService.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            log.error("User not found: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Feign client method to fetch vehicle details from an external service
    @GetMapping("/vehicle/details/{vehicleId}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable int vehicleId) {
        try {
            VehicleDTO vehicle = bookingService.getVehicleById(vehicleId);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } catch (VehicleNotFoundException e) {
            log.error("Vehicle not found: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


