package hotelmanagement;

public class Person {
    protected String name;
    protected String contact;

    public Person(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
    }
}
