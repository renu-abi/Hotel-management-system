package org.renu.repository;

import org.renu.model.Guest;

import java.util.Map;

public interface GuestRepository {
    void addGuest(Guest guest);
    Guest findGuestById(int id);
    void updateGuest(Guest guest);
    void deleteGuest(int id);
    Map<Integer,Guest> getAllGuests();

}
