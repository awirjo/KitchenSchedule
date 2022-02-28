package sr.unasat.schedule.kitchen.factory;

import sr.unasat.schedule.kitchen.entities.Department;
import sr.unasat.schedule.kitchen.entities.Employees;

public class OrderFactory {
    public static Order getOrderType(OrderType orderType, Employees employees, Department department){

        switch (orderType){
            case TAKEOUT:
                return new TakeOut(employees);
            case DELIVERY:
                return new Delivery(employees, department);
        }
        return null;
    }

}
