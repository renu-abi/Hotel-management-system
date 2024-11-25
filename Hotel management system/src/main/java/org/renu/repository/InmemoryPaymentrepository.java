package org.renu.repository;

import org.renu.model.Payment;
import org.renu.model.PaymentMethod;
import org.renu.model.PaymentStatus;

import java.util.HashMap;
import java.util.Map;

public class InmemoryPaymentrepository implements PaymentRepository {
    private Map<Integer, Payment> payMap = new HashMap<>();

    @Override
    public void addPayment(Payment pay) {
        payMap.put(pay.getPaymentId(), pay);
    }

    @Override
    public Payment findPaymentById(int id) {
        return payMap.get(id);
    }

    @Override
    public void updatePayment(Payment pay) {
        payMap.put(pay.getPaymentId(), pay);
    }

    @Override
    public void deletePayment(int id) {
        payMap.remove(id);
    }

    @Override
    public Map<Integer, Payment> findPaymentByMethod(PaymentMethod method) {
        Map<Integer, Payment> result = new HashMap<>();
        for (Map.Entry<Integer, Payment> entry : payMap.entrySet()) {
            if (entry.getValue().getMethod() == method) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Payment> findPaymentByStatus(PaymentStatus status) {
        Map<Integer,Payment> result = new HashMap<>();
        for(Map.Entry<Integer,Payment> entry :payMap.entrySet()){
            if(entry.getValue().getStatus() == status){
                result.put(entry.getKey(),entry.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Payment> getAllPayments() {
        return new HashMap<>(payMap);
    }
}
