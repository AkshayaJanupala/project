/*package com.capgemini.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.exception.BookingDateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.client.UserClient;
import com.capgemini.client.VehicleClient;
import com.capgemini.dto.BookingDTO;
import com.capgemini.dto.UserDTO;
import com.capgemini.dto.VehicleDTO;
import com.capgemini.entity.Booking;
import com.capgemini.exception.BookingNotFoundException;
import com.capgemini.exception.UserNotFoundException;
import com.capgemini.exception.VehicleNotFoundException;
import com.capgemini.repository.BookingRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private VehicleClient vehicleClient;  // Feign Client for Vehicle

    @Autowired
    private UserClient userClient;  // Feign Client for User

    @Override
    public Booking addBooking(BookingDTO bookingDTO) {
        log.info("Fetching vehicle details for vehicle ID: {}", bookingDTO.getVehicleId());

        // Fetch vehicle details using Feign Client
        VehicleDTO vehicle = vehicleClient.getVehicleById(bookingDTO.getVehicleId());
        if (vehicle == null) {
            throw new VehicleNotFoundException("Vehicle not found with ID: " + bookingDTO.getVehicleId());
        }

        // Fetch user details using Feign Client
        UserDTO user = userClient.getUserById(bookingDTO.getUserId());
        if (user == null) {
            throw new UserNotFoundException("User not found with ID: " + bookingDTO.getUserId());
        }

        // Convert DTO to entity and save booking
        Booking booking = convertToEntity(bookingDTO);
        return bookingRepo.save(booking);  // Save the booking
    }

    @Override
    public Booking updateBooking(int bookingId, BookingDTO bookingDTO) {
        log.info("Updating booking with ID: {}", bookingId);

        // Check if the booking exists
        Booking existingBooking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));

        // Fetch vehicle details using Feign Client
        VehicleDTO vehicle = vehicleClient.getVehicleById(bookingDTO.getVehicleId());
        if (vehicle == null) {
            throw new VehicleNotFoundException("Vehicle not found with ID: " + bookingDTO.getVehicleId());
        }

        // Fetch user details using Feign Client
        UserDTO user = userClient.getUserById(bookingDTO.getUserId());
        if (user == null) {
            throw new UserNotFoundException("User not found with ID: " + bookingDTO.getUserId());
        }

        // Update fields of the existing booking
        existingBooking.setUserId(bookingDTO.getUserId());
        existingBooking.setVehicleId(bookingDTO.getVehicleId());
        existingBooking.setBookingDate(bookingDTO.getBookingDate());
        existingBooking.setBookedTillDate(bookingDTO.getBookedTillDate());
        existingBooking.setBookingDescription(bookingDTO.getBookingDescription());
        existingBooking.setTotalCost(bookingDTO.getTotalCost());
        existingBooking.setDistance(bookingDTO.getDistance());

        return bookingRepo.save(existingBooking);  // Save the updated booking
    }

    @Override
    public void cancelBooking(int bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
        bookingRepo.delete(booking);
    }

    @Override
    public Booking viewBooking(int bookingId) {
        return bookingRepo.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
    }

    @Override
    public List<Booking> viewAllBookingsByVehicle(int vehicleId) {
        List<Booking> bookings = bookingRepo.findByVehicleId(vehicleId);
        if (bookings.isEmpty()) {
            throw new BookingNotFoundException("No bookings found for vehicle with ID: " + vehicleId);
        }
        return bookings;
    }

    @Override
    public List<Booking> viewAllBookingsByDate(LocalDate bookingDate) {
        List<Booking> bookings = bookingRepo.findByBookingDate(bookingDate);
        if (bookings.isEmpty()) {
            throw new BookingDateNotFoundException("No bookings found for date: " + bookingDate);
        }
        return bookings;
    }

    // Helper method to convert BookingDTO to Booking entity
    public Booking convertToEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setUserId(bookingDTO.getUserId());
        booking.setVehicleId(bookingDTO.getVehicleId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setBookedTillDate(bookingDTO.getBookedTillDate());
        booking.setBookingDescription(bookingDTO.getBookingDescription());
        booking.setTotalCost(bookingDTO.getTotalCost());
        booking.setDistance(bookingDTO.getDistance());
        return booking;
    }

    // Helper method to convert Booking entity to BookingDTO
    public BookingDTO convertToDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setUserId(booking.getUserId());
        bookingDTO.setVehicleId(booking.getVehicleId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setBookedTillDate(booking.getBookedTillDate());
        bookingDTO.setBookingDescription(booking.getBookingDescription());
        bookingDTO.setTotalCost(booking.getTotalCost());
        bookingDTO.setDistance(booking.getDistance());
        return bookingDTO;
    }



    // Feign Client call to fetch vehicle details
    @Override
    public VehicleDTO getVehicleDetails(int vehicleId) {
        return vehicleClient.getVehicleById(vehicleId);
    }

    // Feign Client call to fetch user details
    @Override
    public UserDTO getUserById(Long userId) {
        return userClient.getUserById(userId);
    }
}
*/

