package hospital;


import hospital.person.Doctor;
import hospital.person.Nurse;

import hospital.room.PatientsRoom;


import java.util.Scanner;

public class Runner {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //CREATION OF THE PEOPLE AND ROOMS
        Hospital.DoctorArraylist.add(new Doctor("Smith", 30, "US", "Family physician"));
        Hospital.DoctorArraylist.add(new Doctor("James", 39, "US", "Pediatrician"));
        Hospital.DoctorArraylist.add(new Doctor("Butcher", 66, "Canada", "Surgeon"));
        Hospital.NurseArraylist.add(new Nurse("Ramirez", 21, "Mexico"));
        Hospital.NurseArraylist.add(new Nurse("Da Silva", 28, "Brazil"));
        Hospital.PatientsRoomArraylist.add(new PatientsRoom(1, Hospital.NurseArraylist.get(0)));
        Hospital.PatientsRoomArraylist.add(new PatientsRoom(2, Hospital.NurseArraylist.get(1)));


        boolean i = true;
        while (i) {
            printMenu();
            System.out.println("Enter an option: ");
            int option = scanner.nextInt();

            switch (option) {

                case 0: //PRINT OPTIONS
                    printMenu();
                    break;

                case 1:  //ADD NEW PATIENT

                    String patientName1;
                    int age;
                    String nationality;
                    String symptoms;
                    int weight;
                    int height;
                    boolean isMale;

                    System.out.println("Enter new patient name: ");
                    patientName1 = scanner.next();
                    System.out.println("Enter patient age: ");
                    age = scanner.nextInt();
                    System.out.println("Is male? true/false");
                    isMale = scanner.nextBoolean();
                    System.out.println("Enter nationality: ");
                    nationality = scanner.next();
                    System.out.println("Enter weight: ");
                    weight = scanner.nextInt();
                    System.out.println("Enter height: ");
                    height = scanner.nextInt();
                    System.out.println("Enter symptoms: ");
                    symptoms = scanner.next();

                    Hospital.newPatient(patientName1, age, isMale, nationality, symptoms, weight, height);
                    break;

                case 2: //GET DIAGNOSTIC
                    System.out.println("Enter the name of the patient: ");
                    String patientName2 = scanner.next();
                    if (Hospital.getPatient(patientName2) <= 0) {
                        Hospital.getDiagnostic(Hospital.getPatient(patientName2));

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
        }

    }

    static void printMenu() {
        System.out.println("Menu:\n" +
                "0.Show menu\n" +
                "1.Create new patient \n" +
                "2.Get diagnostic.\n" +
                "3.Search appointments.\n" +
                "4.Quit.");
    }
}
