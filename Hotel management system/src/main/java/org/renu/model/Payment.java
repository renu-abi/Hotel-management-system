package org.renu.model;

import java.util.Date;

public class Payment {
    private int paymentId;
    private PaymentMethod method;
    private PaymentStatus status;
    private double amount;
    private Date paymentDate;

    public Payment(int paymentId,PaymentMethod method,PaymentStatus status,double amount,Date paymentDate){
        this.paymentId = paymentId;
        this.method = method;
        this.status = status;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public PaymentStatus getStatus() {
        return status;
    }
    public void setStatus(PaymentStatus status) {
        this.status = status;
    }


    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + paymentId +
                ", amount=" + amount +
                ", method=" + method +
                ", status=" + status +
                ", paymentDate=" + paymentDate +
                '}';
    }
}

