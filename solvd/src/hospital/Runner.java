package hospital;


import hospital.exceptions.InvalidAgeException;
import hospital.exceptions.InvalidRoomNumberException;
import hospital.exceptions.NameIsEmptyException;
import hospital.person.Doctors.*;
import hospital.person.Nurse;

import hospital.person.Patient;
import hospital.room.AssignRoom;
import hospital.room.rooms.HospitalRoom;
import hospital.room.rooms.PatientsRoom;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class Runner {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws InvalidRoomNumberException, InvalidAgeException, NameIsEmptyException {

        //Hospital.newPatient("",23,true, "fever",83,182); //NameIsEmptyException

        //INITIALIZATION OF THE PEOPLE AND ROOMS
        Hospital.newPatient("alejo",23,true, "fever",83,182);
        Hospital.newPatient("robert",29,true, "broken bone",90,172);
        Hospital.newPatient("juana",15,false, "examination",50,117);
        Hospital.newPatient("pepa",29,false, "pregnant",90,172);
        Hospital.DoctorArraylist.add(new FamilyPhysician("Smith", 30));
        Hospital.DoctorArraylist.add(new Pediatrician("James", 39));
        Hospital.DoctorArraylist.add(new Gynecologist("Jones", 32));
        Hospital.NurseLinkedList.add(new Nurse("Ramirez", 21));
        Hospital.NurseLinkedList.add(new Nurse("Da Silva", 28));
        Hospital.NurseLinkedList.add(new Nurse("Perez", 36));
        Hospital.NurseLinkedList.add(new Nurse("Gonzalez", 36));
        Hospital.RoomArraylist.add(new PatientsRoom(1, Hospital.NurseLinkedList.get(0)));
        Hospital.RoomArraylist.add(new PatientsRoom(2, Hospital.NurseLinkedList.get(1)));

        //Hospital.RoomArraylist.add(new PatientsRoom(-1, Hospital.NurseLinkedList.get(0))); //InvalidRoomNumberException
        //Hospital.PatientsArraylist.add(new Patient("alejo",-23,true, "fever",83,182)); //InvalidAgeException

        LOGGER.info(Hospital.PatientsArraylist.get(0).getName());
        Hospital.DoctorArraylist.get(0).getDiagnostic(Hospital.PatientsArraylist.get(0));
        Hospital.DoctorArraylist.get(1).getDiagnostic(Hospital.PatientsArraylist.get(1));
        Hospital.DoctorArraylist.get(1).getDiagnostic(Hospital.PatientsArraylist.get(2));
        Hospital.DoctorArraylist.get(2).getDiagnostic(Hospital.PatientsArraylist.get(3));


        LOGGER.info("This is an info message");
        LOGGER.info("Another info message");
        ArrayList<HospitalRoom> a = new ArrayList<>();
        AssignRoom.assignRoom(a,Hospital.PatientsArraylist.get(0),true);




     //   AssignRoom.assignRoom(Hospital.RoomArraylist,Hospital.PatientsArraylist.contains());

       /* boolean i = true;
        while (i) {
            printMenu();
            System.out.println("Enter an option: ");
            int option = scanner.nextInt();

            switch (option) {

                case 0: //PRINT OPTIONS
                    printMenu();
                    break;

                case 1:  //ADD NEW PATIENT
                    addPatient();
                    break;

                case 2: //GET DIAGNOSTIC
                    System.out.println("Enter the name of the patient: ");
                    String patientName2 = scanner.next();
                    if (Hospital.getPatient(patientName2) <= 0) {
                        IDiagnostic.getDiagnostic(Hospital.getPatient(patientName2));

                    } else System.out.println("The patient couldn't be found.");
                    break;
                case 3: //SET APPOINTMENT
                    System.out.println("Enter the name of the patient: ");
                    String patientName3 = scanner.next();
                    System.out.println("Enter the name of the doctor: ");
                    String doctorName = scanner.next();
                    System.out.println("Enter the date for the appointment (yyyy-mm-dd): ");
                    String date = scanner.next();

                    if (Hospital.getPatient(patientName3) <= 0 && Hospital.getDoctor(doctorName) <= 0) {
                        Hospital.setAppointment(Hospital.getPatient(patientName3), Hospital.getDoctor(doctorName), date);

                    } else System.out.println("The patient or doctor couldn't be found.");
                    break;
                case 4:
                    i = false;
            }
        }*/

    }

//    static void printMenu() {
//        System.out.println("Menu:\n" +
//                "0.Show menu\n" +
//                "1.Create new patient \n" +
//                "2.Get diagnostic.\n" +
//                "3.Search appointments.\n" +
//                "4.Quit.");
//    }
//
//    static void addPatient(){
//        String patientName1;
//        int age;
//        String nationality;
//        String symptoms;
//        int weight;
//        int height;
//        boolean isMale;
//
//        System.out.println("Enter new patient name: ");
//        patientName1 = scanner.next();
//        System.out.println("Enter patient age: ");
//        age = scanner.nextInt();
//        System.out.println("Is male? true/false");
//        isMale = scanner.nextBoolean();
//        System.out.println("Enter nationality: ");
//        nationality = scanner.next();
//        System.out.println("Enter weight: ");
//        weight = scanner.nextInt();
//        System.out.println("Enter height: ");
//        height = scanner.nextInt();
//        System.out.println("Enter symptoms: ");
//        symptoms = scanner.next();
//
//        Hospital.newPatient(patientName1, age, isMale, nationality, symptoms, weight, height);
//    }
}
