package hospital.person;

import hospital.interfaces.IPrepareRoom;

import java.util.logging.Logger;

public class Nurse extends Person implements IPrepareRoom {

    private static Logger log = Logger.getLogger("hospital.person.Nurse");
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
        log.info("The bed has been made.");
    }
    public void disinfectRoom(){
        log.info("The room has been disinfected.");
    }
    public void prepareIVSolution(){
        log.info("The IV solution is ready.");
    }
}
