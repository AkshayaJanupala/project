//
//package com.vms.service;
//
//import com.vms.DTO.BookingDTO;
//import com.vms.DTO.PaymentDTO;
//import com.vms.client.BookingFeignClient;
//import com.vms.entity.Payment;
//import com.vms.exception.PaymentNotFoundException;
//import com.vms.repository.IPaymentRepository;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service  // Marks this class as a Spring service component
//public class PaymentServiceImpl implements IPaymentService {
//
//    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);  // Logger instance
//
//    @Autowired
//    private IPaymentRepository paymentRepository;  // Repository for payment-related database operations
//
//    @Autowired
//    private BookingFeignClient bookingFeignClient;  // Feign client for booking service communication
//
//    /**
//     * Adds a new payment.
//     */
//    @Override
//    public PaymentDTO addPayment(PaymentDTO paymentDTO) {
//        logger.info("Adding a new payment with Transaction ID: {}", paymentDTO.getTransactionId());
//
//        // Check if transaction ID already exists
//        Optional<Payment> existingPayment = paymentRepository.findByTransactionId(paymentDTO.getTransactionId());
//        if (existingPayment.isPresent()) {
//            logger.error("Transaction ID {} already exists!", paymentDTO.getTransactionId());
//            throw new PaymentNotFoundException("Transaction ID already exists.");
//        }
//
//        // Validate if the booking exists
//        BookingDTO booking = bookingFeignClient.getBookingById(paymentDTO.getBookingId());
//        if (booking == null) {
//            logger.error("Booking not found for ID: {}", paymentDTO.getBookingId());
//            throw new PaymentNotFoundException("Booking not found for ID: " + paymentDTO.getBookingId());
//        }
//
//        // Create a new Payment entity
//        Payment payment = new Payment();
//        payment.setPaymentMode(paymentDTO.getPaymentMode());
//        payment.setPaymentDate(paymentDTO.getPaymentDate());
//        payment.setPaymentStatus("success");
//        payment.setBookingId(paymentDTO.getBookingId());
//        payment.setTotalCost(paymentDTO.getTotalCost());
//        payment.setTransactionId(paymentDTO.getTransactionId());
//        payment.setVehicleId(paymentDTO.getVehicleId());
//
//        // Save payment to the database
//        Payment savedPayment = paymentRepository.save(payment);
//        logger.info("Payment successfully saved with ID: {}", savedPayment.getPaymentId());
//
//        return convertToDTO(savedPayment);  // Convert entity to DTO and return
//    }
//
//    /**
//     * Cancels a payment by its ID.
//     */
//    @Override
//    public void cancelPayment(int paymentId) {
//        logger.info("Attempting to cancel payment with ID: {}", paymentId);
//        Optional<Payment> paymentOptional = paymentRepository.findById(paymentId);
//
//        // Check if payment exists
//        if (!paymentOptional.isPresent()) {
//            logger.error("Payment ID {} not found for cancellation!", paymentId);
//            throw new PaymentNotFoundException("Payment ID " + paymentId + " not found.");
//        }
//
//        // Cancel the payment
//        paymentRepository.cancelPayment(paymentId);
//        logger.info("Payment ID {} successfully cancelled.", paymentId);
//    }
//
//    /**
//     * Retrieves payment details using booking ID.
//     */
//    @Override
//    public PaymentDTO viewPaymentByBookingId(int bookingId) {
//        logger.info("Fetching payment details for Booking ID: {}", bookingId);
//        Payment payment = paymentRepository.viewPayment(bookingId);
//
//        // Check if payment exists for the booking
//        if (payment == null) {
//            logger.error("No payment found for Booking ID: {}", bookingId);
//            throw new PaymentNotFoundException("Payment not found for booking ID: " + bookingId);
//        }
//
//        logger.info("Payment found for Booking ID: {}", bookingId);
//        return convertToDTO(payment);  // Convert entity to DTO and return
//    }
//
//    /**
//     * Retrieves all payments for a given vehicle ID.
//     */
//    @Override
//    public List<PaymentDTO> viewAllPaymentsByVehicleId(int vehicleId) {
//        logger.info("Fetching all payments for Vehicle ID: {}", vehicleId);
//        List<Payment> payments = paymentRepository.viewAllPayment(vehicleId);
//
//        // Check if any payments exist for the vehicle
//        if (payments.isEmpty()) {
//            logger.warn("No payments found for Vehicle ID: {}", vehicleId);
//        } else {
//            logger.info("Retrieved {} payments for Vehicle ID: {}", payments.size(), vehicleId);
//        }
//
//        return payments.stream().map(this::convertToDTO).collect(Collectors.toList());  // Convert to DTO list
//    }
//
//    /**
//     * Calculates revenue within a given date range.
//     */
//    @Override
//    public double calculateMonthlyRevenue(LocalDate startDate, LocalDate endDate) {
//        logger.info("Calculating revenue between {} and {}", startDate, endDate);
//        double revenue = paymentRepository.calculateMonthlyRevenue(startDate, endDate);
//        logger.info("Calculated revenue: {}", revenue);
//        return revenue;
//    }
//
//    /**
//     * Calculates the total payment amount for a given vehicle ID.
//     */
//    @Override
//    public double calculateTotalPaymentForVehicle(int vehicleId) {
//        logger.info("Calculating total payment for Vehicle ID: {}", vehicleId);
//        Double totalPayment = paymentRepository.calculateTotalPayment(vehicleId);
//
//        // Check if any payments exist for the vehicle
//        if (totalPayment == null) {
//            logger.warn("No payments found for Vehicle ID: {}. Returning 0.0", vehicleId);
//            return 0.0;
//        }
//
//        logger.info("Total payment for Vehicle ID {}: {}", vehicleId, totalPayment);
//        return totalPayment;
//    }
//
//    /**
//     * Converts a Payment entity to a PaymentDTO.
//     */
//    private PaymentDTO convertToDTO(Payment payment) {
//        PaymentDTO paymentDTO = new PaymentDTO();
//        paymentDTO.setPaymentId(payment.getPaymentId());
//        paymentDTO.setPaymentMode(payment.getPaymentMode());
//        paymentDTO.setPaymentDate(payment.getPaymentDate());
//        paymentDTO.setPaymentStatus(payment.getPaymentStatus());
//        paymentDTO.setBookingId(payment.getBookingId());
//        paymentDTO.setTotalCost(payment.getTotalCost());
//        paymentDTO.setTransactionId(payment.getTransactionId());
//        paymentDTO.setVehicleId(payment.getVehicleId());
//        return paymentDTO;
//    }
//}
//
//
//
//
//
//
//
package com.vms.service;

