/**
 * Main class for launching the TweetAnalyzer from Linux System
 */

import java.util.TreeMap;

import javax.swing.JOptionPane;

public class MainLinux {
    public static void main(String[] args) {
        String handle = JOptionPane.showInputDialog("Twitter Handle:");
        String str_num_tweets = JOptionPane.showInputDialog("How many tweets would you like to analyze?");
        int num_tweets = Integer.parseInt(str_num_tweets);

        try {
            TweetAnalyzer a = new TweetAnalyzer(handle, num_tweets, "LINUX");
            JOptionPane.showMessageDialog(null, handle + "'s longest word is: " + a.getWordMap().firstEntry().getKey());

            TreeMap<Integer, Integer> lm = a.getLengthMap();
            int totalSize = 0;
            int numberOfCountedTweets = 0;
            for (Integer key : lm.keySet()) {
                totalSize += lm.get(key) * key;
                numberOfCountedTweets += lm.get(key);
            }
            double avgWordLength = ((double) totalSize) / numberOfCountedTweets;

            JOptionPane.showMessageDialog(null, handle + "'s average word length is: " + avgWordLength);
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}