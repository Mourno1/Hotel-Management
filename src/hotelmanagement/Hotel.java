package hotelmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

public class Hotel implements Bookable {
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public Hotel() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        rooms.add(new Room(101, "AC", 2000));
        rooms.add(new Room(102, "Non-AC", 1000));
        rooms.add(new Room(103, "AC", 2500));
    }

    public void showAvailableRooms() {
        for (Room r : rooms) {
            if (!r.isBooked()) {
                r.displayRoom();
            }
        }
    }

    @Override
    public void bookRoom() {
        System.out.println("Booking room via interface method.");
    }

    public void bookRoom(Customer customer, int roomNo, int duration) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNo) {
                try {
                    room.book();
                    Booking booking = new Booking(customer, room, duration);
                    bookings.add(booking);
                    System.out.println("Room booked successfully!");
                    booking.displayBooking();

                    // Save booking and customer to database
                    try {
                        Connection con = DatabaseConnection.getConnection();

                        // Insert customer
                        PreparedStatement ps1 = con.prepareStatement(
                            "INSERT IGNORE INTO customers (customer_id, name, contact, address) VALUES (?, ?, ?, ?)"
                        );
                        ps1.setString(1, customer.getCustomerId());
                        ps1.setString(2, customer.name);    // assuming name is public
                        ps1.setString(3, customer.contact); // assuming contact is public
                        ps1.setString(4, customer.address); // assuming address is public
                        ps1.executeUpdate();

                        // Insert booking
                        PreparedStatement ps2 = con.prepareStatement(
                            "INSERT INTO bookings (customer_id, room_number, booking_date, duration, total_cost) VALUES (?, ?, ?, ?, ?)"
                        );
                        ps2.setString(1, customer.getCustomerId());
                        ps2.setInt(2, room.getRoomNumber());
                        ps2.setDate(3, Date.valueOf(booking.bookingDate)); // use java.sql.Date
                        ps2.setInt(4, duration);
                        ps2.setDouble(5, booking.totalCost);
                        ps2.executeUpdate();

                        // Update room booking status in DB
                        PreparedStatement ps3 = con.prepareStatement(
                            "UPDATE rooms SET is_booked = TRUE WHERE room_number = ?"
                        );
                        ps3.setInt(1, room.getRoomNumber());
                        ps3.executeUpdate();

                        con.close();
                        System.out.println("Booking saved to database.");
                    } catch (SQLException e) {
                        System.out.println("Database error:");
                        e.printStackTrace();
                    }

                    return;
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    return;
                }
            }
        }
        System.out.println("Room not found!");
    }

    public void showBookings() {
        for (Booking b : bookings) {
            b.displayBooking();
        }
    }
}
