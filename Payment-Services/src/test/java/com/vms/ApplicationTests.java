//package com.vms;
//
//import org.junit.jupiter.api.Test;
//
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class ApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}
package com.vms;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import com.vms.DTO.BookingDTO;
import com.vms.DTO.PaymentDTO;
import com.vms.client.BookingFeignClient;
import com.vms.entity.Payment;
import com.vms.exception.PaymentNotFoundException;
import com.vms.repository.IPaymentRepository;
import com.vms.service.PaymentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Mock
    private IPaymentRepository paymentRepository;

    @Mock
    private BookingFeignClient bookingFeignClient;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testAddPayment_Success() {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setTransactionId("TX123456789");
        paymentDTO.setBookingId(1);
        paymentDTO.setPaymentMode("credit card");
        paymentDTO.setPaymentDate(LocalDate.now());
        paymentDTO.setTotalCost(500.0);
        paymentDTO.setVehicleId(10);

        when(paymentRepository.findByTransactionId(paymentDTO.getTransactionId())).thenReturn(Optional.empty());
        when(bookingFeignClient.getBookingById(1)).thenReturn(new BookingDTO());

        Payment payment = new Payment();
        payment.setPaymentId(1);
        payment.setTransactionId(paymentDTO.getTransactionId());
        payment.setPaymentMode(paymentDTO.getPaymentMode());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setTotalCost(paymentDTO.getTotalCost());
        payment.setVehicleId(paymentDTO.getVehicleId());

        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        PaymentDTO result = paymentService.addPayment(paymentDTO);

        assertNotNull(result);
        assertEquals(1, result.getPaymentId());
        assertEquals("TX123456789", result.getTransactionId());
    }

    @Test
    void testAddPayment_DuplicateTransaction() {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setTransactionId("TX123456789");

        when(paymentRepository.findByTransactionId(paymentDTO.getTransactionId()))
            .thenReturn(Optional.of(new Payment()));

        assertThrows(PaymentNotFoundException.class, () -> paymentService.addPayment(paymentDTO));
    }

    @Test
    void testCancelPayment_PaymentNotFound() {
        when(paymentRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(PaymentNotFoundException.class, () -> paymentService.cancelPayment(1));
    }

    @Test
    void testViewPaymentByBookingId_Success() {
        Payment payment = new Payment();
        payment.setPaymentId(1);
        payment.setBookingId(1);
        payment.setTransactionId("TX123456789");

        when(paymentRepository.viewPayment(1)).thenReturn(payment);

        PaymentDTO result = paymentService.viewPaymentByBookingId(1);

        assertNotNull(result);
        assertEquals(1, result.getPaymentId());
        assertEquals("TX123456789", result.getTransactionId());
    }

    @Test
    void testViewPaymentByBookingId_NotFound() {
        when(paymentRepository.viewPayment(1)).thenReturn(null);

        assertThrows(PaymentNotFoundException.class, () -> paymentService.viewPaymentByBookingId(1));
    }

    @Test
    void testViewAllPaymentsByVehicleId() {
        Payment payment1 = new Payment();
        payment1.setPaymentId(1);
        payment1.setVehicleId(10);

        Payment payment2 = new Payment();
        payment2.setPaymentId(2);
        payment2.setVehicleId(10);

        when(paymentRepository.viewAllPayment(10)).thenReturn(Arrays.asList(payment1, payment2));

        assertEquals(2, paymentService.viewAllPaymentsByVehicleId(10).size());
    }

    @Test
    void testCalculateMonthlyRevenue() {
        when(paymentRepository.calculateMonthlyRevenue(any(), any())).thenReturn(5000.0);

        double revenue = paymentService.calculateMonthlyRevenue(LocalDate.now().minusMonths(1), LocalDate.now());

        assertEquals(5000.0, revenue);
    }

    @Test
    void testCalculateTotalPaymentForVehicle() {
        when(paymentRepository.calculateTotalPayment(10)).thenReturn(1200.0);

        assertEquals(1200.0, paymentService.calculateTotalPaymentForVehicle(10));
    }
}
