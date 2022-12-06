package hospital.interfaces;
import hospital.person.Patient;

import java.util.Random;

public interface IGetExam {

    static boolean getExam(){
        Random random = new Random();
        return random.nextBoolean();
    }

    double measureHeight(Patient patient);

    double measureWeight(Patient patient);


}
