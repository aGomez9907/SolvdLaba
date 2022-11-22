package hospital;

public class Patient extends Person{

    private String appointment;
    private boolean putInHospital;
    private String symptoms;
    private int weight;
    private int height;
    private boolean healthCareProvider;
    private boolean isMale;
    public Patient(String name, int age,boolean isMale, String nationality,String symptoms, boolean healthCareProvider, int weight, int height){
        setAge(age);
        setName(name);
        setNationality(nationality);
        this.healthCareProvider=healthCareProvider;
        this.weight=weight;
        this.height=height;
        this.symptoms=symptoms;
        this.isMale=isMale;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setPutInHospital(boolean putInHospital) {
        this.putInHospital = putInHospital;
    }


    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public boolean isMale() {
        return isMale;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public boolean isHealthCareProvider() {
        return healthCareProvider;
    }
}
