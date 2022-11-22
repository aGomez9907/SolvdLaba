package hospital;

public class SurgeryRoom extends HospitalRoom{
    private Doctor doctor;
    private Patient patient;
    private String surgery;

    public SurgeryRoom(int roomNumber, Doctor doctor,Patient patient, String surgery){
        setFloor(2);
        setNumberOfBeds(1);
        setRoomNumber(roomNumber);
        this.doctor=doctor;
        this.patient=patient;
        this.surgery=surgery;
    }
}
