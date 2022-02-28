package sr.unasat.schedule.kitchen.factory;

import sr.unasat.schedule.kitchen.dao.DepartmentDAO;
import sr.unasat.schedule.kitchen.dao.EmployeesDAO;
import sr.unasat.schedule.kitchen.entities.Department;
import sr.unasat.schedule.kitchen.entities.Employees;

public class OrderApp {

    public void orderApplication(){
        EmployeesDAO employeesDAO = new EmployeesDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();

        Order takeOut = OrderFactory.getOrderType(OrderType.TAKEOUT, employeesDAO.findByLastName("Golo"), departmentDAO.findByDepartment("ICT"));
        Order delivery = OrderFactory.getOrderType(OrderType.DELIVERY,employeesDAO.findByLastName("Golo"), departmentDAO.findByDepartment("ICT"));
        System.out.println(takeOut.getOrder());
        System.out.println(delivery.getOrder());

    }
}
