package org.renu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import org.renu.model.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Initialize repositories using HashMap
        Map<Integer, Room> rMap = new HashMap<>();
        Map<Integer, Reservation> resMap = new HashMap<>();
        Map<Integer, Payment> payMap = new HashMap<>();
        Map<Integer, Guest> gMap = new HashMap<>();

        // Adding some rooms to the HashMap
        rMap.put(1, new Room(1, RoomType.SINGLE, 100.0, RoomStatus.AVAILABLE));
        rMap.put(2, new Room(2, RoomType.DOUBLE, 200.0, RoomStatus.AVAILABLE));
        rMap.put(3, new Room(3, RoomType.DELUXE, 300.0, RoomStatus.AVAILABLE));
        rMap.put(4, new Room(4, RoomType.SUITE, 500.0, RoomStatus.AVAILABLE));

        // Adding guests to the HashMap
        Guest guest1 = new Guest(1, "Alice Johnson", "123 Elm Street","555-1223");
        Guest guest2 = new Guest(2, "Bob Smith", "456 Oak Avenue","555-5678");
        gMap.put(guest1.getId(), guest1);
        gMap.put(guest2.getId(), guest2);

        // 1. Hotel staff checks available rooms
        System.out.println("Available rooms before booking:");
        rMap.forEach((id, room) -> {
            if (room.getStatus() == RoomStatus.AVAILABLE) {
                System.out.println(room);
            }
        });

        // 2. Guest 1 books a room
        Room selectedRoom1 = rMap.get(1); // Single room
        if (selectedRoom1 != null && selectedRoom1.getStatus() == RoomStatus.AVAILABLE) {
            Reservation reservation1 = new Reservation(1,guest1,selectedRoom1,new Date(),new Date(),ReservationStatus.BOOKED);
            resMap.put(reservation1.getId(), reservation1);
            rMap.put(selectedRoom1.getId(), new Room(selectedRoom1.getId(), selectedRoom1.getType(), selectedRoom1.getPrice(), RoomStatus.OCCUPIED));
            System.out.println("Reservation made for guest: " + guest1.getName());
            System.out.println(reservation1);
        }

        // 3. Guest 2 books a deluxe room
        Room selectedRoom2 = rMap.get(3); // Deluxe room
        if (selectedRoom2 != null && selectedRoom2.getStatus() == RoomStatus.AVAILABLE) {
            Reservation reservation2 = new Reservation(2,guest2, selectedRoom2,new Date(), new Date(),ReservationStatus.BOOKED);
            resMap.put(reservation2.getId(), reservation2);
            rMap.put(selectedRoom2.getId(), new Room(selectedRoom2.getId(), selectedRoom2.getType(), selectedRoom2.getPrice(), RoomStatus.OCCUPIED));
            System.out.println("Reservation made for guest: " + guest2.getName());
            System.out.println(reservation2);
        }

        // 4. Guest 1 checks in
        Reservation reservation1CheckIn = resMap.get(1);
        if (reservation1CheckIn != null) {
            reservation1CheckIn.setStatus(ReservationStatus.CHECKED_IN);
            System.out.println("Guest checked in: " + reservation1CheckIn);
        }

        // 5. Guest 2 checks in
        Reservation reservation2CheckIn = resMap.get(2);
        if (reservation2CheckIn != null) {
            reservation2CheckIn.setStatus(ReservationStatus.CHECKED_IN);
            System.out.println("Guest checked in: " + reservation2CheckIn);
        }

        // 6. Process payment for Guest 1 (credit card)
        Payment payment1 = new Payment(1,PaymentMethod.CREDIT_CARD,PaymentStatus.CONFIRMED,300.0,new Date()) ;
        payMap.put(payment1.getPaymentId(), payment1);
        System.out.println("Payment processed for Guest 1: " + payment1);

        // 7. Process payment for Guest 2 (online payment)
        Payment payment2 = new Payment(2, PaymentMethod.ONLINE, PaymentStatus.CONFIRMED, 300.0,new Date());
        payMap.put(payment2.getPaymentId(), payment2);
        System.out.println("Payment processed for Guest 2: " + payment2);

        // 8. Guest 1 checks out
        reservation1CheckIn.setStatus(ReservationStatus.CHECKED_OUT);
        rMap.put(selectedRoom1.getId(), new Room(selectedRoom1.getId(), selectedRoom1.getType(), selectedRoom1.getPrice(), RoomStatus.AVAILABLE));
        System.out.println("Guest 1 checked out: " + reservation1CheckIn);

        // 9. Guest 2 checks out
        reservation2CheckIn.setStatus(ReservationStatus.CHECKED_OUT);
        rMap.put(selectedRoom2.getId(), new Room(selectedRoom2.getId(), selectedRoom2.getType(), selectedRoom2.getPrice(), RoomStatus.AVAILABLE));
        System.out.println("Guest 2 checked out: " + reservation2CheckIn);

        // 10. Available rooms after guests check out
        System.out.println("Available rooms after check-out:");
        rMap.forEach((id, room) -> {
            if (room.getStatus() == RoomStatus.AVAILABLE) {
                System.out.println(room);
            }
        });
    }
}

