package sr.unasat.schedule.kitchen.crud;

import sr.unasat.schedule.kitchen.dao.EmployeesDAO;
import sr.unasat.schedule.kitchen.entities.Employees;

import java.util.List;

public class EmployeesCrud {

    EmployeesDAO employeesDAO = new EmployeesDAO();

    public void employeesDelete(){
        System.out.println("Total employees deleted: " + employeesDAO.deleteEmployees("Bronto"));
    }
    public void employeesUpdate(){
        Employees findEmployees = employeesDAO.findByLastName("Golo");
        findEmployees.setLastName("Somo");
        findEmployees.setFirstName("Bronto");
        employeesDAO.updateEmployees(findEmployees);
        System.out.println("Updated record employee: "+ findEmployees);
    }
    public void employeesRetrieve(){
        List<Employees> employeesList = employeesDAO.retrieveEmployeesList();
//        employeesList.stream().forEach(System.out::println);
        System.out.println("Retrieved employee record: " + employeesList);
    }
}
