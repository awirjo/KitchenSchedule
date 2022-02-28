package sr.unasat.schedule.kitchen.composite;

public class MenuApp {
    public void menuApplication(){

        MenuComposite breakfastMenu = new MenuType("Breakfast menu", "Breakfast");
        MenuComposite lunchMenu = new MenuType("Tandoori", "Lunch");
        MenuComposite dinnerMenu = new MenuType("South Indian", "Dinner");

        MenuComposite allMenus = new MenuType("All menus", "All menu combined together");
        allMenus.add(breakfastMenu);
        allMenus.add(lunchMenu);
        allMenus.add(dinnerMenu);

        MenuComposite boiledEgg = new MenuItems("Boiled Egg", "Boiled white egg");
        MenuComposite pannerTikka = new MenuItems("Panner Tikka", "Spicy cottage cheese tikka");

        breakfastMenu.add(boiledEgg);
        lunchMenu.add(pannerTikka);

        allMenus.print();
    }
}
