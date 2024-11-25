package org.renu.repository;

import org.renu.model.Room;
import org.renu.model.RoomStatus;
import org.renu.model.RoomType;

import java.util.List;
import java.util.Map;

public interface RoomRepository {
    void addRoom(Room room);
    Room findRoomById(int id);
    void updateRoom(Room room);
    void deleteRoom(int id);
    Map<Integer ,Room> getAllRooms();
    Map<Integer, Room> findRoomByStatus(RoomStatus status);
    Map<Integer ,Room> findRoomByType(RoomType type);
}



