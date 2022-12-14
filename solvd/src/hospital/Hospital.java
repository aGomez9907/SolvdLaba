package hospital;

import hospital.exceptions.InvalidAgeException;
import hospital.exceptions.NameIsEmptyException;
import hospital.exceptions.PersonNotFoundException;
import hospital.exceptions.WrongSpecialtyException;
import hospital.person.Doctors.Doctor;
import hospital.person.Doctors.FamilyPhysician;
import hospital.person.Doctors.Gynecologist;
import hospital.person.Doctors.Pediatrician;
import hospital.person.Nurse;
import hospital.person.Patient;
import hospital.room.rooms.HospitalRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hospital {

    private static final Logger LOGGER = LogManager.getLogger();
    private ArrayList<Appointment> appointmentArrayList = new ArrayList<>();
    private ArrayList<Doctor> doctorArraylist = new ArrayList<>();

    private ArrayList<Patient> patientsArraylist = new ArrayList<>();
    private LinkedList<Nurse> nurseLinkedList = new LinkedList<>();
    private ArrayList<HospitalRoom> roomArraylist = new ArrayList<>();


    public void newAppointment(Appointment appointment) {
        appointmentArrayList.add(appointment);
    }

    public void newPatient(Patient patient) throws InvalidAgeException, NameIsEmptyException {
        patientsArraylist.add(patient);
    }

    public void newDoctor(Doctor doctor, String specialty) throws WrongSpecialtyException {
        switch (specialty.toLowerCase()) {
            case "familphysician":
                FamilyPhysician f = (FamilyPhysician) doctor;
                doctorArraylist.add(f);
                break;
            case "gynecologist":
                Gynecologist g = (Gynecologist) doctor;
                doctorArraylist.add(g);
                break;
            case "pediatrician":
                Pediatrician p = (Pediatrician) doctor;
                doctorArraylist.add(p);
                break;
            default:
                throw new WrongSpecialtyException();

        }
    }

    public void newHospitalRoom(HospitalRoom r) {
        roomArraylist.add(r);
    }

    public void newNurse(Nurse nurse) throws InvalidAgeException, NameIsEmptyException {
        nurseLinkedList.add(nurse);
    }

    public Patient getPatient(String name) throws PersonNotFoundException {
        for (Patient p : patientsArraylist) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new PersonNotFoundException(); //added exception
    }

    public Doctor getDoctor(String name) throws PersonNotFoundException {
        for (Doctor d : doctorArraylist) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        throw new PersonNotFoundException(); //added exception
    }

//    public  void assignRoom(Patient patient) {
//        for (PatientsRoom pr : RoomArraylist) {
//            if(pr.getPatient1() == null){
//                pr.setPatient1(patient);
//                return;
//            }else if(pr.getPatient2() == null){
//                pr.setPatient2(patient);
//                return;
//            }else System.out.println("No room available");
//        }
//
//    }

    public Doctor getDoctorPerSpecialty(String specialty) throws PersonNotFoundException {
        for (Doctor d : doctorArraylist) {
            if (d.getClass().getSimpleName().equals(specialty)) {
                return d;
            }
        }
        throw new PersonNotFoundException();
    }

    //NEED TO BE CHANGED
    // STOP USING INDEX, INSTEAD USE PATIENT ITSELF
//    public  void setAppointment(int indexOfPatient, int indexOfDoctor, String date) {
//
//        appointmentArrayList.add(new Appointment(LocalDate.parse(date), doctorArraylist.get(indexOfDoctor), patientsArraylist.get(indexOfPatient)));
//
//
//    }

    public LinkedList<Nurse> getNurseLinkedList() {
        return nurseLinkedList;
    }

    public ArrayList<HospitalRoom> getRoomArraylist() {
        return roomArraylist;
    }

    public ArrayList<Appointment> getAppointmentArrayList() {
        return appointmentArrayList;
    }

    public ArrayList<Doctor> getDoctorArraylist() {
        return doctorArraylist;
    }

    public ArrayList<Patient> getPatientsArraylist() {
        return patientsArraylist;
    }
}


