package hospital.room.rooms;

import hospital.person.Patient;

import java.util.logging.Logger;

public class IntensiveCareRoom extends HospitalRoom {

    private static Logger log = Logger.getLogger("hospital.room.rooms.IntensiveCareRoom");
    private Patient patient;
    public IntensiveCareRoom(int roomNumber, Patient patient){
        super(1,3, roomNumber);

        this.patient = null;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void makeBed(){
        log.info("Bed ready for patient.");
    };
    public void disinfectRoom(){
        log.info("Room ready for patient.");
    }
    public void prepareIVSolution(){
        log.info("IV solution ready for patient.");
    }
}
