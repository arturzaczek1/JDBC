package jbdc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Employee {
    Integer id;
    String name;
    String lastName;
    String job;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Pracownik: " + id +
                ", imie: " + name +
                ", nazwisko: " + lastName +
                ", funkcja: " + job;
    }
}
