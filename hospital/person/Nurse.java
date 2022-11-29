package hospital.person;

import hospital.person.Person;

public class Nurse extends Person {
    public Nurse(String name, int age, String nationality){
        super(name, nationality, age);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
