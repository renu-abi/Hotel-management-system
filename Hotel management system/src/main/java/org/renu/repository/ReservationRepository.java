package org.renu.repository;

import org.renu.model.Reservation;
import org.renu.model.ReservationStatus;
import org.renu.model.Room;

import java.util.Map;

public interface ReservationRepository {
    void addReservation(Reservation res);
    Reservation findReservationById(int id);
    void updateReservation(Reservation res);
    void deleteReservation(int id);
    Map<Integer,Reservation> getAllReservations();
    Map<Integer,Reservation> findReservationByStatus(ReservationStatus status);
    boolean isRoomAvailable(Room room);
    boolean isRoomBooked(Room room);
}
