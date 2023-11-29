import java.util.Objects;

public class Workers extends Person implements AbleToCalculatePension{

    private double pension;

    public Workers(String name, int age, int height, int weight) {
        super(name, age, height, weight);

    }

    public double getPension() {
        return pension;
    }

    public void setPension(double pension) {
        this.pension = pension;
    }

    @Override
    public void die() {
        int age = getAge();
        int result = (age - 50) + (int) pension;
        System.out.println("Этот пенсионер умер,он заработал " + result);
    }

    @Override
    public void die(int years) {
        System.out.println(getName() + " - этот пенсионер умрет через " + years + " лет");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Workers workers = (Workers) o;

        return Double.compare(workers.pension, pension) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pension);
    }

    @Override
    public String toString() {
        return "Pensioner{" +
                "pension=" + pension +
                '}';
    }

    @Override
    public double calculatePension() {
        return 0;
    }
}