import com.vms.DTO.BookingDTO;
import com.vms.DTO.PaymentDTO;
import com.vms.client.BookingFeignClient;
import com.vms.entity.Payment;
import com.vms.exception.PaymentNotFoundException;
import com.vms.repository.IPaymentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements IPaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private IPaymentRepository paymentRepository;

    @Autowired
    private BookingFeignClient bookingFeignClient;

    @Override
    public PaymentDTO addPayment(PaymentDTO paymentDTO) {
        logger.info("Adding a new payment with Transaction ID: {}", paymentDTO.getTransactionId());

        Optional<Payment> existingPayment = paymentRepository.findByTransactionId(paymentDTO.getTransactionId());
        if (existingPayment.isPresent()) {
            logger.error("Transaction ID {} already exists!", paymentDTO.getTransactionId());
            throw new PaymentNotFoundException("Transaction ID already exists.");
        }

        BookingDTO booking = bookingFeignClient.getBookingById(paymentDTO.getBookingId());
        if (booking == null) {
            logger.error("Booking not found for ID: {}", paymentDTO.getBookingId());
            throw new PaymentNotFoundException("Booking not found for ID: " + paymentDTO.getBookingId());
        }

        Payment payment = new Payment();
        payment.setPaymentMode(paymentDTO.getPaymentMode());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setPaymentStatus("success");
        payment.setBookingId(paymentDTO.getBookingId());
        payment.setTotalCost(paymentDTO.getTotalCost());
        payment.setTransactionId(paymentDTO.getTransactionId());
        payment.setVehicleId(paymentDTO.getVehicleId());

        Payment savedPayment = paymentRepository.save(payment);
        logger.info("Payment successfully saved with ID: {}", savedPayment.getPaymentId());

        return convertToDTO(savedPayment);
    }

    @Override
    public void cancelPayment(int paymentId) {
        logger.info("Attempting to cancel payment with ID: {}", paymentId);
        Optional<Payment> paymentOptional = paymentRepository.findById(paymentId);

        if (!paymentOptional.isPresent()) {
            logger.error("Payment ID {} not found for cancellation!", paymentId);
            throw new PaymentNotFoundException("Payment ID " + paymentId + " not found.");
        }

        paymentRepository.cancelPayment(paymentId);
        logger.info("Payment ID {} successfully cancelled.", paymentId);
    }

    @Override
    public PaymentDTO viewPaymentByBookingId(int bookingId) {
        logger.info("Fetching payment details for Booking ID: {}", bookingId);
        Payment payment = paymentRepository.viewPayment(bookingId);

        if (payment == null) {
            logger.error("No payment found for Booking ID: {}", bookingId);
            throw new PaymentNotFoundException("Payment not found for booking ID: " + bookingId);
        }

        return convertToDTO(payment);
    }

    @Override
    public List<PaymentDTO> viewAllPaymentsByVehicleId(int vehicleId) {
        logger.info("Fetching all payments for Vehicle ID: {}", vehicleId);
        List<Payment> payments = paymentRepository.viewAllPayment(vehicleId);

        if (payments.isEmpty()) {
            logger.warn("No payments found for Vehicle ID: {}", vehicleId);
        } else {
            logger.info("Retrieved {} payments for Vehicle ID: {}", payments.size(), vehicleId);
        }

        return payments.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public PaymentDTO viewPaymentByVehicleId(int vehicleId) {
        logger.info("Fetching payment details for Vehicle ID: {}", vehicleId);
        Payment payment = paymentRepository.viewPaymentByVehicleId(vehicleId);

        if (payment == null) {
            logger.error("No payment found for Vehicle ID: {}", vehicleId);
            throw new PaymentNotFoundException("No payment found for vehicle ID: " + vehicleId);
        }

        return convertToDTO(payment);
    }

    @Override
    public double calculateMonthlyRevenue(LocalDate startDate, LocalDate endDate) {
        logger.info("Calculating revenue between {} and {}", startDate, endDate);
        double revenue = paymentRepository.calculateMonthlyRevenue(startDate, endDate);
        return revenue;
    }

    @Override
    public double calculateTotalPaymentForVehicle(int vehicleId) {
        logger.info("Calculating total payment for Vehicle ID: {}", vehicleId);
        Double totalPayment = paymentRepository.calculateTotalPayment(vehicleId);

        if (totalPayment == null) {
            return 0.0;
        }

        return totalPayment;
    }

    private PaymentDTO convertToDTO(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(payment.getPaymentId());
        paymentDTO.setPaymentMode(payment.getPaymentMode());
        paymentDTO.setPaymentDate(payment.getPaymentDate());
        paymentDTO.setPaymentStatus(payment.getPaymentStatus());
        paymentDTO.setBookingId(payment.getBookingId());
        paymentDTO.setTotalCost(payment.getTotalCost());
        paymentDTO.setTransactionId(payment.getTransactionId());
        paymentDTO.setVehicleId(payment.getVehicleId());
        return paymentDTO;
    }
}
