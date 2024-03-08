package pl.zajavka;

import java.util.Objects;

public class Person {

    private String name;
    private String surname;
    private int counter;
    private boolean isVIP;
    private String personId;

    public Person(String name, String surname, int counter, String personId, boolean isVIP) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.isVIP = isVIP;
        this.personId = generatorID();
    }

    private String generatorID() {
        return isVIP ?
                String.format("%s_%s_%s,VIP", this.name, this.surname, this.counter) :
                String.format("%s_%s_%s", this.name, this.surname, this.counter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personId, person.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }

    @Override
    public String toString() {
        return personId;
    }
}
