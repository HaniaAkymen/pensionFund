import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
import java.util.Random;

public class GeneratorPensionFund {

    public List<PensionFund> generatePensionFunds() throws IOException {
        File fileForFund = new File("fileForGenerate/generatedPensionFunds.txt");
        FileReader fileReader = new FileReader(fileForFund);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<PensionFund> pensionFunds = new ArrayList<>();
        String string = null;

        List<Worker> workers = GeneratorWorkers.generateWorkers();

        while ((string = bufferedReader.readLine()) != null) {
            PensionFund pensionFund = new PensionFund(string, new ArrayList<>());

            Random random = new Random();
            int numberOfWorkers = random.nextInt(workers.size());
            for (int i = 0; i < numberOfWorkers; i++) {
                pensionFund.getPersons().add(workers.get(i));

            }
            pensionFunds.add(pensionFund);

        }
        return pensionFunds;

    }
}


