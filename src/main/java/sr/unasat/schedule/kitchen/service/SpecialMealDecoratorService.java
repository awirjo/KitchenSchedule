package sr.unasat.schedule.kitchen.service;

import sr.unasat.schedule.kitchen.dao.MenuDAO;
import sr.unasat.schedule.kitchen.decorator.BirthdayMeal;
import sr.unasat.schedule.kitchen.decorator.BirthdayParty;
import sr.unasat.schedule.kitchen.decorator.DinnerForClosedGroup;
import sr.unasat.schedule.kitchen.decorator.SpecialMeal;

public class SpecialMealDecoratorService {

    public void specialApplication(){
        MenuDAO menuDAO = new MenuDAO();
        menuDAO.findByMealOfDay("Steak with oyster sauce");
        menuDAO.findByDinnerGroup("Bami");

        SpecialMeal birthday = new BirthdayMeal();

        SpecialMeal dinnerForClosedGroup = new DinnerForClosedGroup();

        SpecialMeal birthdayParty = new BirthdayParty(new BirthdayMeal());

        System.out.println("Employees will get a special meal on their Birthday");
        birthday.getMeal(menuDAO.findByMealOfDay("Steak with oyster sauce"));

        System.out.println("\n Dinner for a closed group of employees");
        dinnerForClosedGroup.getMeal(menuDAO.findByDinnerGroup("Bami"));

        System.out.println("\n ");
        birthdayParty.getMeal(menuDAO.findByMealOfDay("Steak with oyster sauce"));
//        birthdayParty.getMeal();
    }



}
