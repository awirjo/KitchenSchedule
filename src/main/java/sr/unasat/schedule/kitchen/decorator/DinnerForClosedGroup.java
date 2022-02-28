package sr.unasat.schedule.kitchen.decorator;

import sr.unasat.schedule.kitchen.dao.MenuDAO;
import sr.unasat.schedule.kitchen.entities.Menu;

public class DinnerForClosedGroup implements SpecialMeal{

    MenuDAO menuDaoGroup = new MenuDAO();
    @Override
    public void getMeal(Menu menuInsert) {
        System.out.println(" Dinner order exclusive for reserved employees: " + menuInsert.getDinner());
    }
}
