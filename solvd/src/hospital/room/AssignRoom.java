package hospital.room;


import hospital.Hospital;
import hospital.person.Nurse;
import hospital.person.Patient;
import hospital.room.rooms.HospitalRoom;
import hospital.room.rooms.IntensiveCareRoom;
import hospital.room.rooms.PatientsRoom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.logging.Logger;

public class AssignRoom {

    private static Logger log = Logger.getLogger("hospital.room.AssignRoom");

    private static int i=0;

    public static void assignRoom(ArrayList<HospitalRoom> roomArrayList, Patient patient, boolean isIntensive){


                for (HospitalRoom r : roomArrayList){
                    if(!isIntensive){
                        if(r.getClass().getSimpleName().equals("PatientsRoom")){
                            PatientsRoom pr = (PatientsRoom) r;
                            if(pr.getPatient1() == null){

                                Nurse nurse= getNextNurse();
                                nurse.disinfectRoom();
                                nurse.makeBed();
                                nurse.prepareIVSolution();

                                pr.setPatient1(patient);
                                log.info("Patient set in room N°"+ pr.getRoomNumber());
                                return;
                            }else if(pr.getPatient2() == null){

                                Nurse nurse= getNextNurse();
                                nurse.disinfectRoom();
                                nurse.makeBed();
                                nurse.prepareIVSolution();

                                pr.setPatient2(patient);
                                log.info("Patient set in room N°"+ pr.getRoomNumber());
                                return;
                            }else log.info("No bed available in room N°" + pr.getRoomNumber());
                }

            }else{
                        if(r.getClass().getSimpleName().equals("IntensiveCareRoom")){
                            IntensiveCareRoom ir = (IntensiveCareRoom) r;
                            if(ir.getPatient()==null){

                                Nurse nurse= getNextNurse();
                                nurse.disinfectRoom();
                                nurse.makeBed();
                                nurse.prepareIVSolution();

                                ir.setPatient(patient);
                                log.info("Patient set in room N°"+ ir.getRoomNumber());
                                return;
                            }else log.info("No bed available in room N°" + ir.getRoomNumber());
                        }
                    }
        }

    }


    public static Nurse getNextNurse(){
        LinkedList<Nurse> nurses = Hospital.getNurseLinkedList();
        ListIterator<Nurse> listIterator = nurses.listIterator();

      if(nurses.listIterator(i).hasNext()){

          return nurses.get(i++);
      }else {
          i=1;
          return nurses.get(0);
      }



    }

}