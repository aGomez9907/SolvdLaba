package hospital.interfaces;

import hospital.person.Patient;

public interface IDiagnostic extends IGetExam {



    void getDiagnostic(Patient patient);

}
