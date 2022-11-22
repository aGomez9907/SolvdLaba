package hospital;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hospital {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        ArrayList<Schedule> schedule = new ArrayList<>();

        Doctor family = new Doctor("Smith", 30,"US", "Family physician");
        Doctor pediatrician = new Doctor("James", 39,"US", "Pediatrician");
        Doctor surgeon = new Doctor("Butcher", 66,"Canada", "Surgeon");
        Doctor gynecologist = new Doctor("Sanders", 45,"Argentina", "Gynecologist");
        Nurse nurse1 = new Nurse("Ramirez", 21,"Mexico");
        Nurse nurse2 = new Nurse("Da Silva", 28,"Brazil");
        PatientsRoom patientsRoom1 = new PatientsRoom(1,nurse1);
        PatientsRoom patientsRoom2 = new PatientsRoom(2,nurse2);

        boolean i = true;
        while(i){
            printMenu();
            System.out.println("Enter an option: ");
            int option= scanner.nextInt();

            switch (option){

                case 0:
                    printMenu();
                    break;
                case 1:
                    int diagnostic;
                    Patient p = newPatient();
                    if(p.getAge()<18){
                       diagnostic=diagnose(pediatrician, p);
                    }else {
                        diagnostic = diagnose(family, p);
                    }

                    switch (diagnostic){
                        case 0:
                            System.out.println("The patient can go home.");
                            break;
                        case 1:
                            SurgeryRoom surgeryRoom1 = new SurgeryRoom(10,surgeon,p,"Brain tumour");
                            IntensiveCareRoom intensive1 = new IntensiveCareRoom(5,true,p);
                            break;
                        case 2:
                            schedule.add( new Schedule(p.getAppointment(),gynecologist,p));
                        case 3:
                            SurgeryRoom surgeryRoom2 = new SurgeryRoom(3,surgeon,p,"Stomach cancer");
                            break;
                        case 4:
                            if(patientsRoom1.getPatient1()==null) {
                                patientsRoom1.setPatient1(p);
                            } else if (patientsRoom1.getPatient2()==null) {
                                patientsRoom1.setPatient2(p);
                            }else if(patientsRoom2.getPatient1()==null) {
                                patientsRoom2.setPatient1(p);
                            }else if (patientsRoom2.getPatient2()==null) {
                                patientsRoom1.setPatient2(p);
                            } else System.out.println("No room available.");
                            break;
                        case -1:
                            break;

                    }

                    break;
                case 2:
                    System.out.println("Enter patient's name: ");
                    String name = scanner.next();
                    System.out.println(findAppointment(name,schedule));
                    break;
                case 3:
                    i = false;
            }
        }


    }

    static void printMenu(){
        System.out.println("Menu:\n" +
                "0.Show menu\n" +
                "1.Create new patient and get diagnostic.\n" +
                "2.Search appointments.\n" +
                "3.Quit.");
    }
    static String findAppointment(String name, ArrayList<Schedule> schedule) {

        for (Schedule pepe : schedule) {
            if (pepe.getPatient().getName().equals(name)) {
                return pepe.getPatient().getAppointment();
            }
        }
        return null;
    }

    static int diagnose(Doctor doctor, Patient p){
        System.out.println("Doctor "+ doctor.getName()+ " is examining the patient "+ p.getName());
        boolean isSerious=getExam();
        System.out.println("The diagnosis is: ");
        switch (p.getSymptoms().toLowerCase()){
            case "fever":
                if(isSerious){
                    System.out.println("Patient need to stay in hospital.");
                    return 4;
                }else {
                    System.out.println("Ibuprofen every 8 hours.");
                    return 0;
                }
            case "headache":
                if(isSerious){
                    p.setPutInHospital(true);
                    System.out.println("Brain tumour, prepare to surgery.");
                    return 1;

                }else System.out.println("Ibuprofen every 8 hours.");
                return 0;
            case "vomit":
                if (!p.isMale()){
                    if(isSerious) {
                        System.out.println("Appointment with gynecologist");
                        p.setAppointment("Tuesday 14:45");
                        return 2;
                    }else {
                        System.out.println("Rest and diet.");
                        return 0;
                    }
                }else {
                    if (isSerious){
                        System.out.println("Stomach cancer");
                        return 3;
                    }
                    System.out.println("Rest and diet");
                    return 0;
                }

            case "broken bone":
                System.out.println("Get an X-RAY and put a cast");
                if(isSerious){
                    System.out.println("Patient need to stay in hospital.");
                    return 4;
                }else return 0;

            case "decompensation":
                if(isSerious){
                    System.out.println("Patient need to stay in hospital.");
                    return 4;
                }else return 0;

            default:
                System.out.println("We cannot get a diagnosis for those symptoms.");
                return -1;


        }
    }

    static boolean getExam(){
        Random random = new Random();
        return random.nextBoolean();
    }

    static Patient newPatient(){
        String name;
        int age;
        String nationality;
        String symptoms;
        int weight;
        int height;
        boolean healthCareProvider;
        boolean isMale;

        System.out.println("Enter new patient name: ");
        name = scanner.next();
        System.out.println("Enter patient age: ");
        age = scanner.nextInt();
        System.out.println("Is male? true/false");
        isMale = scanner.nextBoolean();
        System.out.println("Enter nationality: ");
        nationality = scanner.next();
        System.out.println("Enter weight: ");
        weight= scanner.nextInt();
        System.out.println("Enter height: ");
        height=scanner.nextInt();
        System.out.println("Enter symptoms: ");
        symptoms= scanner.next();
        System.out.println("Has health care provider? true/false ");
        healthCareProvider = scanner.nextBoolean();

        return new Patient(name,age,isMale,nationality,symptoms,healthCareProvider,weight,height);


    }
}
