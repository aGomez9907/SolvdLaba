package hospital.person;

import hospital.person.Person;

import java.util.Objects;

public class Patient extends Person {


    private boolean putInHospital;
    private String symptoms;
    private int weight;
    private int height;

    private boolean isMale;
    public Patient(String name, int age,boolean isMale, String nationality,String symptoms, int weight, int height){
        super(name, nationality, age);
        this.weight=weight;
        this.height=height;
        this.symptoms=symptoms;
        this.isMale=isMale;
    }


    public void setPutInHospital(boolean putInHospital) {
        this.putInHospital = putInHospital;
    }



    public boolean isMale() {
        return isMale;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return putInHospital == patient.putInHospital && weight == patient.weight && height == patient.height && isMale == patient.isMale && Objects.equals(symptoms, patient.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(putInHospital, symptoms, weight, height, isMale);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "putInHospital=" + putInHospital +
                ", symptoms='" + symptoms + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", isMale=" + isMale +
                '}';
    }
}
