import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("fileForGenerate/people.txt");
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        long answer = bufferedReader.lines()
                .count();

        System.out.println(answer);







    }

}