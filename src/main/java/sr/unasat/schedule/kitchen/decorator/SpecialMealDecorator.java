package sr.unasat.schedule.kitchen.decorator;

import sr.unasat.schedule.kitchen.entities.Menu;

public abstract class SpecialMealDecorator implements SpecialMeal{

    protected SpecialMeal decoratedSpecial;

    public SpecialMealDecorator(SpecialMeal decoratedSpecial) {
        this.decoratedSpecial = decoratedSpecial;
    }

    public void getMeal(Menu menuInsert){
        decoratedSpecial.getMeal(menuInsert);
    }
}
