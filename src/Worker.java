import java.util.Objects;
import java.util.Random;

public class Worker extends Person implements AbleToCalculatePension {
    private final static double PERCENT_OF_PENSION = 0.25;
    private final static int MIN_AGE = 18;
    private final static int MAX_AGE = 67;

    private double miniSalary;
    private double maxSalary;

    public Worker(String name, int age, int height, int weight) {
        super(name, age, height, weight);

    }

    public Worker(String name, int age, int height) {
        super(name, age, height, 0);
    }

    public Worker() {
        super(null, 0, 0, 0);
    }

    public Worker(String string) {
        Random random = new Random();
        String[] arrayWorkers = string.split(" ");
        this.setName(arrayWorkers[0] + " " + arrayWorkers[1]);
        this.setAge(random.nextInt(MIN_AGE,MAX_AGE));
        this.miniSalary = Double.parseDouble(arrayWorkers[2]);
        this.maxSalary = Double.parseDouble(arrayWorkers[3]);
        this.setGender(AbleToCalculatePension.GenderType.valueOf(arrayWorkers[4]));


    }

    @Override
    public void die() {
        System.out.println("Этот человек не дожил до пенсии");
    }

//    @Override
//    public void die() {
//        int age = getAge();
//        int result = (age - 50) + (int) pension;
//        System.out.println("Этот пенсионер умер,он заработал " + result);
//    }

    @Override
    public void die(int years) {
        System.out.println(getName() + " - этот человек не доживет до пенсии и умрет через " + years + " лет");
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


    public double calculatePension() {
        double averageSalary = calculateAverage((int) miniSalary, (int) maxSalary);

        if (getGender() == null) {
            return 0.0;
        }
        if (getGender() == GenderType.MALE || getGender() == GenderType.MALE) {
            double pension = averageSalary * PERCENT_OF_PENSION;
            System.out.println("Пенсия " + getName() + " равна " + pension + " Euro");
            return pension;
        } else {
            double pension = (miniSalary / 2 + maxSalary * 2) / 2 * PERCENT_OF_PENSION;
            System.out.println("Пенсия " + getName() + " равна " + pension + " Euro");
            return pension;
        }
    }


    public static double calculateAverage(double first, double second) {
        return (first + second) / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return Double.compare(worker.miniSalary, miniSalary) == 0 && Double.compare(worker.maxSalary, maxSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                miniSalary,
                maxSalary);
    }

    @Override
    public String toString() {
        return "Worker{" +
                ", name=" + getName() +
                ", age=" + getAge() +
                "miniSalary=" + miniSalary +
                ", maxSalary=" + maxSalary +
                ", gender=" + getGender() +
                '}';
    }
}
