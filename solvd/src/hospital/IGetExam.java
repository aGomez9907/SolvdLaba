package hospital;
import java.util.Random;

public interface IGetExam {

    static boolean getExam(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
