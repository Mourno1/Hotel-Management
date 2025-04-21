package hotelmanagement;

import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n--- Hotel Management Menu ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Show All Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // flush newline

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter contact: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter customer ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter address: ");
                    String address = sc.nextLine();

                    Customer customer = new Customer(name, contact, id, address);

                    System.out.print("Enter room number: ");
                    int roomNo = sc.nextInt();
                    System.out.print("Enter number of days: ");
                    int days = sc.nextInt();
                    hotel.bookRoom(customer, roomNo, days);
                    break;
                case 3:
                    hotel.showBookings();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
