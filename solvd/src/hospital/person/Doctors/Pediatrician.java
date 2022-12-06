package hospital.person.Doctors;
import hospital.Hospital;
import hospital.interfaces.IGetExam;
import hospital.person.Patient;
import hospital.room.AssignRoom;

public class Pediatrician extends Doctor{

    public Pediatrician() {
    }

    public Pediatrician(String name, int age){
        super(name,age);
    }


    public double measureHeight(Patient patient){
        return patient.getHeight();
    }

    public double measureWeight(Patient patient){
        return patient.getWeight();
    }


    public void getDiagnostic(Patient p) {
        if (p.getAge()>=18){
            System.out.println("Not a kid, cannot be diagnosed.");
        }
        revision();

        System.out.println("The diagnosis is: ");
        switch (p.getSymptoms().toLowerCase()){
            case "fever":
                if(measureTemperature()>37) {
                    System.out.println("Patient need to rest and ibuprofen every 8 hours.");
                    break;
                }else if(measureTemperature()<34) {
                    System.out.println("Patient has hypothermia, need to warm up.");
                    break;
                }else System.out.println("Everything fine.");
                break;
            case "examination":
                System.out.println("The patient weights "+ p.getWeight()+ "Kg and is "+ p.getHeight()+"cm tall.");
                break;
            case "broken bone":
                if (IGetExam.getExam()){
                    System.out.println("Open fracture, need to stay in hospital.");
                    AssignRoom.assignRoom(Hospital.getRoomArraylist(),p,false);
                    break;
                }else System.out.println("Use a cast and get rest. Patient can go home");


            default:
                System.out.println("We cannot get a diagnosis for those symptoms.");
                break;


        }
    }
}