//
//package com.capgemini.service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.capgemini.client.UserClient;  // Import UserClient
//import com.capgemini.client.VehicleClient;
//import com.capgemini.dto.BookingDTO;
//import com.capgemini.dto.UserDTO;  // Import UserDTO
//import com.capgemini.dto.VehicleDTO;
//import com.capgemini.entity.Booking;
//import com.capgemini.exception.BookingNotFoundException;
//import com.capgemini.exception.VehicleNotFoundException;
//import com.capgemini.repository.BookingRepo;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@Slf4j
//public class BookingServiceImpl implements IBookingService {
//
//    @Autowired
//    private BookingRepo bookingRepo;
//
//    @Autowired
//    private VehicleClient vehicleClient;  // Vehicle Feign Client
//
//    @Autowired
//    private UserClient userClient;  // User Feign Client
//
//    // Method to add a new booking
//    @Override
//    public Booking addBooking(BookingDTO bookingDTO) {
//        log.info("Fetching vehicle details for vehicle ID: {}", bookingDTO.getVehicleId());
//
//        // Fetch vehicle details using Feign Client
//        VehicleDTO vehicle;
//        try {
//            vehicle = vehicleClient.getVehicleById(bookingDTO.getVehicleId());
//        } catch (Exception e) {
//            log.error("Vehicle service error: {}", e.getMessage());
//            throw new VehicleNotFoundException("Vehicle service unavailable. Please try again later.");
//        }
//
//        if (vehicle == null) {
//            throw new VehicleNotFoundException("Vehicle not found with ID: " + bookingDTO.getVehicleId());
//        }
//
//        // Fetch user details using Feign Client
//        UserDTO user;
//        try {
//            user = userClient.getUserById(bookingDTO.getUserId());  // Fetch user details from User Service
//        } catch (Exception e) {
//            log.error("User service error: {}", e.getMessage());
//            throw new BookingNotFoundException("User service unavailable. Please try again later.");
//        }
//
//        if (user == null) {
//            throw new BookingNotFoundException("User not found with ID: " + bookingDTO.getUserId());
//        }
//
//        // Convert DTO to entity and save booking
//        Booking booking = convertToEntity(bookingDTO);
//        return bookingRepo.save(booking); // Save booking
//    }
//
//    // Method to update an existing booking
//    @Override
//    public Booking updateBooking(int bookingId, BookingDTO bookingDTO) {
//        log.info("Updating booking with ID: {}", bookingId);
//
//        // Check if booking exists
//        Booking existingBooking = bookingRepo.findById(bookingId)
//                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
//
//        // Fetch vehicle details using Feign Client
//        VehicleDTO vehicle;
//        try {
//            vehicle = vehicleClient.getVehicleById(bookingDTO.getVehicleId());
//        } catch (Exception e) {
//            log.error("Vehicle service error: {}", e.getMessage());
//            throw new VehicleNotFoundException("Vehicle service unavailable. Please try again later.");
//        }
//
//        if (vehicle == null) {
//            throw new VehicleNotFoundException("Vehicle not found with ID: " + bookingDTO.getVehicleId());
//        }
//
//        // Fetch user details using Feign Client
//        UserDTO user;
//        try {
//            user = userClient.getUserById(bookingDTO.getUserId());  // Fetch user details from User Service
//        } catch (Exception e) {
//            log.error("User service error: {}", e.getMessage());
//            throw new BookingNotFoundException("User service unavailable. Please try again later.");
//        }
//
//        if (user == null) {
//            throw new BookingNotFoundException("User not found with ID: " + bookingDTO.getUserId());
//        }
//
//        // Update fields of the existing booking
//        existingBooking.setUserId(bookingDTO.getUserId());
//        existingBooking.setVehicleId(bookingDTO.getVehicleId());
//        existingBooking.setBookingDate(bookingDTO.getBookingDate());
//        existingBooking.setBookedTillDate(bookingDTO.getBookedTillDate());
//        existingBooking.setBookingDescription(bookingDTO.getBookingDescription());
//        existingBooking.setTotalCost(bookingDTO.getTotalCost());
//        existingBooking.setDistance(bookingDTO.getDistance());
//
//        return bookingRepo.save(existingBooking); // Save updated booking
//    }
//
//    // Method to cancel a booking
//    @Override
//    public void cancelBooking(int bookingId) {
//        log.info("Cancelling booking with ID: {}", bookingId);
//
//        Booking existingBooking = bookingRepo.findById(bookingId)
//                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
//
//        bookingRepo.delete(existingBooking);
//    }
//
//    // Method to view a specific booking by ID
//    @Override
//    public Booking viewBooking(int bookingId) {
//        log.info("Fetching booking details for ID: {}", bookingId);
//
//        return bookingRepo.findById(bookingId)
//                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
//    }
//
//    // Method to view all bookings for a specific vehicle
//    @Override
//    public List<Booking> viewAllBookingsByVehicle(int vehicleId) {
//        log.info("Fetching all bookings for vehicle ID: {}", vehicleId);
//
//        List<Booking> bookings = bookingRepo.findByVehicleId(vehicleId);
//        if (bookings.isEmpty()) {
//            throw new VehicleNotFoundException("No bookings found for vehicle ID: " + vehicleId);
//        }
//        return bookings;
//    }
//
//    // Method to view all bookings by date
//    @Override
//    public List<Booking> viewAllBookingsByDate(LocalDate bookingDate) {
//        log.info("Fetching bookings for date: {}", bookingDate);
//
//        List<Booking> bookings = bookingRepo.findByBookingDate(bookingDate);
//        if (bookings.isEmpty()) {
//            throw new BookingNotFoundException("No bookings found for date: " + bookingDate);
//        }
//        return bookings;
//    }
//
//    // Method to fetch vehicle details
//    @Override
//    public VehicleDTO getVehicleDetails(int vehicleId) {
//        log.info("Fetching vehicle details for ID: {}", vehicleId);
//
//        VehicleDTO vehicle;
//        try {
//            vehicle = vehicleClient.getVehicleById(vehicleId);
//        } catch (Exception e) {
//            log.error("Vehicle service error: {}", e.getMessage());
//            throw new VehicleNotFoundException("Vehicle service unavailable. Please try again later.");
//        }
//
//        if (vehicle == null) {
//            throw new VehicleNotFoundException("Vehicle not found with ID: " + vehicleId);
//        }
//        return vehicle;
//    }
//
//    @Override
//    public UserDTO getUserById(Long userId) {
//        log.info("Fetching user details for user ID: {}", userId);
//
//        // Fetch user details using Feign Client
//        UserDTO user;
//        try {
//            user = userClient.getUserById(userId);  // Fetch user details from User Service
//        } catch (Exception e) {
//            log.error("User service error: {}", e.getMessage());
//            throw new BookingNotFoundException("User service unavailable. Please try again later.");
//        }
//
//        if (user == null) {
//            throw new BookingNotFoundException("User not found with ID: " + userId);
//        }
//
//        return user;
//    }
//
//
//    // Convert Booking entity to BookingDTO
//    public BookingDTO convertToDTO(Booking booking) {
//        BookingDTO bookingDTO = new BookingDTO();
//        bookingDTO.setUserId(booking.getUserId());
//        bookingDTO.setVehicleId(booking.getVehicleId());
//        bookingDTO.setBookingDate(booking.getBookingDate());
//        bookingDTO.setBookedTillDate(booking.getBookedTillDate());
//        bookingDTO.setBookingDescription(booking.getBookingDescription());
//        bookingDTO.setTotalCost(booking.getTotalCost());
//        bookingDTO.setDistance(booking.getDistance());
//        return bookingDTO;
//    }
//
//    // Convert BookingDTO to Booking entity
//    public Booking convertToEntity(BookingDTO bookingDTO) {
//        Booking booking = new Booking();
//        booking.setUserId(bookingDTO.getUserId());
//        booking.setVehicleId(bookingDTO.getVehicleId());
//        booking.setBookingDate(bookingDTO.getBookingDate());
//        booking.setBookedTillDate(bookingDTO.getBookedTillDate());
//        booking.setBookingDescription(bookingDTO.getBookingDescription());
//        booking.setTotalCost(bookingDTO.getTotalCost());
//        booking.setDistance(bookingDTO.getDistance());
//        return booking;
//    }
//}
//package com.capgemini.service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.capgemini.client.UserClient;  // Import UserClient
//import com.capgemini.client.VehicleClient;
//import com.capgemini.dto.BookingDTO;
//import com.capgemini.dto.UserDTO;  // Import UserDTO
//import com.capgemini.dto.VehicleDTO;
//import com.capgemini.entity.Booking;
//import com.capgemini.exception.BookingNotFoundException;
//import com.capgemini.exception.VehicleNotFoundException;
//import com.capgemini.repository.BookingRepo;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@Slf4j
//public class BookingServiceImpl implements IBookingService {
//
//    @Autowired
//    private BookingRepo bookingRepo;
//
//    @Autowired
//    private VehicleClient vehicleClient;  // Vehicle Feign Client
//
//    @Autowired
//    private UserClient userClient;  // User Feign Client
//
//    // Method to add a new booking
//    @Override
//    public Booking addBooking(BookingDTO bookingDTO) {
//        log.info("Fetching vehicle details for vehicle ID: {}", bookingDTO.getVehicleId());
//
//        // Fetch vehicle details using Feign Client
//        VehicleDTO vehicle;
//        try {
//            vehicle = vehicleClient.getVehicleById(bookingDTO.getVehicleId());
//        } catch (Exception e) {
//            log.error("Vehicle service error: {}", e.getMessage());
//            throw new VehicleNotFoundException("Vehicle service unavailable. Please try again later.");
//        }
//
//        if (vehicle == null) {
//            throw new VehicleNotFoundException("Vehicle not found with ID: " + bookingDTO.getVehicleId());
//        }
//
//        // Fetch user details using Feign Client
//        UserDTO user;
//        try {
//            user = userClient.getUserById(bookingDTO.getUserId());  // Fetch user details from User Service
//        } catch (Exception e) {
//            log.error("User service error: {}", e.getMessage());
//            throw new BookingNotFoundException("User service unavailable. Please try again later.");
//        }
//
//        if (user == null) {
//            throw new BookingNotFoundException("User not found with ID: " + bookingDTO.getUserId());
//        }
//
//        // Convert DTO to entity and save booking
//        Booking booking = convertToEntity(bookingDTO);
//        return bookingRepo.save(booking); // Save booking
//    }
//
//    // Method to update an existing booking
//    @Override
//    public Booking updateBooking(int bookingId, BookingDTO bookingDTO) {
//        log.info("Updating booking with ID: {}", bookingId);
//
//        // Check if booking exists
//        Booking existingBooking = bookingRepo.findById(bookingId)
//                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
//
//        // Fetch vehicle details using Feign Client
//        VehicleDTO vehicle;
//        try {
//            vehicle = vehicleClient.getVehicleById(bookingDTO.getVehicleId());
//        } catch (Exception e) {
//            log.error("Vehicle service error: {}", e.getMessage());
//            throw new VehicleNotFoundException("Vehicle service unavailable. Please try again later.");
//        }
//
//        if (vehicle == null) {
//            throw new VehicleNotFoundException("Vehicle not found with ID: " + bookingDTO.getVehicleId());
//        }
//
//        // Fetch user details using Feign Client
//        UserDTO user;
//        try {
//            user = userClient.getUserById(bookingDTO.getUserId());  // Fetch user details from User Service
//        } catch (Exception e) {
//            log.error("User service error: {}", e.getMessage());
//            throw new BookingNotFoundException("User service unavailable. Please try again later.");
//        }
//
//        if (user == null) {
//            throw new BookingNotFoundException("User not found with ID: " + bookingDTO.getUserId());
//        }
//
//        // Update fields of the existing booking
//        existingBooking.setUserId(bookingDTO.getUserId());
//        existingBooking.setVehicleId(bookingDTO.getVehicleId());
//        existingBooking.setBookingDate(bookingDTO.getBookingDate());
//        existingBooking.setBookedTillDate(bookingDTO.getBookedTillDate());
//        existingBooking.setBookingDescription(bookingDTO.getBookingDescription());
//        existingBooking.setTotalCost(bookingDTO.getTotalCost());
//        existingBooking.setDistance(bookingDTO.getDistance());
//
//        return bookingRepo.save(existingBooking); // Save updated booking
//    }
//
//    // Method to cancel a booking
//    @Override
//    public void cancelBooking(int bookingId) {
//        log.info("Cancelling booking with ID: {}", bookingId);
//
//        Booking existingBooking = bookingRepo.findById(bookingId)
//                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
//
//        bookingRepo.delete(existingBooking);
//    }
//
//    // Method to view a specific booking by ID
//    @Override
//    public Booking viewBooking(int bookingId) {
//        log.info("Fetching booking details for ID: {}", bookingId);
//
//        return bookingRepo.findById(bookingId)
//                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
//    }
//
//    // Method to view all bookings for a specific vehicle
//    @Override
//    public List<Booking> viewAllBookingsByVehicle(int vehicleId) {
//        log.info("Fetching all bookings for vehicle ID: {}", vehicleId);
//
//        List<Booking> bookings = bookingRepo.findByVehicleId(vehicleId);
//        if (bookings.isEmpty()) {
//            throw new VehicleNotFoundException("No bookings found for vehicle ID: " + vehicleId);
//        }
//        return bookings;
//    }
//
//    // Method to view all bookings by date
//    @Override
//    public List<Booking> viewAllBookingsByDate(LocalDate bookingDate) {
//        log.info("Fetching bookings for date: {}", bookingDate);
//
//        List<Booking> bookings = bookingRepo.findByBookingDate(bookingDate);
//        if (bookings.isEmpty()) {
//            throw new BookingNotFoundException("No bookings found for date: " + bookingDate);
//        }
//        return bookings;
//    }
//
//    // Method to fetch vehicle details
//    @Override
//    public VehicleDTO getVehicleDetails(int vehicleId) {
//        log.info("Fetching vehicle details for ID: {}", vehicleId);
//
//        VehicleDTO vehicle;
//        try {
//            vehicle = vehicleClient.getVehicleById(vehicleId);
//        } catch (Exception e) {
//            log.error("Vehicle service error: {}", e.getMessage());
//            throw new VehicleNotFoundException("Vehicle service unavailable. Please try again later.");
//        }
//
//        if (vehicle == null) {
//            throw new VehicleNotFoundException("Vehicle not found with ID: " + vehicleId);
//        }
//        return vehicle;
//    }
//
//    @Override
//    public UserDTO getUserById(Long userId) {
//        log.info("Fetching user details for user ID: {}", userId);
//
//        // Fetch user details using Feign Client
//        UserDTO user;
//        try {
//            user = userClient.getUserById(userId);  // Fetch user details from User Service
//        } catch (Exception e) {
//            log.error("User service error: {}", e.getMessage());
//            throw new BookingNotFoundException("User service unavailable. Please try again later.");
//        }
//
//        if (user == null) {
//            throw new BookingNotFoundException("User not found with ID: " + userId);
//        }
//
//        return user;
//    }
//
//
//    // Convert Booking entity to BookingDTO
//    public BookingDTO convertToDTO(Booking booking) {
//        BookingDTO bookingDTO = new BookingDTO();
//        bookingDTO.setUserId(booking.getUserId());
//        bookingDTO.setVehicleId(booking.getVehicleId());
//        bookingDTO.setBookingDate(booking.getBookingDate());
//        bookingDTO.setBookedTillDate(booking.getBookedTillDate());
//        bookingDTO.setBookingDescription(booking.getBookingDescription());
//        bookingDTO.setTotalCost(booking.getTotalCost());
//        bookingDTO.setDistance(booking.getDistance());
//        return bookingDTO;
//    }
//
//    // Convert BookingDTO to Booking entity
//    public Booking convertToEntity(BookingDTO bookingDTO) {
//        Booking booking = new Booking();
//        booking.setUserId(bookingDTO.getUserId());
//        booking.setVehicleId(bookingDTO.getVehicleId());
//        booking.setBookingDate(bookingDTO.getBookingDate());
//        booking.setBookedTillDate(bookingDTO.getBookedTillDate());
//        booking.setBookingDescription(bookingDTO.getBookingDescription());
//        booking.setTotalCost(bookingDTO.getTotalCost());
//        booking.setDistance(bookingDTO.getDistance());
//        return booking;
//    }
//}



