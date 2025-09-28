package Reservation;

public class Booking {
	private String customerName;
	private int roomNumber;
	private int days;
	
	public Booking(String customerName, int roomNumber, int days) {
	
		this.customerName = customerName;
		this.roomNumber = roomNumber;
		this.days = days;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public int getDays() {
		return days;
	}
	
	public String toString() {
		return "Customer: "+ customerName+", Room: "+roomNumber+", Days"+days;
	}
	

}
