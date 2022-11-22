package hospital;

public class PatientsRoom extends HospitalRoom{
    private Patient patient1;
    private Patient patient2;
    private Nurse nurse;
    public PatientsRoom(int roomNumber, Nurse nurse){
        setNumberOfBeds(2);
        setFloor(1);
        setRoomNumber(roomNumber);
        this.nurse=nurse;
    }

    public Patient getPatient1() {
        return patient1;
    }

    public Patient getPatient2() {
        return patient2;
    }

    public void setPatient1(Patient patient1) {
        this.patient1 = patient1;
    }

    public void setPatient2(Patient patient2) {
        this.patient2 = patient2;
    }
}
