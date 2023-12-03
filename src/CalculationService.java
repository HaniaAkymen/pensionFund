import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CalculationService {

//    8) С полученными объектами сделайте следующие действия (с помощью стримов):

    public static void main(String[] args) throws IOException{

        GeneratorPensionFund generatorPensionFund = new GeneratorPensionFund();
        List<PensionFund> pensionFunds = generatorPensionFund.generatePensionFunds();


        //    а) Найдите фонд, где больше всего вложенцев

        PensionFund mostPopularFund = pensionFunds.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(fund -> fund.getPersons().size()))
                .orElse(null);
        System.out.println(mostPopularFund);


//    б) Найдите имя человека, у которого самая большая пенсия

        Worker nameBigestPensioner = pensionFunds.stream()
                .filter(Objects::nonNull)
                .flatMap(fund -> fund.getPersons().stream())
                .max(Comparator.comparingDouble(worker -> worker.calculatePension()))
                .orElse(null);
        System.out.println(nameBigestPensioner.getName());


 //   в) Найдите людей, которые стали жертвами "не государственных фондов"

        List<Worker> deceivedPersons = pensionFunds.stream()
                .filter(Objects::nonNull)
                .filter(fund-> !fund.isState())
                .flatMap(fund -> fund.getPersons().stream())
                .toList();

        System.out.println(deceivedPersons.size());

//    г) Найдите среднюю пенсию по фондам

        double averagePension = pensionFunds.stream()
                .filter(Objects::nonNull)
                .flatMap(fund -> fund.getPersons().stream())
                .mapToDouble(worker -> worker.calculatePension())
                .average()
                .orElse(0.0);

        System.out.println(averagePension);


//    е) Найдите наибольшую пенсию среди людей до 25

        Worker nameBigestPensioner25 = pensionFunds.stream()
                .filter(Objects::nonNull)
                .flatMap(fund -> fund.getPersons().stream())
                .filter(Person -> Person.getAge() < 25)
                .max(Comparator.comparingDouble(worker -> worker.calculatePension()))
                .orElse(null);
        System.out.println(nameBigestPensioner25.getName());


//    ё) Найдите самого молодого человека среди вложенцев гос. фондов
        Worker youngPersons = pensionFunds.stream()
                .filter(Objects::nonNull)
                .filter(fund-> fund.isState())
                .flatMap(fund -> fund.getPersons().stream())
                .min(Comparator.comparingInt(Worker::getAge))
                .orElse(null);

        System.out.println(youngPersons);



    }


}
