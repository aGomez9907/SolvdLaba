package hospital;

public class IntensiveCareRoom extends HospitalRoom{
    private boolean ventilator;
    public IntensiveCareRoom(int roomNumber, boolean ventilator, Patient patient){
        setFloor(3);
        setNumberOfBeds(1);
        setRoomNumber(roomNumber);
        this.ventilator=ventilator;
    }
}
