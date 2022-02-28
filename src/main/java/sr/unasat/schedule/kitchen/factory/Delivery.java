package sr.unasat.schedule.kitchen.factory;

import sr.unasat.schedule.kitchen.entities.Department;
import sr.unasat.schedule.kitchen.entities.Employees;

public class Delivery extends Order{
    private Employees employees;
    private Department department;

    public Delivery(Employees employees, Department department) {
        this.employees = employees;
        this.department = department;
    }

    @Override
    public String getOrder() {

        return "Order delivery for: " + this.employees.getLastName() + " at Department: " + this.department.getName();
    }

}
