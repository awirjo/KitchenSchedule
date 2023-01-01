package sr.unasat.schedule.kitchen.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String breakfast;
    @Column
    private String lunch;
    @Column
    private String dinner;
    @Column
    private String special_meals;
    @Column
    private String description;
    @OneToMany(mappedBy = "menu")
    @Column
    private Set<BreakTime> breakTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getSpecial_meals() {
        return special_meals;
    }

    public void setSpecial_meals(String special_meals) {
        this.special_meals = special_meals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<BreakTime> getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Set<BreakTime> breakTime) {
        this.breakTime = breakTime;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "special_meals='" + special_meals + '\'' +
                '}';
    }
}
