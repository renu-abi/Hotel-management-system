package org.renu.model;

import org.renu.repository.InmemoryPaymentrepository;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private final Integer id;
    private final Guest guest;
    private final Room room;
    private final Date checkInDays;
    private final Date checkOutDays;
    private ReservationStatus status;

    public Reservation(Integer id, Guest guest, Room room, Date checkInDays, Date checkOutDays, ReservationStatus status) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkInDays = checkInDays;
        this.checkOutDays = checkOutDays;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public ReservationStatus getStatus() {
        return status;
    }
    public void setStatus(ReservationStatus status) {

        this.status = status;
    }
    public Date getCheckInDays() {

        return checkInDays;
    }

    public Date getCheckOutDays() {
        return checkOutDays;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", guest=" + guest +
                ", room=" + room +
                ", checkInDays=" + checkInDays +
                ", checkOutDays=" + checkOutDays +
                ", status=" + status +
                '}';
    }

    }



