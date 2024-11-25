package org.renu.repository;

import org.renu.model.Payment;
import org.renu.model.PaymentMethod;
import org.renu.model.PaymentStatus;

import java.util.Map;

public interface PaymentRepository {
    void addPayment(Payment pay);
    void updatePayment(Payment pay);
    void deletePayment(int id);
    Payment findPaymentById(int id);
    Map<Integer,Payment> getAllPayments();
    Map<Integer,Payment> findPaymentByStatus(PaymentStatus status);
    Map<Integer,Payment> findPaymentByMethod(PaymentMethod method);
}
