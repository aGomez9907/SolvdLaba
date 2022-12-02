package hospital;

import hospital.person.Patient;

public interface IDiagnostic extends IGetExam{


    static int getDiagnostic(int i) {
        Patient p = Hospital.PatientsArraylist.get(i);
        boolean isSerious = IGetExam.getExam();
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
                        Hospital.setAppointment(Hospital.getPatient(p.getName()),Hospital.getDoctorPerSpecialty("Gynecologist"),"YYYYMMDD"); //STILL NOT FINISHED
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
}
