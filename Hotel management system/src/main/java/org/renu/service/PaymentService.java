package org.renu.service;

import org.renu.model.Payment;
import org.renu.model.PaymentMethod;
import org.renu.model.PaymentStatus;
import org.renu.repository.PaymentRepository;

import java.util.Map;

public class PaymentService {
    private PaymentRepository paymentRepo;

    public PaymentService(PaymentRepository paymentRepo){
        this.paymentRepo = paymentRepo;
    }
    public void addPaymentById(Payment pay){
        paymentRepo.addPayment(pay);
    }
    public Payment getPaymentById(int id){
        return paymentRepo.findPaymentById(id);
    }
    public void updatePayment(Payment pay){
        paymentRepo.updatePayment(pay);
    }
    public void deletePayment(int id){
        paymentRepo.deletePayment(id);
    }
    public Map<Integer,Payment> getAllPayments(){
        return paymentRepo.getAllPayments();
    }
    public Map<Integer,Payment> findPaymentByStatus(PaymentStatus status){
        return paymentRepo.findPaymentByStatus(status);
    }
    public Map<Integer,Payment> findPaymentByMethod(PaymentMethod method){
        return paymentRepo.findPaymentByMethod(method);
    }

}
