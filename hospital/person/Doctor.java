package hospital.person;

import hospital.person.Person;

public class Doctor extends Person {


    private String specialty;
    public Doctor(String name, int age, String nationality,String specialty){
        super(name, nationality, age);
        this.specialty=specialty;
    }

    public String getSpecialty() {
        return specialty;
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
