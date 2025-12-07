// ===========================================================================================
//  2. Implement menudriven program to maintain linked list of employees and provide below operations.
//  Add employee (Perfrom any add operation)
//  Display all employees
//  Search employee by name
//  Delete employee by empid
//  Update salary of employee
//  sort employees by salary
// ===========================================================================================
class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Salary: Rs" + salary;
    }
}