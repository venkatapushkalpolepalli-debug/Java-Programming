public class Employee2 {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee("Divya", 50000);
        Employee emp2 = new Employee("Arjun", 40000);
        Employee emp3 = new Employee("Priya", 45000);

        Employee.printCompanyInfo();
    }
}
