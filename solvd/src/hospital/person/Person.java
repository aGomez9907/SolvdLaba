package hospital.person;

public abstract class Person {
    private String name;
    private int age;


    public Person(){

    }

    public Person(String name, int age){
        if(age<0){
            this.age=-1;
        }
        this.name=name;
        this.age=age;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }





    //METHODS
    // The idea here is to provide methods for people to start working e.g. at 8am and stop at 17pm


    public void startWork(){}

    public void stopWork(){}
}
