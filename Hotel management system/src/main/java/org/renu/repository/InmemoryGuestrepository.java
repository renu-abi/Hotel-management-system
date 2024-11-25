package org.renu.repository;

import org.renu.model.Guest;

import java.util.HashMap;
import java.util.Map;

public class InmemoryGuestrepository implements GuestRepository{
    private Map<Integer, Guest> gMap = new HashMap<>();

    @Override
    public void addGuest(Guest guest) {
        gMap.put(guest.getId() ,guest);
    }

    @Override
    public Guest findGuestById(int id) {
        return gMap.get(id);
    }

    @Override
    public void updateGuest(Guest guest) {
        gMap.put(guest.getId(),guest);
    }

    @Override
    public void deleteGuest(int id) {
        gMap.remove(id);
    }

    @Override
    public Map<Integer, Guest> getAllGuests() {
        return new HashMap<>(gMap);
    }
}
