package hospital.person.Doctors;

import hospital.IGetExam;

public class Surgeon extends Doctor{

    public Surgeon() {
    }

    public Surgeon(String name, int age){
        super(name,age);
    }

    public boolean surgery(){
        return IGetExam.getExam();
    }


}
