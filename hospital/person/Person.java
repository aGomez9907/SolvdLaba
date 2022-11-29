package hospital.person;

abstract class Person {
    private String name;
    private int age;
    private String nationality;

    public Person(){

    }

    public Person(String name, String nationality, int age){
        if(age<0){
            this.age=-1;
        }
        this.name=name;
        this.age=age;
        this.nationality=nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }



    //methods

    public void startWork(){}

    public void stopWork(){}
}
