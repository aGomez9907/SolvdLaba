package hospital.person.Doctors;

import hospital.IGetExam;

public class Gynecologist extends Doctor{

    public Gynecologist() {
    }

    public Gynecologist(String name, int age) {
        super(name, age);
    }


    public void birth(){
        System.out.println("The baby has been born.");
    }

    public boolean pelvicExam(){
        return IGetExam.getExam();
    }
}
