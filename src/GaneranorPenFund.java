import java.io.*;
import java.util.List;
import java.util.Random;

public class GaneranorPenFund {
    public static void main(String[] args) throws IOException {

        File fileFund = new File("fileForGenerate/pensionFund.txt");
        File filePension = new File("fileForGenerate/generatedPensionFunds.txt");

        FileReader fileReaderForFund = new FileReader(fileFund);
        FileWriter filePensionWriter = new FileWriter(filePension);

        BufferedReader bufferedReaderforFund = new BufferedReader(fileReaderForFund);
        BufferedWriter bufferedWriter = new BufferedWriter(filePensionWriter);

        List<String> pensionFunds = bufferedReaderforFund.lines()
                .toList();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {

            String selectedFund = pensionFunds.get(random.nextInt(pensionFunds.size()));

            boolean isState = selectedFund.toLowerCase().contains("state");

            String generatedString = selectedFund + ", " + isState;

            bufferedWriter.write(generatedString);
            bufferedWriter.newLine();
            System.out.println(pensionFunds);

        }
        bufferedWriter.close();
        filePensionWriter.close();
        bufferedReaderforFund.close();
        fileReaderForFund.close();
    }

}
