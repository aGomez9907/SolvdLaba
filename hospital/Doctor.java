package hospital;

public class Doctor extends Person {


    private String specialty;
    public Doctor(String name, int age, String nationality,String specialty){
        setAge(age);
        setName(name);
        setNationality(nationality);
        this.specialty=specialty;
    }


}
