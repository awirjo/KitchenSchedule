package sr.unasat.schedule.kitchen.decorator;

import sr.unasat.schedule.kitchen.dao.MenuDAO;
import sr.unasat.schedule.kitchen.entities.Menu;

public class BirthdayParty extends SpecialMealDecorator {

    MenuDAO menuDaoGroup = new MenuDAO();

    public BirthdayParty(SpecialMeal decoratedSpecial) {
        super(decoratedSpecial);
    }

    @Override
    public void getMeal(Menu menuInsert){
        requestVipMeal(decoratedSpecial);
        Menu menuInsertSpecial = Menu.builder().special_meals("Party snacks and drinks")
                .description("Only for B-day parties").build();
        menuDaoGroup.insertMenu(menuInsertSpecial);
        decoratedSpecial.getMeal(menuInsertSpecial);
    }
    private void requestVipMeal(SpecialMeal decoratedSpecial){

        System.out.println("Party meal order: ");
    }
}
