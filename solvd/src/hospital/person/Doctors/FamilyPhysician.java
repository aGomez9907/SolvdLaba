package hospital.person.Doctors;

import hospital.Hospital;
import hospital.exceptions.InvalidAgeException;
import hospital.exceptions.NameIsEmptyException;
import hospital.interfaces.IGetExam;
import hospital.person.Patient;
import hospital.room.AssignRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FamilyPhysician extends Doctor {
    private static Logger LOGGER = LogManager.getLogger();

    public FamilyPhysician() {
    }

    public FamilyPhysician(String name, int age) throws InvalidAgeException, NameIsEmptyException {
        super(name, age);
    }

    public double measureHeight(Patient patient) {
        return patient.getHeight();
    }

    public double measureWeight(Patient patient) {
        return patient.getWeight();
    }


    @Override
    public void getDiagnostic(Patient p, Hospital hospital) {

        revision();

        LOGGER.info("The diagnosis is: ");
        switch (p.getSymptoms().toLowerCase()) {
            case "fever":
                if (measureTemperature() > 37) {
                    LOGGER.info("Patient need to rest and ibuprofen every 8 hours.");
                    break;
                } else if (measureTemperature() < 34) {
                    LOGGER.info("Patient has hypothermia, need to warm up.");
                    break;
                } else LOGGER.info("Everything fine.");
                break;
            case "examination":
                LOGGER.info("The patient weights " + p.getWeight() + "Kg and is " + p.getHeight() + "cm tall.");
                break;
            case "broken bone":
                if (IGetExam.getExam()) {
                    LOGGER.info("Open fracture, need to stay in hospital.");
                    AssignRoom.assignRoom(hospital, p, true);
                    break;
                } else LOGGER.info("Use a cast and get rest. Patient can go home");


            default:
                LOGGER.info("We cannot get a diagnosis for those symptoms.");
                break;


        }
    }
}
