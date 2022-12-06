package hospital.person.Doctors;

import hospital.Hospital;
import hospital.interfaces.IGetExam;
import hospital.person.Patient;
import hospital.room.AssignRoom;

import java.util.logging.Logger;

public class FamilyPhysician extends Doctor {
    private static Logger log = Logger.getLogger("hospital.person.Doctors.FamilyPhysician");

    public FamilyPhysician() {
    }

    public FamilyPhysician(String name, int age) {
        super(name, age);
    }

    public double measureHeight(Patient patient){
        return patient.getHeight();
    }

    public double measureWeight(Patient patient){
        return patient.getWeight();
    }


    @Override
    public void getDiagnostic(Patient p) {

        revision();

        log.info("The diagnosis is: ");
        switch (p.getSymptoms().toLowerCase()){
            case "fever":
                if(measureTemperature()>37) {
                    log.info("Patient need to rest and ibuprofen every 8 hours.");
                    break;
                }else if(measureTemperature()<34) {
                    log.info("Patient has hypothermia, need to warm up.");
                    break;
                }else log.info("Everything fine.");
                break;
           case "examination":
               log.info("The patient weights "+ p.getWeight()+ "Kg and is "+ p.getHeight()+"cm tall.");
                break;
            case "broken bone":
                if (IGetExam.getExam()){
                    log.info("Open fracture, need to stay in hospital.");
                    AssignRoom.assignRoom(Hospital.getRoomArraylist(),p,true);
                    break;
                }else log.info("Use a cast and get rest. Patient can go home");


            default:
                log.info("We cannot get a diagnosis for those symptoms.");
                break;


        }
    }
}
