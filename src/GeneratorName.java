import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorName {
    public static void main(String[] args) throws IOException {
        Random random = new Random();

        File fileForNamesM = new File("fileForGenerate/nameM.txt");
        File fileForNamesW = new File("fileForGenerate/nameW.txt");
        File file = new File("fileForGenerate/people.txt");

        FileReader fileReaderForNamesM = new FileReader(fileForNamesM);
        FileReader fileReaderForNamesW = new FileReader(fileForNamesW);
        FileWriter fileWriter = new FileWriter(file);

        BufferedReader bufferedReaderforNamesM = new BufferedReader(fileReaderForNamesM);
        BufferedReader bufferedReaderforNamesW = new BufferedReader(fileReaderForNamesW);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        List<String> namesM = bufferedReaderforNamesM.lines()
                .toList();
        List<String> namesW = bufferedReaderforNamesW.lines()
                .toList();


        for (int i = 0; i < 10000; i++) {
            AbleToCalculatePension.GenderType gender;

            if (random.nextBoolean()) {
                gender = AbleToCalculatePension.GenderType.MALE;
            } else {
                gender = AbleToCalculatePension.GenderType.FEMALE;
            }

            double minSalary = 800 + random.nextDouble() * (1500 - 800);

            int nameMRundomNumber = (int) random.nextInt(namesM.size());
            String nameM = namesM.get(nameMRundomNumber);

            int nameWRundomNumber = (int) random.nextInt(namesW.size());
            String nameW = namesW.get(nameWRundomNumber);

            double maxSalary = 1501 + random.nextDouble() * (10000 - 1501);

            List<String> allNames = new ArrayList<>();
            allNames.add(nameM);
            allNames.add(nameW);

            int nameRundomNumber = random.nextInt(allNames.size());
            String names = allNames.get(nameRundomNumber);

            String generatedString = names + " " + String.format("%.2f", minSalary) + " " + String.format("%.2f", maxSalary) + " " + gender;
            bufferedWriter.write(generatedString);
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
