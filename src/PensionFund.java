import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;


public class PensionFund {

    private String name;
    private boolean isState;
    private String creationData;
    private List<Worker> persons;


    public static Map<DayOfWeek, Boolean> workDays = createWorkDays();

    public static Map<DayOfWeek, Boolean> createWorkDays() {
        Map<DayOfWeek, Boolean> workDays = new HashMap<>();
        workDays.put(DayOfWeek.MONDAY, true);
        workDays.put(DayOfWeek.THURSDAY, true);
        workDays.put(DayOfWeek.WEDNESDAY, true);
        workDays.put(DayOfWeek.TUESDAY, true);
        workDays.put(DayOfWeek.FRIDAY, true);
        workDays.put(DayOfWeek.SATURDAY, true);
        workDays.put(DayOfWeek.SUNDAY, true);
        return workDays;
    }

    public PensionFund(String name, boolean isState, String creationData, List<Worker> persons) {
        this.name = name;
        this.isState = isState;
        this.creationData = creationData;
        this.persons = persons;
    }
    public PensionFund(String name, List<Worker>persons){
        this.name = name;
        this.persons = persons;
    }

    public PensionFund(String statePensionFund, boolean isState, String creationData) {
    }

    public PensionFund(String string) throws IOException {
        String[] arrayPensionFunds = string.split(",");
        this.name = arrayPensionFunds[0];
        this.isState = Boolean.parseBoolean((arrayPensionFunds[1]));
        this.persons = GeneratorWorkers.generateWorkers();

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isState() {
        return isState;
    }

    public void setisState(boolean isState) {
        this.isState = isState;
    }

    public String getCreationData() {
        return creationData;
    }

    public void setCreationDate(String creationData) {
        this.creationData = creationData;
    }

    public List<Worker> getPersons() {
        return persons;
    }

    public void setPersons(List<Worker>persons) {
        this.persons = persons;
    }

    public static Map<DayOfWeek, Boolean> getWorkDays() {
        return workDays;
    }

    public static void setWorkDays(Map<DayOfWeek, Boolean> workDays) {
        PensionFund.workDays = workDays;
    }

    public void getInfo() {
        System.out.println("Информация о фонде: ");
        System.out.println("Название: " + name);
        System.out.println("Тип: " + (isState ? "Государственный" : "Не государственный"));
        System.out.println("Дата создания: " + creationData);

    }

    public double calculatePensionFor(AbleToCalculatePension obj) {
        if (isState && isWorkDayToday()) {
            return obj.calculatePension();
        } else {
            System.out.println("Деньги украли");
            return 0.0;
        }
    }

    private boolean isWorkDayToday() {
        LocalDate localDate = LocalDate.now();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        if (workDays == null) {
            return false;
        }
        return true;
    }

    public double calculateMedianPension() {
        if (persons == null || persons.size() == 0) {
            System.out.println("Вкладчики отсутствуют");
            return 0.0;
        }
        double sumOfPension = 0.0;
        for (Worker worker : persons) {
            sumOfPension += calculatePensionFor(worker);
        }
        return sumOfPension / persons.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PensionFund that)) return false;
        return isState() == that.isState() && Objects.equals(getName(), that.getName()) && Objects.equals(getCreationData(), that.getCreationData()) && Objects.equals(getPersons(), that.getPersons());
    }

    /*    public int hashCode() {
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
    }*/
    @Override
    public int hashCode() {
        return Objects.hash(getName(), isState(), getCreationData(), getPersons());
    }

    @Override
    public String toString() {
        return "PensionFund{" +
                "name='" + name + '\'' +
                ", isState=" + isState +
                ", persons=" + persons.size() +
                ", workDays=" + workDays +
                '}';
    }
}