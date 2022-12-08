package hospital.person;

import hospital.interfaces.IPrepareRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Nurse extends Person implements IPrepareRoom {

    private static final Logger LOGGER = LogManager.getLogger();
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
        LOGGER.info("The bed has been made.");
    }
    public void disinfectRoom(){
        LOGGER.info("The room has been disinfected.");
    }
    public void prepareIVSolution(){
        LOGGER.info("The IV solution is ready.");
    }
}
