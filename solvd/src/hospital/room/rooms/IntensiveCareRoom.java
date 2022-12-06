package hospital.room.rooms;

import hospital.person.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntensiveCareRoom extends HospitalRoom {

    private static final Logger LOGGER = LogManager.getLogger();
    private Patient patient;

    public IntensiveCareRoom(int roomNumber, Patient patient) {
        super(1, 3, roomNumber);

        this.patient = null;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void makeBed() {
        LOGGER.info("Bed ready for patient.");
    }

    ;

    public void disinfectRoom() {
        LOGGER.info("Room ready for patient.");
    }

    public void prepareIVSolution() {
        LOGGER.info("IV solution ready for patient.");
    }
}
