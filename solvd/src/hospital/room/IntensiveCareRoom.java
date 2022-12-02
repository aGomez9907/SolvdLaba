package hospital.room;

import hospital.person.Patient;
import hospital.room.HospitalRoom;

public class IntensiveCareRoom extends HospitalRoom {
    private boolean ventilator;
    public IntensiveCareRoom(int roomNumber, boolean ventilator, Patient patient){
        super(1,3, roomNumber);
        this.ventilator=ventilator;
    }
}
