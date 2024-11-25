package org.renu.model;

public class Room {
    private int id;
    private RoomType type;
    private double price;
    private RoomStatus status;

    public Room(int id,RoomType type,double price,RoomStatus status){
        this.id = id;
        this.status = RoomStatus.AVAILABLE;
        this.type = RoomType.SINGLE;
        this.price = price;
    }

    public int getId() {

        return id;
    }

    public RoomType getType() {

        return type;
    }

    public RoomStatus getStatus() {

        return status;
    }

    public double getPrice() {

        return price;
    }
    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", price=" + price +
                '}';
    }


}

