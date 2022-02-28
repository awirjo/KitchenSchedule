package sr.unasat.schedule.kitchen.composite;

public class MenuItems extends MenuComposite{

    private String name;
    private String description;

    public MenuItems(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName(){
        return name;
    }
    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public void print() {
        System.out.println("MenuItems{" +
                "name='" + name + '\'' +
                ", description='" + description +
                '}');
    }




}
