package sr.unasat.schedule.kitchen.app;

import sr.unasat.schedule.kitchen.configuration.JPAConfig;
import sr.unasat.schedule.kitchen.service.SpecialMealDecoratorService;
import sr.unasat.schedule.kitchen.service.*;
import sr.unasat.schedule.kitchen.service.OrderFactoryService;

public class Application {
    public static void main(String[] args) {


        //Insert all tables
        InsertForAllService insertForAllService = new InsertForAllService();
//        insertForAllService.insertCrudAllTables();

        //BreakTime service
        BreakTimeService breakTimeService = new BreakTimeService();
//        breakTimeService.breakTimeRetrieve();
//        breakTimeService.breakTimeUpdate();
//        breakTimeService.breakTimeDelete();

        //Department service
        DepartmentService departmentService = new DepartmentService();
//        departmentService.departmentRetrieve();
//        departmentService.departmentInsert();
//        departmentService.departmentUpdate();
//        departmentService.departmentDelete();

        //Employees service
        EmployeesService employeesService = new EmployeesService();
//        employeesService.employeesRetrieve();
//        employeesService.employeesUpdate();
//        employeesService.employeesDelete();

        //IdentificationService service
        IdentificationService identificationService = new IdentificationService();
//        identificationService.identificationRetrieve();
//        identificationService.identificationUpdate();
//        identificationService.identificationDelete();

        //Menu service
        MenuService menuService = new MenuService();
//        menuService.menuRetrieve();
//        menuService.menuUpdate();
//        menuService.menuDelete();

//        //Factory
        OrderFactoryService orderFactoryService = new OrderFactoryService();
//        insertForAllService.insertCrudAllTables();
//        orderFactoryService.orderApplication();

//        //Decorator
        SpecialMealDecoratorService specialMealDecoratorService = new SpecialMealDecoratorService();
//        specialMealDecoratorService.specialApplication();

        //chain of responsibilities
//        menuService.menuInsertHrmMenu();
//        menuService.menuInsertMiningMenu();
        MessageChainMakerService messageChainMaker = new MessageChainMakerService();
//        messageChainMaker.messageMaker();


        JPAConfig.shutdown();

    }
}
