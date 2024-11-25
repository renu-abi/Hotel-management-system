package org.renu.service;

import org.renu.model.Guest;
import org.renu.repository.GuestRepository;

import java.util.Map;

public class GuestService {
    private GuestRepository guestRepo;

    public GuestService(GuestRepository guestRepo){
        this.guestRepo = guestRepo;
    }
    public void addGuest(Guest guest){
        guestRepo.addGuest(guest);
    }
    public Guest getGuestById(int id){
        return guestRepo.findGuestById(id);
    }
    public void updateGuest(Guest guest){
        guestRepo.updateGuest(guest);
    }
    public void deleteGuest(int id){
        guestRepo.deleteGuest(id);
    }
    public Map<Integer,Guest> getAllGuests(){
        return guestRepo.getAllGuests();
    }

}