//package com.capgemini.service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import com.capgemini.exception.BookingDateNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.capgemini.client.VehicleClient;
//import com.capgemini.dto.BookingDTO;
//import com.capgemini.dto.VehicleDTO;
//import com.capgemini.entity.Booking;
//import com.capgemini.exception.BookingNotFoundException;
//import com.capgemini.exception.VehicleNotFoundException;
//import com.capgemini.repository.BookingRepo;
//
//@Service
//public class BookingServiceImpl implements IBookingService {
//
//    @Autowired
//    private BookingRepo bookingRepo;  // Repository for Booking entity
//
//    @Autowired
//    private VehicleClient vehicleClient;  // Feign client for Vehicle service
//
//    @Override
//    public Booking addBooking(BookingDTO bookingDTO) {
//        // Fetch vehicle details using Feign Client
//        VehicleDTO vehicle = vehicleClient.getVehicleById(bookingDTO.getVehicleId());
//        if (vehicle == null) {
//            throw new VehicleNotFoundException("Vehicle not found with ID: " + bookingDTO.getVehicleId());
//        }
//
//        // Convert BookingDTO to Booking entity and save
//        Booking booking = convertToEntity(bookingDTO);
//        return bookingRepo.save(booking);  // Save the booking
//    }
//
//    @Override
//    public Booking updateBooking(int bookingId, BookingDTO bookingDTO) {
//        // Check if the booking exists
//        Booking existingBooking = bookingRepo.findById(bookingId)
//                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
//
//        // Fetch vehicle details using Feign Client
//        VehicleDTO vehicle = vehicleClient.getVehicleById(bookingDTO.getVehicleId());
//        if (vehicle == null) {
//            throw new VehicleNotFoundException("Vehicle not found with ID: " + bookingDTO.getVehicleId());
//        }
//
//        // Update fields of the existing booking
//        existingBooking.setUserId(bookingDTO.getUserId());
//        existingBooking.setVehicleId(bookingDTO.getVehicleId());
//        existingBooking.setBookingDate(bookingDTO.getBookingDate());
//        existingBooking.setBookedTillDate(bookingDTO.getBookedTillDate());
//        existingBooking.setBookingDescription(bookingDTO.getBookingDescription());
//        existingBooking.setTotalCost(bookingDTO.getTotalCost());
//        existingBooking.setDistance(bookingDTO.getDistance());
//
//        return bookingRepo.save(existingBooking);  // Save the updated booking
//    }
//
//    @Override
//    public void cancelBooking(int bookingId) {
//        Booking booking = bookingRepo.findById(bookingId)
//                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
//        bookingRepo.delete(booking);  // Delete the booking
//    }
//
//    @Override
//    public Booking viewBooking(int bookingId) {
//        return bookingRepo.findById(bookingId)
//                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));
//    }
//
//    @Override
//    public List<Booking> viewAllBookingsByVehicle(int vehicleId) {
//        List<Booking> bookings = bookingRepo.findByVehicleId(vehicleId);
//        if (bookings.isEmpty()) {
//            throw new VehicleNotFoundException("No bookings found for vehicle with ID: " + vehicleId);
//        }
//        return bookings;
//    }
//
//    @Override
//    public List<Booking> viewAllBookingsByDate(LocalDate bookingDate) {
//        List<Booking> bookings = bookingRepo.findByBookingDate(bookingDate);
//        if (bookings.isEmpty()) {
//            throw new BookingDateNotFoundException("No bookings found for the date: " + bookingDate);
//        }
//        return bookings;
//    }
//
//    @Override
//    public BookingDTO convertToDTO(Booking booking) {
//        BookingDTO bookingDTO = new BookingDTO();
//        bookingDTO.setBookingId(booking.getBookingId());
//        bookingDTO.setUserId(booking.getUserId());
//        bookingDTO.setVehicleId(booking.getVehicleId());
//        bookingDTO.setBookingDate(booking.getBookingDate());
//        bookingDTO.setBookedTillDate(booking.getBookedTillDate());
//        bookingDTO.setBookingDescription(booking.getBookingDescription());
//        bookingDTO.setTotalCost(booking.getTotalCost());
//        bookingDTO.setDistance(booking.getDistance());
//        return bookingDTO;
//    }
//
//    @Override
//    public Booking convertToEntity(BookingDTO bookingDTO) {
//        Booking booking = new Booking();
//        booking.setUserId(bookingDTO.getUserId());
//        booking.setVehicleId(bookingDTO.getVehicleId());
//        booking.setBookingDate(bookingDTO.getBookingDate());
//        booking.setBookedTillDate(bookingDTO.getBookedTillDate());
//        booking.setBookingDescription(bookingDTO.getBookingDescription());
//        booking.setTotalCost(bookingDTO.getTotalCost());
//        booking.setDistance(bookingDTO.getDistance());
//        return booking;
//    }
//
//    @Override
//    public VehicleDTO getVehicleById(int vehicleId) {
//        // Fetch vehicle details using the Feign Client
//        VehicleDTO vehicle = vehicleClient.getVehicleById(vehicleId);
//        if (vehicle == null) {
//            throw new VehicleNotFoundException("Vehicle not found with ID: " + vehicleId);
//        }
//
//        // Fetch all bookings for the vehicle by vehicleId
//        List<Booking> bookings = bookingRepo.findByVehicleId(vehicleId);
//        if (bookings.isEmpty()) {
//            throw new BookingNotFoundException("No bookings found for vehicle with ID: " + vehicleId);
//        }
//
//        // Convert each Booking entity to BookingDTO
//        List<BookingDTO> bookingDTOs = bookings.stream()
//                .map(booking -> convertToDTO(booking))
//                .toList();
//
//        // Set bookings in the vehicleDTO
//        vehicle.setBookings(bookingDTOs);
//
//        return vehicle;  // Return vehicle with booking details
//    }
//
//
//}



