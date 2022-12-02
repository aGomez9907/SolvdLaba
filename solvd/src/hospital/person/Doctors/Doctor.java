package hospital.person.Doctors;

import hospital.person.Person;

import javax.print.Doc;
import hospital.IGetExam;

public class Doctor extends Person implements IGetExam{



    //CONSTRUCTOR
    public Doctor(){

    }
    public Doctor(String name, int age){
        super(name, age);
    }



    //METHODS
   public void revision(){
       System.out.println("Doctor "+ super.getName() +" is examining the patient.");
   }

   public double takeTemperature(){
        return (Math.random()*(42-33)+33);
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
