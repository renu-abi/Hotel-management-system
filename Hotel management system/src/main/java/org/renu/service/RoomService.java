package org.renu.service;

import org.renu.model.Room;
import org.renu.model.RoomStatus;
import org.renu.model.RoomType;
import org.renu.repository.RoomRepository;

import java.util.Map;

public class RoomService {
    private RoomRepository roomRepo;

    public RoomService(RoomRepository roomRepo){

        this.roomRepo = roomRepo;
    }
    public void addRoom(Room room){

        roomRepo.addRoom(room);
    }
    public Room getRoomById(int id){

        return roomRepo.findRoomById(id);
    }
    public void updateRoom(Room room){

        roomRepo.updateRoom(room);
    }
    public void deleteRoom(int id){

        roomRepo.deleteRoom(id);
    }
    public Map<Integer ,Room> getAllRooms(){

        return roomRepo.getAllRooms();
    }
    public Map<Integer,Room> getRoomByStatus(RoomStatus status){

        return roomRepo.findRoomByStatus(status);
    }
    public Map<Integer ,Room> getRoomByType(RoomType type){
        return roomRepo.findRoomByType(type);
    }
}