package com.capgemini.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.client.UserClient;
import com.capgemini.dto.UserDTO;
import com.capgemini.exception.BookingDateNotFoundException;
import com.capgemini.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j; // Import the Lombok annotation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.client.VehicleClient;
import com.capgemini.dto.BookingDTO;
import com.capgemini.dto.VehicleDTO;
import com.capgemini.entity.Booking;
import com.capgemini.exception.BookingNotFoundException;
import com.capgemini.exception.VehicleNotFoundException;
import com.capgemini.repository.BookingRepo;

@Slf4j  // Lombok annotation automatically creates a logger named 'log'
@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private BookingRepo bookingRepo;  // Repository for Booking entity

    @Autowired
    private VehicleClient vehicleClient;  // Feign client for Vehicle service

    @Autowired
    private UserClient userClient; //Feign client for user service

    @Override
    public Booking addBooking(BookingDTO bookingDTO) {
        log.info("Adding booking with details: {}", bookingDTO);

        // Fetch vehicle details using Feign Client
        VehicleDTO vehicle = vehicleClient.getVehicleById(bookingDTO.getVehicleId());
        if (vehicle == null) {
            log.error("Vehicle not found with ID: {}", bookingDTO.getVehicleId());
            throw new VehicleNotFoundException("Vehicle not found with ID: " + bookingDTO.getVehicleId());
        }

        // Fetch user details using Feign Client (UserClient)
        UserDTO user = userClient.getUserById((long) bookingDTO.getUserId());  // Assuming userId is an integer in BookingDTO
        if (user == null) {
            log.error("User not found with ID: {}", bookingDTO.getUserId());
            throw new UserNotFoundException("User not found with ID: " + bookingDTO.getUserId());
        }

        // Convert BookingDTO to Booking entity and save
        Booking booking = convertToEntity(bookingDTO);
        Booking savedBooking = bookingRepo.save(booking);  // Save the booking in the repository
        log.info("Booking added with ID: {}", savedBooking.getBookingId());

        return savedBooking;  // Return the saved booking
    }


    @Override
    public Booking updateBooking(int bookingId, BookingDTO bookingDTO) {
        log.info("Updating booking with ID: {}", bookingId);

        // Check if the booking exists
        Booking existingBooking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> {
                    log.error("Booking not found with ID: {}", bookingId);
                    return new BookingNotFoundException("Booking not found with ID: " + bookingId);
                });

        // Fetch vehicle details using Feign Client
        VehicleDTO vehicle = vehicleClient.getVehicleById(bookingDTO.getVehicleId());
        if (vehicle == null) {
            log.error("Vehicle not found with ID: {}", bookingDTO.getVehicleId());
            throw new VehicleNotFoundException("Vehicle not found with ID: " + bookingDTO.getVehicleId());
        }

        // Fetch user details using Feign Client (UserClient)
        UserDTO user = userClient.getUserById( bookingDTO.getUserId());  // Assuming userId is an integer in BookingDTO
        if (user == null) {
            log.error("User not found with ID: {}", bookingDTO.getUserId());
            throw new UserNotFoundException("User not found with ID: " + bookingDTO.getUserId());
        }

        // Update fields of the existing booking
        existingBooking.setUserId(bookingDTO.getUserId());
        existingBooking.setVehicleId(bookingDTO.getVehicleId());
        existingBooking.setBookingDate(bookingDTO.getBookingDate());
        existingBooking.setBookedTillDate(bookingDTO.getBookedTillDate());
        existingBooking.setBookingDescription(bookingDTO.getBookingDescription());
        existingBooking.setTotalCost(bookingDTO.getTotalCost());
        existingBooking.setDistance(bookingDTO.getDistance());
        existingBooking.setDeliveryType(bookingDTO.getDeliveryType());

        Booking updatedBooking = bookingRepo.save(existingBooking);  // Save the updated booking
        log.info("Booking updated with ID: {}", updatedBooking.getBookingId());
        return updatedBooking;
    }


    @Override
    public void cancelBooking(int bookingId) {
        log.info("Canceling booking with ID: {}", bookingId);

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> {
                    log.error("Booking not found with ID: {}", bookingId);
                    return new BookingNotFoundException("Booking not found with ID: " + bookingId);
                });

        bookingRepo.delete(booking);  // Delete the booking
        log.info("Booking with ID: {} cancelled successfully", bookingId);
    }

    @Override
    public Booking viewBooking(int bookingId) {
        log.info("Fetching booking with ID: {}", bookingId);

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> {
                    log.error("Booking not found with ID: {}", bookingId);
                    return new BookingNotFoundException("Booking not found with ID: " + bookingId);
                });

        log.info("Booking details retrieved for ID: {}", bookingId);
        return booking;
    }

    @Override
    public List<Booking> viewAllBookingsByVehicle(int vehicleId) {
        log.info("Fetching all bookings for vehicle with ID: {}", vehicleId);

        List<Booking> bookings = bookingRepo.findByVehicleId(vehicleId);
        if (bookings.isEmpty()) {
            log.error("No bookings found for vehicle with ID: {}", vehicleId);
            throw new VehicleNotFoundException("No bookings found for vehicle with ID: " + vehicleId);
        }

        log.info("Retrieved {} bookings for vehicle with ID: {}", bookings.size(), vehicleId);
        return bookings;
    }

    @Override
    public List<Booking> viewAllBookingsByDate(LocalDate bookingDate) {
        log.info("Fetching all bookings for the date: {}", bookingDate);

        List<Booking> bookings = bookingRepo.findByBookingDate(bookingDate);
        if (bookings.isEmpty()) {
            log.error("No bookings found for the date: {}", bookingDate);
            throw new BookingDateNotFoundException("No bookings found for the date: " + bookingDate);
        }

        log.info("Retrieved {} bookings for the date: {}", bookings.size(), bookingDate);
        return bookings;
    }

    @Override
    public VehicleDTO getVehicleById(int vehicleId) {
        log.info("Fetching vehicle details for vehicle ID: {}", vehicleId);

        // Fetch vehicle details using the Feign Client
        VehicleDTO vehicle = vehicleClient.getVehicleById(vehicleId);
        if (vehicle == null) {
            log.error("Vehicle not found with ID: {}", vehicleId);
            throw new VehicleNotFoundException("Vehicle not found with ID: " + vehicleId);
        }

        log.info("Successfully fetched vehicle details for vehicle ID: {}", vehicleId);

        // Fetch all bookings for the vehicle by vehicleId
        List<Booking> bookings = bookingRepo.findByVehicleId(vehicleId);
        if (bookings.isEmpty()) {
            log.warn("No bookings found for vehicle with ID: {}", vehicleId);
            throw new BookingNotFoundException("No bookings found for vehicle with ID: " + vehicleId);
        }

        log.info("Found {} bookings for vehicle with ID: {}", bookings.size(), vehicleId);

        // Convert each Booking entity to BookingDTO
        List<BookingDTO> bookingDTOs = bookings.stream()
                .map(this::convertToDTO)
                .toList();

        // Set bookings in the vehicleDTO
        vehicle.setBookings(bookingDTOs);

        log.info("Bookings added to the vehicleDTO for vehicle ID: {}", vehicleId);

        return vehicle;  // Return vehicle with booking details
    }

    // Method to fetch user details along with all bookings associated with userId
    @Override
    public UserDTO getUserById(Long userId) {
        // Fetch user details using Feign Client
        UserDTO user = userClient.getUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }

        // Fetch all bookings for the user from the database
        List<Booking> bookings = bookingRepo.findByUserId(userId);
        if (bookings.isEmpty()) {
            throw new BookingNotFoundException("No bookings found for user with ID: " + userId);
        }

        // Convert each Booking entity to BookingDTO and add to user's bookings
        List<BookingDTO> bookingDTOs = bookings.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        // Add the booking details to the userDTO
        user.setBookings(bookingDTOs);

        return user;
    }


    // Conversion method to convert BookingDTO to Booking entity
    public Booking convertToEntity(BookingDTO bookingDTO) {
        // Creating a new Booking entity object
        Booking booking = new Booking();

        // Setting properties of the Booking entity based on the BookingDTO values
        booking.setBookingId(bookingDTO.getBookingId());
        booking.setUserId(bookingDTO.getUserId());
        booking.setVehicleId(bookingDTO.getVehicleId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setBookedTillDate(bookingDTO.getBookedTillDate());
        booking.setBookingDescription(bookingDTO.getBookingDescription());
        booking.setTotalCost(bookingDTO.getTotalCost());
        booking.setDistance(bookingDTO.getDistance());
        booking.setDeliveryType(bookingDTO.getDeliveryType());

        // Returning the populated Booking entity object
        return booking;
    }


    // Convert Booking entity to BookingDTO
    public BookingDTO convertToDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setUserId(booking.getUserId());
        bookingDTO.setVehicleId(booking.getVehicleId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setBookedTillDate(booking.getBookedTillDate());
        bookingDTO.setBookingDescription(booking.getBookingDescription());
        bookingDTO.setTotalCost(booking.getTotalCost());
        bookingDTO.setDistance(booking.getDistance());
        bookingDTO.setDeliveryType(booking.getDeliveryType());
        return bookingDTO;
    }
}
//    public List<BookingDTO> convertToDTOList(List<Booking> bookings) {
//        return bookings.stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public List<Booking> convertToEntityList(List<BookingDTO> bookingDTOs) {
//        return bookingDTOs.stream()
//                .map(this::convertToEntity)
//                .collect(Collectors.toList());
//    }
