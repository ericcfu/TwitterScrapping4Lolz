import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @source https://alvinalexander.com/java/edu/pj/pj010016
 */
public class JavaRunPythonTest {

    public static void main(String args[]) {
        String s = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("py webscraperV1.py");
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                list.add(s);
            }
            
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static List<String> getTweets(String twitterHandle) {
        String s = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            int num = 10;
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec("py webscraperV1.py " + twitterHandle + " " + num);
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                list.add(s);
            }
            
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            
            //System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            //System.exit(-1);
        }
        return list;
    }
}