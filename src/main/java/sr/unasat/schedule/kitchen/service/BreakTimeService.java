package sr.unasat.schedule.kitchen.service;


import sr.unasat.schedule.kitchen.dao.BreakTimeDAO;
import sr.unasat.schedule.kitchen.dao.MenuDAO;
import sr.unasat.schedule.kitchen.entities.BreakTime;
import sr.unasat.schedule.kitchen.entities.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BreakTimeService {

    BreakTimeDAO breakTimeDAO = new BreakTimeDAO();
    MenuDAO menuDAO = new MenuDAO();
    Menu menu = new Menu();
    BreakTime breakTime = new BreakTime();

    public void breakTimeUpdate(){
        BreakTime findBreakTime = breakTimeDAO.findByServingTime("8am");
        Menu menuUpdate = Menu.builder().breakfast("Brood ei").lunch("Bami").dinner("Mac&Cheese").description("Menu of the day").special_meals("Cake").build();
        menuDAO.insertMenu(menuUpdate);
        findBreakTime.setMenu(menuUpdate);
        breakTimeDAO.updateBreakTime(findBreakTime);
        System.out.println("The following records are updated: " + findBreakTime.getMenu());
    }

    public void breakTimeRetrieve(){
        List<BreakTime> breakTimeSelect = breakTimeDAO.retrieveBreakTimeList();
//        breakTimeSelect.stream().forEach(System.out::println);
        System.out.println("Retrieved record Break Time: " + "\n" + breakTimeSelect);
    }

    public void breakTimeDelete(){
        BreakTime deletedBreakTime = breakTimeDAO.findByServingTime("8am");
        breakTimeDAO.deleteBreakTimeMeal("From 8am till 7pm");
        System.out.println("The following records are deleted: " + deletedBreakTime);
    }
    public void breakTimeRapportByQuarter(){
        List<BreakTime> breakTimeSelectRapport = breakTimeDAO.findServingDateByQuarter(LocalDate.parse("2022-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeSelectRapport);
    }
    public void breakTimeRapportHalfYear(){
        List<BreakTime> breakTimeSelectRapport = breakTimeDAO.findServingDateByHalfYear(LocalDate.parse("2022-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeSelectRapport);
    }
    public void breakTimeRapportByYear(){
        List<BreakTime> breakTimeSelectRapport = breakTimeDAO.findServingDateByYear(LocalDate.parse("2023-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(breakTimeSelectRapport);
    }



}
