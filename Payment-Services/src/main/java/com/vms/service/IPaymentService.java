//package com.vms.service;
//import java.time.LocalDate;
//
//import java.util.List;
//
//import com.vms.DTO.PaymentDTO;
////interface that contains the abstract business methods 
//
//public interface IPaymentService {
//	 
//    PaymentDTO addPayment(PaymentDTO paymentDTO);
// 
//    void cancelPayment(int paymentId);
// 
//    PaymentDTO viewPaymentByBookingId(int bookingId);
// 
//    List<PaymentDTO> viewAllPaymentsByVehicleId(int vehicleId);
// 
//    double calculateMonthlyRevenue(LocalDate startDate, LocalDate endDate);
// 
//    double calculateTotalPaymentForVehicle(int vehicleId);
//}
package com.vms.service;

import java.time.LocalDate;
import java.util.List;

import com.vms.DTO.PaymentDTO;

public interface IPaymentService {

    PaymentDTO addPayment(PaymentDTO paymentDTO);

    void cancelPayment(int paymentId);

    PaymentDTO viewPaymentByBookingId(int bookingId);

    List<PaymentDTO> viewAllPaymentsByVehicleId(int vehicleId);

    PaymentDTO viewPaymentByVehicleId(int vehicleId);

    double calculateMonthlyRevenue(LocalDate startDate, LocalDate endDate);

    double calculateTotalPaymentForVehicle(int vehicleId);
}
