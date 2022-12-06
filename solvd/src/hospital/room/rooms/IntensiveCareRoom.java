package hospital.room.rooms;

import hospital.person.Patient;

public class IntensiveCareRoom extends HospitalRoom {
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
        System.out.println("Bed ready for patient.");
    };
    public void disinfectRoom(){
        System.out.println("Room ready for patient.");
    }
    public void prepareIVSolution(){
        System.out.println("IV solution ready for patient.");
    }
}
