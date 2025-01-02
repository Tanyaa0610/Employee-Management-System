package empapp;           //package name h
public class Employee {  // classes banai hai
    private int id; //get aur set m use karne ke liye
    private String name;
    private double salary;
    private int age;
    public Employee(){
    }
    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {      //getter and setter method use hua h
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override        // overridding ek esa method h jis mai subclass define hoti h superclass mai se
    public String toString() {   //yeh string representaion h employee object ka
        return "Employee{" +    // yeh inplementation ko pura krta h employee object ki
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
