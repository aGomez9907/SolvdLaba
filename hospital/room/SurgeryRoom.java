package hospital.room;

import hospital.person.Doctor;
import hospital.person.Patient;
import hospital.room.HospitalRoom;

public class SurgeryRoom extends HospitalRoom {
    private Doctor doctor;
    private Patient patient;
    private String surgery;

    public SurgeryRoom(int roomNumber, Doctor doctor, String surgery){
       super(1,2,roomNumber);
        this.doctor=doctor;
        this.patient=null;
        this.surgery=surgery;
    }
}