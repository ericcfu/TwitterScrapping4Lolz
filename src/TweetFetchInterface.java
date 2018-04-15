import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @source https://alvinalexander.com/java/edu/pj/pj010016
 */
public class TweetFetchInterface {
    public static List<String> getTweets(String twitterHandle, int num, String os) {
        String s = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            int num = 100;
            // using the Runtime exec method:
            if (os.equals("MAC")) {
                Process p = Runtime.getRuntime().exec("python3 tweet_fetcher.py " + twitterHandle + " " + num);
            } else {
                Process p = Runtime.getRuntime().exec("py tweet_fetcher.py " + twitterHandle + " " + num);
            }
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));
            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                list.add(s);
            }
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }
        return list;
    }
}