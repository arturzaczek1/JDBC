import lombok.Builder;

@Builder
public class Employee {
    Integer id;
    String name;
    String lastName;
    String job;

    @Override
    public String toString() {
        return "Pracownik: " + id +
                ", imie: " + name +
                ", nazwisko: " + lastName +
                ", funkcja: " + job;
    }
}
