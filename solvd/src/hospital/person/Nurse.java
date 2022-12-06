package hospital.person;

import hospital.interfaces.IPrepareRoom;

public class Nurse extends Person implements IPrepareRoom {
    public Nurse(String name, int age){
        super(name, age);
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

    public void makeBed() {
        System.out.println("The bed has been made.");
    }
    public void disinfectRoom(){
        System.out.println("The room has been disinfected.");
    }
    public void prepareIVSolution(){
        System.out.println("The IV solution is ready.");
    }
}
