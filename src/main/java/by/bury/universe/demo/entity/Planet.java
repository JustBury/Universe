package by.bury.universe.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Table(name = "Planets")
public class Planet {

    private static final String MESSAGE_INVALID_NAME = "This field can contain only the characters of the English alphabet and the characters !._-^, the length of the field is from 2 to 20 characters.";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlanets")
    private int id;

    @Column(name = "name_planet")
    @Pattern(regexp = "([a-zA-Z!._/-^]{2,20}$)", message = MESSAGE_INVALID_NAME)
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Lord lord;

    public Planet() {

    }

    public Planet(String name) {
        this.name = name;
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

    public Lord getLord() {
        return lord;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return id == planet.id
                && Objects.equals(name, planet.name)
                && Objects.equals(lord, planet.lord);
    }

    @Override
    public int hashCode() {
        final int prime = 43;
        int result = 1;
        result = result * prime * id;
        result = result * prime * ((name == null) ? 1 : name.hashCode());
        result = result * prime * ((lord == null)? 1 : lord.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "id=" + id +
                ", name=" + name +
                ", lord=" + lord;
    }
}

