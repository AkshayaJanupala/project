//
//package com.vms.repository;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.vms.entity.Payment;
//import jakarta.transaction.Transactional;
//
//@Repository
//public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
//
//    // No need for addPayment() here, as JpaRepository already provides a save() method.
//
//    // Custom query to update the payment status to 'CANCELLED' for a specific paymentId
//    @Modifying
//    @Transactional
//    @Query("UPDATE Payment p SET p.paymentStatus = 'CANCELLED' WHERE p.paymentId = :paymentId")
//    void cancelPayment(@Param("paymentId") int paymentId);
//
//    // Custom query to retrieve payment by bookingId
//    @Query("SELECT p FROM Payment p WHERE p.bookingId = :bookingId")
//    Payment viewPayment(@Param("bookingId") int bookingId);
//
//    // Custom query to retrieve all payments for a specific vehicleId
//    @Query("SELECT p FROM Payment p WHERE p.vehicleId = :vehicleId")
//    List<Payment> viewAllPayment(@Param("vehicleId") int vehicleId);
//
//    // Custom query to calculate the total revenue between two dates
//    @Query("SELECT SUM(p.totalCost) FROM Payment p WHERE p.paymentDate BETWEEN :d1 AND :d2")
//    double calculateMonthlyRevenue(@Param("d1") LocalDate d1, @Param("d2") LocalDate d2);
//
//    // Custom query to calculate the total payment for a specific vehicle
//    @Query("SELECT COALESCE(SUM(p.totalCost), 0.0) FROM Payment p WHERE p.vehicleId = :vehicleId")
//    Double calculateTotalPayment(@Param("vehicleId") int vehicleId);
//
//
//    // Find payment by transactionId
//    Optional<Payment> findByTransactionId(String transactionId);
//
//    // Find payment by bookingId
//    Optional<Payment> findByBookingId(int bookingId);
//}
package com.vms.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.entity.Payment;
import jakarta.transaction.Transactional;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Payment p SET p.paymentStatus = 'CANCELLED' WHERE p.paymentId = :paymentId")
    void cancelPayment(@Param("paymentId") int paymentId);

    @Query("SELECT p FROM Payment p WHERE p.bookingId = :bookingId")
    Payment viewPayment(@Param("bookingId") int bookingId);

    @Query("SELECT p FROM Payment p WHERE p.vehicleId = :vehicleId")
    List<Payment> viewAllPayment(@Param("vehicleId") int vehicleId);

    @Query("SELECT SUM(p.totalCost) FROM Payment p WHERE p.paymentDate BETWEEN :startDate AND :endDate")
    double calculateMonthlyRevenue(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT COALESCE(SUM(p.totalCost), 0.0) FROM Payment p WHERE p.vehicleId = :vehicleId")
    Double calculateTotalPayment(@Param("vehicleId") int vehicleId);

    @Query("SELECT p FROM Payment p WHERE p.vehicleId = :vehicleId")
    Payment viewPaymentByVehicleId(@Param("vehicleId") int vehicleId);
    Optional<Payment> findByTransactionId(String transactionId);
}
