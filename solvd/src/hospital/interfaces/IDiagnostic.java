package hospital.interfaces;

import hospital.Hospital;
import hospital.person.Patient;

public interface IDiagnostic extends IGetExam {


    void getDiagnostic(Patient patient, Hospital hospital);

}
