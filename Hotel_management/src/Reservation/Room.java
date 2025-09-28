package Reservation;

public class Room {
	private int roomNumber;
	private boolean isBooked;
	
	public Room(int roomNumber) {
		this.roomNumber=roomNumber;
		this.isBooked=false;
	}

	public int getRoomNumber() {
		return roomNumber;
	}


	public boolean isBooked() {
		return isBooked;
	}
	
	public void bookRoom() {
		isBooked = true;
	}
	
	public void cancelBooking() {
		isBooked = false;
	}


}
