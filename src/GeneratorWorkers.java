import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorWorkers {

    public static List<Worker> generateWorkers() throws IOException {
        File fileWorkers = new File("fileForGenerate/people.txt");
        FileReader fileReader = new FileReader(fileWorkers);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str = null;

        List<Worker> workers = new ArrayList<>();

        while ((str = bufferedReader.readLine()) != null) {
            str = str.replace(",", ".");
            Worker worker = new Worker(str);
            workers.add(worker);
            System.out.println(worker);
        }
        return workers;
    }

    public static void main(String[] args) throws IOException {
        generateWorkers();
    }

}
