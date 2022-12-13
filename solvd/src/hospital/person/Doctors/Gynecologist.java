package hospital.person.Doctors;

import hospital.Hospital;
import hospital.exceptions.InvalidAgeException;
import hospital.exceptions.NameIsEmptyException;
import hospital.interfaces.IGetExam;
import hospital.person.Patient;
import hospital.room.AssignRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gynecologist extends Doctor {

    private static Logger LOGGER = LogManager.getLogger();

    public Gynecologist() {
    }

    public Gynecologist(String name, int age) throws InvalidAgeException, NameIsEmptyException {
        super(name, age);
    }


    public void birth(){
        LOGGER.info("The baby has been born.");
    }

    public boolean pelvicExam(){
        return IGetExam.getExam();
    }

    public boolean pregnancyTest(){return IGetExam.getExam();}

    @Override
    public void getDiagnostic(Patient p, Hospital hospital) {
        if(p.isMale()){
            LOGGER.info("The patient is male. Cannot be diagnosed.");
            return;
        }
        revision();

        LOGGER.info("The diagnosis is: ");
        switch (p.getSymptoms().toLowerCase()){

           case "pelvic exam":
               if(pelvicExam()){
                   LOGGER.info("Everything is fine, can go home.");
               }else {
                   LOGGER.info("Exams went bad, need to stay at hospital");
                   AssignRoom.assignRoom(hospital,p,false);
               }
               break;

            case "vomit":
                if (pregnancyTest()){
                    LOGGER.info("Congratulations you are pregnant.");
                }else {
                    LOGGER.info("Not pregnant, something you ate was bad.");
                }
                break;
            case "pregnant":
                birth();
                break;

            default:
                LOGGER.info("We cannot get a diagnosis for those symptoms.");
                break;


        }
    }
    }

