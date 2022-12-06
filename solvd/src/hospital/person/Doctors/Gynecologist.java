package hospital.person.Doctors;

import hospital.Hospital;
import hospital.interfaces.IGetExam;
import hospital.person.Patient;
import hospital.room.AssignRoom;

import java.util.logging.Logger;

public class Gynecologist extends Doctor{

    private static Logger log = Logger.getLogger("hospital.person.Doctors.Gynecologist");

    public Gynecologist() {
    }

    public Gynecologist(String name, int age) {
        super(name, age);
    }


    public void birth(){
        log.info("The baby has been born.");
    }

    public boolean pelvicExam(){
        return IGetExam.getExam();
    }

    public boolean pregnancyTest(){return IGetExam.getExam();}

    @Override
    public void getDiagnostic(Patient p) {
        if(p.isMale()){
            log.info("The patient is male. Cannot be diagnosed.");
            return;
        }
        revision();

        log.info("The diagnosis is: ");
        switch (p.getSymptoms().toLowerCase()){

           case "pelvic exam":
               if(pelvicExam()){
                   log.info("Everything is fine, can go home.");
               }else {
                   log.info("Exams went bad, need to stay at hospital");
                   AssignRoom.assignRoom(Hospital.getRoomArraylist(),p,false);
               }
               break;

            case "vomit":
                if (pregnancyTest()){
                    log.info("Congratulations you are pregnant.");
                }else {
                    log.info("Not pregnant, something you ate was bad.");
                }
                break;
            case "pregnant":
                birth();
                break;

            default:
                log.info("We cannot get a diagnosis for those symptoms.");
                break;


        }
    }
    }

