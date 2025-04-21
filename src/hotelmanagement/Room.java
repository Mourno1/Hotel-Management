package hotelmanagement;

public class Room {
    private int roomNumber;
    private String type;
    private boolean isBooked;
    private double price;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false;
    }

    public void book() throws Exception {
        if (isBooked) {
            throw new Exception("Room already booked!");
        }
        this.isBooked = true;
    }

    public void release() {
        this.isBooked = false;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void displayRoom() {
        System.out.println("Room No: " + roomNumber + ", Type: " + type + ", Price: " + price + ", Booked: " + isBooked);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPrice() {
        return price;
    }
}
