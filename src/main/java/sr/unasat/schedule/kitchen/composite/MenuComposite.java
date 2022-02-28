package sr.unasat.schedule.kitchen.composite;

import java.awt.*;

public abstract class MenuComposite {

    public void add(MenuComposite menuComponent) {
        throw new IllegalStateException();
    }
    public void remove(MenuComposite menuComponent) {
        throw new IllegalStateException();
    }
    public MenuComposite getChild(int index) {
        throw new IllegalStateException();
    }
    public String getName() {
        throw new IllegalStateException();
    }
    public String getDescription() {
        throw new IllegalStateException();
    }
    public void print() {
        throw new IllegalStateException();
    }
}
