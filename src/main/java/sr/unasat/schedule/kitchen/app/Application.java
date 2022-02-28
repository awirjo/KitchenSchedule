package sr.unasat.schedule.kitchen.app;

import sr.unasat.schedule.kitchen.chainOfResp.MessageChainMaker;
import sr.unasat.schedule.kitchen.composite.MenuApp;
import sr.unasat.schedule.kitchen.configuration.JPAConfig;
import sr.unasat.schedule.kitchen.crud.*;
import sr.unasat.schedule.kitchen.decorator.SpecialMealApp;
import sr.unasat.schedule.kitchen.entities.Department;
import sr.unasat.schedule.kitchen.factory.OrderApp;

public class Application {
    public static void main(String[] args) {


        //Insert all tables
        InsertForAllCrud insertForAllCrud = new InsertForAllCrud();
//        insertForAllCrud.insertCrudAllTables();

        //BreakTime crud
        BreakTimeCrud breakTimeCrud = new BreakTimeCrud();
//        breakTimeCrud.breakTimeRetrieve();
//        breakTimeCrud.breakTimeUpdate();
//        breakTimeCrud.breakTimeDelete();

        //Department crud
        DepartmentCrud departmentCrud = new DepartmentCrud();
//        departmentCrud.departmentRetrieve();
//        departmentCrud.departmentInsert();
//        departmentCrud.departmentUpdate();
//        departmentCrud.departmentDelete();

        //Employees crud
        EmployeesCrud employeesCrud = new EmployeesCrud();
//        employeesCrud.employeesRetrieve();
//        employeesCrud.employeesUpdate();
//        employeesCrud.employeesDelete();

        //IdentificationCrud crud
        IdentificationCrud identificationCrud = new IdentificationCrud();
//        identificationCrud.identificationRetrieve();
//        identificationCrud.identificationUpdate();
//        identificationCrud.identificationDelete();

        //Menu crud
        MenuCrud menuCrud = new MenuCrud();
//        menuCrud.menuRetrieve();
//        menuCrud.menuUpdate();
//        menuCrud.menuDelete();

//        //Factory
        OrderApp orderApp = new OrderApp();
//        insertForAllCrud.insertCrudAllTables();
//        orderApp.orderApplication();

//        //Decorator
        SpecialMealApp specialMealApp = new SpecialMealApp();
//        specialMealApp.specialApplication();

        //chain of responsibilities
//        menuCrud.menuInsertHrmMenu();
//        menuCrud.menuInsertMiningMenu();
        MessageChainMaker messageChainMaker = new MessageChainMaker();
//        messageChainMaker.messageMaker();


        JPAConfig.shutdown();

    }
}
