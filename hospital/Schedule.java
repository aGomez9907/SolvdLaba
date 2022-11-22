package hospital;

public class Schedule {
    private String date;
    private Doctor doctor;
    private Patient patient;
    public Schedule(String date,Doctor doctor,Patient patient){
        this.date=date;
        this.doctor = doctor;
        this.patient=patient;
    }

    public Patient getPatient() {
        return patient;
    }
}
