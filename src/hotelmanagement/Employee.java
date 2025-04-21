package hotelmanagement;

public class Employee extends Person {
    private String employeeId;
    private String role;

    public Employee(String name, String contact, String employeeId, String role) {
        super(name, contact);
        this.employeeId = employeeId;
        this.role = role;
    }

    public void displayEmployee() {
        super.displayInfo();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Role: " + role);
    }
}
