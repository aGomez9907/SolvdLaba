package hospital;

import java.time.LocalDate;
import hospital.person.Doctor;
import hospital.person.Nurse;
import hospital.person.Patient;
import hospital.room.IntensiveCareRoom;
import hospital.room.PatientsRoom;
import hospital.room.SurgeryRoom;

import java.util.ArrayList;
import java.util.Random;

public class Hospital {
    static ArrayList<Appointment> AppointmentArrayList = new ArrayList<>();
    static ArrayList<Doctor> DoctorArraylist = new ArrayList<>();

    static ArrayList<Patient> PatientsArraylist = new ArrayList<>();
    static ArrayList<Nurse> NurseArraylist = new ArrayList<>();
    static ArrayList<PatientsRoom> PatientsRoomArraylist = new ArrayList<>();
    static ArrayList<SurgeryRoom> SurgeryRoomArrayList = new ArrayList<>();
    static ArrayList<IntensiveCareRoom> IntensiveCareRoomArrayList = new ArrayList<>();


    public static void newPatient(String name, int age, boolean isMale, String nationality, String symptoms, int weight, int height) {
        PatientsArraylist.add(new Patient(name, age, isMale, nationality, symptoms, weight, height));
    }


    public static int getDiagnostic(int i) {
        Patient p = PatientsArraylist.get(i);
        boolean isSerious = getExam();
        System.out.println("The diagnosis is: ");
        switch (p.getSymptoms().toLowerCase()) {
            case "fever":
                if (isSerious) {
                    System.out.println("Patient need to stay in hospital.");

                    return 4;
                } else {
                    System.out.println("Ibuprofen every 8 hours.");
                    return 0;
                }
            case "headache":
                if (isSerious) {

                    System.out.println("Brain tumour, prepare to surgery.");
                    return 1;

                } else System.out.println("Ibuprofen every 8 hours.");
                return 0;
            case "vomit":
                if (!p.isMale()) {
                    if (isSerious) {
                        System.out.println("Appointment with gynecologist");
                        setAppointment(getPatient(p.getName()),getDoctorPerSpecialty("Gynecologist"),"YYYYMMDD"); //STILL NOT FINISHED
                        return 2;
                    } else {
                        System.out.println("Rest and diet.");
                        return 0;
                    }
                } else {
                    if (isSerious) {
                        System.out.println("Stomach cancer");
                        return 3;
                    }
                    System.out.println("Rest and diet");
                    return 0;
                }

            case "broken bone":
                System.out.println("Get an X-RAY and put a cast");
                if (isSerious) {
                    System.out.println("Patient need to stay in hospital.");
                    return 4;
                } else return 0;

            case "decompensation":
                if (isSerious) {
                    System.out.println("Patient need to stay in hospital.");
                    return 4;
                } else return 0;

            default:
                System.out.println("We cannot get a diagnosis for those symptoms.");
                return -1;


        }
    }


    public static boolean getExam() {
        Random random = new Random();
        return random.nextBoolean();
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

    public static void assignRoom(Patient patient) {
        for (PatientsRoom pr : PatientsRoomArraylist) {
            if(pr.getPatient1() == null){
                pr.setPatient1(patient);
                return;
            }else if(pr.getPatient2() == null){
                pr.setPatient2(patient);
                return;
            }else System.out.println("No room available");
        }

    }

    public static int getDoctorPerSpecialty(String specialty) {
        for (Doctor d : DoctorArraylist) {
            if (d.getSpecialty().equals(specialty)) {
                return DoctorArraylist.indexOf(d);
            }
        }
        return -1;
    }

    public static void setAppointment(int indexOfPatient, int indexOfDoctor, String date) {

        AppointmentArrayList.add(new Appointment(LocalDate.parse(date), DoctorArraylist.get(indexOfDoctor), PatientsArraylist.get(indexOfPatient)));


    }
}


