package hospital.person.Doctors;

import hospital.Hospital;
import hospital.interfaces.IGetExam;
import hospital.person.Patient;
import hospital.room.AssignRoom;

public class Gynecologist extends Doctor{

    public Gynecologist() {
    }

    public Gynecologist(String name, int age) {
        super(name, age);
    }


    public void birth(){
        System.out.println("The baby has been born.");
    }

    public boolean pelvicExam(){
        return IGetExam.getExam();
    }

    public boolean pregnancyTest(){return IGetExam.getExam();}

    @Override
    public void getDiagnostic(Patient p) {
        if(p.isMale()){
            System.out.println("The patient is male. Cannot be diagnosed.");
            return;
        }
        revision();

        System.out.println("The diagnosis is: ");
        switch (p.getSymptoms().toLowerCase()){

           case "pelvic exam":
               if(pelvicExam()){
                   System.out.println("Everything is fine, can go home.");
               }else {
                   System.out.println("Exams went bad, need to stay at hospital");
                   AssignRoom.assignRoom(Hospital.getRoomArraylist(),p,false);
               }
               break;

            case "vomit":
                if (pregnancyTest()){
                    System.out.println("Congratulations you are pregnant.");
                }else {
                    System.out.println("Not pregnant, something you ate was bad.");
                }
                break;
            case "pregnant":
                birth();
                break;

            default:
                System.out.println("We cannot get a diagnosis for those symptoms.");
                break;


        }
    }
    }

