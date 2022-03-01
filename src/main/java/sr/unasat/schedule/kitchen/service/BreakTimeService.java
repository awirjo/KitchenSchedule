package sr.unasat.schedule.kitchen.service;


import sr.unasat.schedule.kitchen.dao.BreakTimeDAO;
import sr.unasat.schedule.kitchen.dao.MenuDAO;
import sr.unasat.schedule.kitchen.entities.BreakTime;
import sr.unasat.schedule.kitchen.entities.Menu;

public class BreakTimeService {

    BreakTimeDAO breakTimeDAO = new BreakTimeDAO();
    MenuDAO menuDAO = new MenuDAO();

    public void breakTimeUpdate(){
        BreakTime findBreakTime = breakTimeDAO.findByServingTime("From 8am till 7pm");
        Menu menuUpdate = Menu.builder().breakfast("Brood ei").lunch("Bami").dinner("Mac&Cheese").description("Menu of the day").special_meals("Cake").build();
        menuDAO.insertMenu(menuUpdate);
        findBreakTime.setMenu(menuUpdate);
        breakTimeDAO.updateBreakTime(findBreakTime);
        System.out.println("The following records are updated: " + findBreakTime.getMenu());
    }

    public void breakTimeRetrieve(){
        BreakTime breakTimeSelect = breakTimeDAO.findByServingTime("From 8am till 7pm");
//        breakTimeSelect.stream().forEach(System.out::println);
        System.out.println("Retrieved record Break Time: " + "\n" + breakTimeSelect);
    }

    public void breakTimeDelete(){
        BreakTime deletedBreakTime = breakTimeDAO.findByServingTime("From 8am till 7pm");
        breakTimeDAO.deleteBreakTimeMeal("From 8am till 7pm");
        System.out.println("The following records are deleted: " + deletedBreakTime);
    }




}
