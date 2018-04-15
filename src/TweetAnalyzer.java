import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TweetAnalyzer {

    public static void main(String[] args) {
        //Process p = Runtime.getRuntime().exec("python mdfdsjf.py");

        File nathan = new File("losebags.txt");

        try {
            Scanner jerry = new Scanner(nathan);
            while (jerry.hasNext()) {
                System.out.println(jerry.next());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found! LOSEBAG");
        }


    }
}
