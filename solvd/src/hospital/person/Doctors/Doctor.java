package hospital.person.Doctors;

import hospital.interfaces.IDiagnostic;
import hospital.person.Patient;
import hospital.person.Person;

import hospital.interfaces.IGetExam;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;




public class Doctor extends Person implements IGetExam, IDiagnostic {

    private static Logger LOGGER = LogManager.getLogger();
    //CONSTRUCTOR
    public Doctor() {

    }

    public Doctor(String name, int age) {
        super(name, age);
    }


    //METHODS
    public void revision() {
        LOGGER.info("Doctor " + super.getName() + " is examining the patient.");
    }

    public double measureTemperature() {
        return (Math.random() * (42 - 33) + 33);
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double measureHeight(Patient patient) {
        return patient.getHeight();
    }

    @Override
    public double measureWeight(Patient patient) {
        return patient.getWeight();
    }

    @Override
    public void getDiagnostic(Patient p) {

        revision();

        LOGGER.info("The diagnosis is: ");
        switch (p.getSymptoms().toLowerCase()){
            case "fever":
                if(measureTemperature()>37) {
                    LOGGER.info("Patient need to rest and ibuprofen every 8 hours.");
                    break;
                }else if(measureTemperature()<34) {
                    LOGGER.info("Patient has hypothermia, need to warm up.");
                    break;
                }else LOGGER.info("Everything fine.");
                break;
//            case "headache":
//
//            case "vomit":
//
//
//            case "broken bone":
//
//            case "decompensation":

            default:
                LOGGER.info("We cannot get a diagnosis for those symptoms.");
                break;


        }
    }
    }

