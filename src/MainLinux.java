/**
 * Main class for launching the TweetAnalyzer from Linux System
 */
import javax.swing.JOptionPane;

public class MainLinux {
    public static void main(String[] args) {
        String handle = JOptionPane.showInputDialog("Twitter Handle:");
        String str_num_tweets = JOptionPane.showInputDialog("How many tweets would you like to analyze?");
        int num_tweets = Integer.parseInt(str_num_tweets);

        try {
            TweetAnalyzer a = new TweetAnalyzer(handle, num_tweets, "LINUX");
            JOptionPane.showMessageDialog(null, handle + "'s longest word is: " + a.getWordMap().firstEntry().getKey());
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}