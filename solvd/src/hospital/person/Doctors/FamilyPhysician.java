package hospital.person.Doctors;

public class FamilyPhysician extends Doctor {

    public FamilyPhysician() {
    }

    public FamilyPhysician(String name, int age) {
        super(name, age);
    }

    public double measureHeight(){
        return (Math.random() * (210-140)+140);
    }

    public double measureWeight(){
        return (Math.random() * (60-20)+20);
    }
}
