package hotelmanagement;

import java.time.LocalDate;

public class Booking {
    private Customer customer;
    private Room room;
    LocalDate bookingDate;
    private int duration;
    double totalCost;

    public Booking(Customer customer, Room room, int duration) {
        this.customer = customer;
        this.room = room;
        this.bookingDate = LocalDate.now();
        this.duration = duration;
        this.totalCost = duration * room.getPrice();
    }

    public void displayBooking() {
        System.out.println("Booking Details:");
        customer.displayCustomer();
        room.displayRoom();
        System.out.println("Booking Date: " + bookingDate);
        System.out.println("Duration: " + duration + " day(s)");
        System.out.println("Total Cost: ₹" + totalCost);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }
}
