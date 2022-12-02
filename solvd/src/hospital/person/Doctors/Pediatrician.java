package hospital.person.Doctors;

public class Pediatrician extends Doctor{

    public Pediatrician() {
    }

    public Pediatrician(String name, int age){
        super(name,age);
    }


    public double measureHeight(){
        return (Math.random() * (160-80)+80);
    }

    public double measureWeight(){
        return (Math.random() * (60-20)+20);
    }
}
