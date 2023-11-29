import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private int height;
    private int weight;
    private double money;
    private AbleToCalculatePension.GenderType gender;
    private double miniSalary;
    private double maxSalary;


    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;

    }

//    public Person(String name, miniSalary, maxSalary) {
//        this.name = name;
//        this.miniSalary = miniSalary;
//        this.maxSalary = maxSalary;
//
//    }

    public Person(){

    }
    public void getInfo() {
        System.out.println("Имя человека: " + name + ", " + "возраст: " + age + ", " + "рост: " + height + ", " + "вес: " + weight);
    }

    public void goToWork() {
        if (age < 18 || age > 70) {
            System.out.println(name + " отдыхает дома");
        } else {
            System.out.println(name + " рaботает");
        }
    }
    public void die(){
        System.out.println("Человек погиб");
    };
    public void die(int years){
        System.out.println("Человек погиб" + years + " лет");
    }

//    public abstract void die(int years);

    public double getMoney() {
        System.out.println("Количество денег " + money + " евро" + " у " + name);
        return money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public AbleToCalculatePension.GenderType getGender() {
        return gender;
    }

    public void setGender(AbleToCalculatePension.GenderType gender) {
        this.gender = gender;
    }

    public double getMiniSalary() {
        return miniSalary;
    }

    public void setMiniSalary(double miniSalary) {
        this.miniSalary = miniSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getAge() == person.getAge() && getHeight() == person.getHeight() && getWeight() == person.getWeight() && Double.compare(person.getMoney(), getMoney()) == 0 && Double.compare(person.getMiniSalary(), getMiniSalary()) == 0 && Double.compare(person.getMaxSalary(), getMaxSalary()) == 0 && Objects.equals(getName(), person.getName()) && getGender() == person.getGender();
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (name !=null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + height;
        result = 31 * result + weight;
        result = 31 * result + (int) money;
        result = 31 * result + (int) miniSalary;
        result = 31 * result + (int) maxSalary;
        result = 31 * result + (gender != null ? gender.toString().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", money=" + money +
                ", type=" + gender +
                ", miniSalary=" + miniSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}

