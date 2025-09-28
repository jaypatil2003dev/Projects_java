package Reservation;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private List<Room> rooms;
	private List<Booking> bookings;
	
	public Hotel(int totalRooms) {
		rooms= new ArrayList<>();
		bookings = new ArrayList<>();
		for(int i=1; i<=totalRooms;i++) {
			rooms.add(new Room(i));
		}
	}
	
	public void viewAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println("Room Number: " + room.getRoomNumber());
            }
        }
    }

    public boolean bookRoom(String customerName, int roomNumber, int days) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isBooked()) {
                room.bookRoom();
                bookings.add(new Booking(customerName, roomNumber, days));
                System.out.println("Room " + roomNumber + " booked successfully for " + customerName);
                return true;
            }
        }
        System.out.println("Room " + roomNumber + " is not available.");
        return false;
    }

    public boolean cancelBooking(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isBooked()) {
                room.cancelBooking();
                bookings.removeIf(b -> b.getRoomNumber() == roomNumber);
                System.out.println("Booking for room " + roomNumber + " cancelled successfully.");
                return true;
            }
        }
        System.out.println("No booking found for room " + roomNumber);
        return false;
    }

    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }
        System.out.println("All Bookings:");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
	
	

}
