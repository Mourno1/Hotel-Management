package hotelmanagement;

public class Customer extends Person {
    private String customerId;
    String address;

    public Customer(String name, String contact, String customerId, String address) {
        super(name, contact);
        this.customerId = customerId;
        this.address = address;
    }

    public void displayCustomer() {
        super.displayInfo();
        System.out.println("Customer ID: " + customerId);
        System.out.println("Address: " + address);
    }

    public String getCustomerId() {
        return this.customerId;
    }
    public String getName(){
        return this.name;
    }
    public String getContact(){
        return this.contact;
    }
    public String getAddress(){
        return this.address;
    }
}
