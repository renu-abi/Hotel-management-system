package org.renu.repository;

import org.renu.model.Room;
import org.renu.model.RoomStatus;
import org.renu.model.RoomType;

import java.util.HashMap;
import java.util.Map;

public class InmemoryRoomRepository implements RoomRepository {
    private Map<Integer, Room> rMap = new HashMap<>();

    @Override
    public void addRoom(Room room) {
        rMap.put(room.getId(), room);
    }

    @Override
    public Room findRoomById(int id) {

        return rMap.get(id);
    }

    @Override
    public void updateRoom(Room room) {
        rMap.put(room.getId(), room);
    }

    @Override
    public void deleteRoom(int id) {
        rMap.remove(id);
    }

    @Override
    public Map<Integer, Room> getAllRooms() {
        return new HashMap<>(rMap);
    }

    @Override
    public Map<Integer, Room> findRoomByStatus(RoomStatus status) {
        Map<Integer, Room> result = new HashMap<>();
        for (Map.Entry<Integer, Room> entry : rMap.entrySet()) {
            if (entry.getValue().getStatus() == status) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<Integer, Room> findRoomByType(RoomType type) {
        Map<Integer, Room> result = new HashMap<>();
        for (Map.Entry<Integer, Room> entry : rMap.entrySet()) {
            if (entry.getValue().getType() == type) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
