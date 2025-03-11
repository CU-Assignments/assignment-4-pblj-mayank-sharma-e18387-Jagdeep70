import java.util.*;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter ID, Name, Salary:");
                int id = sc.nextInt();
                String name = sc.next();
                double salary = sc.nextDouble();
                employees.add(new Employee(id, name, salary));
            } else if (choice == 2) {
                System.out.println("Enter ID to update:");
                int id = sc.nextInt();
                for (Employee e : employees) {
                    if (e.getId() == id) {
                        System.out.println("Enter new Name and Salary:");
                        e.setName(sc.next());
                        e.setSalary(sc.nextDouble());
                    }
                }
            } else if (choice == 3) {
                System.out.println("Enter ID to remove:");
                int id = sc.nextInt();
                employees.removeIf(e -> e.getId() == id);
            } else if (choice == 4) {
                System.out.println("Enter ID to search:");
                int id = sc.nextInt();
                for (Employee e : employees) {
                    if (e.getId() == id) {
                        System.out.println(e);
                    }
                }
            } else {
                break;
            }
        }
        sc.close();
    }
}
