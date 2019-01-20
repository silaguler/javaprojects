
import java.util.Scanner;
import java.io.File;

public class WordCount {

    public static void main(String[] args) throws Exception{
        File file = new File("adventuresofsherlock.txt");
        Scanner scanner = new Scanner(file);
        int wordCount = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            wordCount += line.split("").length;
            //System.out.println(line.split("").length);
        }
        System.out.println(wordCount);
    }

}
