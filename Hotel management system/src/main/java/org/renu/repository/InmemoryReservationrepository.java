package org.renu.repository;

import org.renu.model.Reservation;
import org.renu.model.ReservationStatus;
import org.renu.model.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InmemoryReservationrepository implements ReservationRepository {
    private Map<Integer, Reservation> resMap = new HashMap<>();

    @Override
    public void addReservation(Reservation res) {
        resMap.put(res.getId(),res);
    }

    @Override
    public Reservation findReservationById(int id) {
        return resMap.get(id);
    }

    @Override
    public void updateReservation(Reservation res) {
        resMap.put(res.getId(),res);
    }

    @Override
    public void deleteReservation(int id) {
        resMap.remove(id);
    }

    @Override
    public Map<Integer, Reservation> getAllReservations() {
        return new HashMap<>(resMap);
    }

    @Override
    public Map<Integer, Reservation> findReservationByStatus(ReservationStatus status) {
        return resMap.entrySet().stream()
                .filter(entry-> entry.getValue().getStatus() == status)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    @Override
    public boolean isRoomAvailable(Room room) {
        for (Reservation res : resMap.values()){
            if(res.getRoom().equals(room) && res.getStatus() != ReservationStatus.CANCELLED){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isRoomBooked(Room room) {
        for (Reservation res :resMap.values()){
            if(res.getRoom().equals(room) && res.getStatus() == ReservationStatus.CONFIRMED){
                return true;
            }
        }
        return false;
    }
}
