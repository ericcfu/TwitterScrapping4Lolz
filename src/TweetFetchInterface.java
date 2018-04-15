import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @source https://alvinalexander.com/java/edu/pj/pj010016
 * used source's inspiration and method of running python programs
 * within a java program as a terminal and input.
 * modified to fit the data return format and input format
 * for the project
 */
public class TweetFetchInterface {
    public static List<String> getTweets(String twitterHandle, int numTweets, String os) {
        String s = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            // using the Runtime exec method:
            Process p;
            if (os.equals("MAC")) {
                p = Runtime.getRuntime().exec("python3 tweet_fetcher.py " + twitterHandle + " " + numTweets);
            } else {
                p = Runtime.getRuntime().exec("py tweet_fetcher.py " + twitterHandle + " " + numTweets);
            }
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            // read the output from the command
            //System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                //System.out.println(s);
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