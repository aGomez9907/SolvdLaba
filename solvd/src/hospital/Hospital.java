package hospital;

import java.time.LocalDate;
import hospital.person.Doctors.Doctor;
import hospital.person.Nurse;
import hospital.person.Patient;
import hospital.room.rooms.HospitalRoom;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hospital {
    static ArrayList<Appointment> AppointmentArrayList = new ArrayList<>();
    static ArrayList<Doctor> DoctorArraylist = new ArrayList<>();

    static ArrayList<Patient> PatientsArraylist = new ArrayList<>();
    static LinkedList<Nurse> NurseLinkedList = new LinkedList<>();
    static ArrayList<HospitalRoom> RoomArraylist = new ArrayList<>();



    public static void newPatient(String name, int age, boolean isMale, String nationality, String symptoms, int weight, int height) {
        PatientsArraylist.add(new Patient(name, age, isMale, symptoms, weight, height));
    }








    public static int getPatient(String name) {
        for (Patient p : PatientsArraylist) {
            if (p.getName().equals(name)) {
                return PatientsArraylist.indexOf(p);
            }
        }
        return -1;


    }

    public static int getDoctor(String name) {
        for (Doctor d : DoctorArraylist) {
            if (d.getName().equals(name)) {
                return DoctorArraylist.indexOf(d);
            }
        }
        return -1;
    }

//    public static void assignRoom(Patient patient) {
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

    public static int getDoctorPerSpecialty(String specialty) {
        for (Doctor d : DoctorArraylist) {
            if (d.getClass().getSimpleName().equals(specialty)) {
                return DoctorArraylist.indexOf(d);
            }
        }
        return -1;
    }

    public static void setAppointment(int indexOfPatient, int indexOfDoctor, String date) {

        AppointmentArrayList.add(new Appointment(LocalDate.parse(date), DoctorArraylist.get(indexOfDoctor), PatientsArraylist.get(indexOfPatient)));


    }

    public static LinkedList<Nurse> getNurseLinkedList() {
        return NurseLinkedList;
    }

    public static ArrayList<HospitalRoom> getRoomArraylist() {
        return RoomArraylist;
    }
}


