import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

public class GeneratorPensionFund {

    public static void main(String[] args) throws IOException {

        List<PensionFund> pensionFunds = generatePensionFunds();

        for (PensionFund pensionFund : pensionFunds) {
            System.out.println(pensionFund);
        }
    }

    private static List<PensionFund> generatePensionFunds() throws IOException {
        File fileForFund = new File("fileForGenerate/generatedPensionFunds.txt");
        FileReader fileReader = new FileReader(fileForFund);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<PensionFund> pensionFunds = new ArrayList<>();
        String string = null;
        while ((string = bufferedReader.readLine()) != null) {

            List<Worker> workers = GeneratorWorkers.generateWorkers();

            PensionFund pensionFund = new PensionFund(string, workers);
            pensionFunds.add(pensionFund);
        }
        return pensionFunds;

    }
}


