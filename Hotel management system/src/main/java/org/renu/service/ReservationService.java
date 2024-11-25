package org.renu.service;

import org.renu.model.Reservation;
import org.renu.model.ReservationStatus;
import org.renu.model.Room;
import org.renu.repository.ReservationRepository;

import java.util.Map;

public class ReservationService {
    private ReservationRepository reservationRepo;

    public ReservationService(ReservationRepository reservationRepo){
        this.reservationRepo = reservationRepo;
    }
    public void addReservation(Reservation res){
        reservationRepo.addReservation(res);
    }
    public Reservation getReservationById(int id){
        return reservationRepo.findReservationById(id);
    }
    public void updateReservation(Reservation res){
        reservationRepo.updateReservation(res);
    }
    public void deleteReservation(int id){
        reservationRepo.deleteReservation(id);
    }
    public Map<Integer,Reservation> getAllReservations(){
        return reservationRepo.getAllReservations();
    }
    public Map<Integer,Reservation> findReservationByStatus(ReservationStatus status){
        return reservationRepo.findReservationByStatus(status);
    }
    public boolean isRoomAvailable(Room room){
        return reservationRepo.isRoomAvailable(room);
    }
    public boolean isRoomBooked(Room room){
        return reservationRepo.isRoomBooked(room);
    }
}
