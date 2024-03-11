package pl.zajavka;

import java.util.Objects;

public class Person {

    private String name;
    private String surname;
    private Boolean isVip;
    private Integer counter;
    private String personID;

    public Person(String name, String surname, int counter) {
        this(name, surname, counter, false);
    }

    public Person(String name, String surname, Integer counter, Boolean isVip) {
        this.name = name;
        this.surname = surname;
        this.isVip = isVip;
        this.counter = counter;
        this.personID = generateID();
    }

    private String generateID() {
        return isVip
                ? String.format("%s_%s_%s,VIP", this.name, this.surname, this.counter)
                : String.format("%s_%s_%s", this.name, this.surname, this.counter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personID, person.personID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personID);
    }

    @Override
    public String toString() {
        return personID;
    }
}
