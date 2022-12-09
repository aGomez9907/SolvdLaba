package hospital.room.rooms;

import hospital.exceptions.InvalidRoomNumberException;
import hospital.interfaces.IPrepareRoom;

public abstract class HospitalRoom implements IPrepareRoom {
    private int numberOfBeds;
    private int floor;
    private int roomNumber;

    public HospitalRoom() {

    }


    public HospitalRoom(int numberOfBeds, int floor, int roomNumber) throws InvalidRoomNumberException {
        if(roomNumber <= 0){
            throw new InvalidRoomNumberException("Exception: Room number must be higher than zero.");
        }

        this.numberOfBeds = numberOfBeds;
        this.floor = floor;
        this.roomNumber = roomNumber;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public int getFloor() {
        return floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
