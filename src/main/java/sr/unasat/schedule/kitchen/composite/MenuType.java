package sr.unasat.schedule.kitchen.composite;

import java.util.ArrayList;
import java.util.Iterator;

public class MenuType extends MenuComposite{
    private ArrayList<MenuComposite> menuItems;
    private String name;
    private String description;

    public MenuType(String name, String description) {
        this.name = name;
        this.description = description;
        this.menuItems = new ArrayList<>();
    }

    @Override
    public void add(MenuComposite menuComposite) {
        menuItems.add(menuComposite);
    }

    @Override
    public void remove(MenuComposite menuComposite) {
        int index = menuItems.indexOf(menuComposite);
        if (index > 0) {
            menuItems.remove(index);
        }
    }

    @Override
    public MenuComposite getChild(int index) {
        if (index < menuItems.size())
            return menuItems.get(index);
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("Name " + getName());
        System.out.println("Description " + getDescription());
        Iterator<MenuComposite> iterator = menuItems.iterator();
        while (iterator.hasNext()) {
            MenuComposite menuComponent = iterator.next();
            menuComponent.print();
        }
    }

}
