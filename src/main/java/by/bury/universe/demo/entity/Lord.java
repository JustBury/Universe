package by.bury.universe.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lords")
public class Lord {

    private static final String MESSAGE_INVALID_NAME = "This field can contain only the characters of the English alphabet and the characters !._-^, the length of the field is from 2 to 20 characters.";
    private static final String MESSAGE_INVALID_AGE = "Age cannot be negative";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lord")
    private int id;

    @Column(name = "name")
    @Pattern(regexp = "([a-zA-Z!._/-^]{2,20}$)", message = MESSAGE_INVALID_NAME)
    private String name;


    @Column(name = "age")
    @Min(value = 0, message = MESSAGE_INVALID_AGE)
    private int age;

    @OneToMany(mappedBy = "lord",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    List<Planet> planets;

    public Lord() {
    }

    public Lord(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lord lord = (Lord) o;
        return id == lord.id && age == lord.age && Objects.equals(name, lord.name);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime * id;
        result = result * prime * age;
        result = result * prime * ((name == null) ? 1 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '@' +
                "id=" + id +
                ", name=" + name +
                ", age=" + age;
    }
}
