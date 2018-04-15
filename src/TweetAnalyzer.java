
import java.util.*;

public class TweetAnalyzer {

    public static void main(String[] args) {
        read("MAC");
    }

    public static void main(String os) {
        read(os);
    }

    private static void read(String os) {

        List<String> tweets = TweetFetchInterface.getTweets("BarackObama", 10, os);
        Comparator<String> c1 = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.length() == o1.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
        };

        Comparator<Integer> c2 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        TreeMap<String, Integer> wordMap = new TreeMap<>(c1);
        TreeMap<Integer, Integer> lengthMap = new TreeMap<>(c2);
        TreeSet<String> wordSet = new TreeSet<>();

        for (int i = 0; i < tweets.size(); i += 1) {
            Scanner sc = new Scanner(tweets.get(i));
            while (sc.hasNext()) {
                String word = sc.next();
                if (!word.contains("http")) {
                    System.out.println("Adding string: " + word);
                    if (!lengthMap.containsKey(word.length())) {
                        lengthMap.put(word.length(), 1);
                    } else {
                        lengthMap.put(word.length(), lengthMap.remove(word.length()) + 1);
                    }
                    if (!wordSet.contains(word)) {
                        wordMap.put(word, 1);
                        wordSet.add(word);
                    } else {
                        wordMap.put(word, wordMap.remove(word) + 1);
                    }
                }
            }
        }



//        for (int i = 0; i < wordMap.size(); i += 1) {
//
//        }
        System.out.println("wordMap: " + wordMap);
        System.out.println("lengthMap: " + lengthMap);
    }

    /*

    private static void read() {

        //Process p = Runtime.getRuntime().exec("python mdfdsjf.py");
//        List<String> tweets = TweetFetchInterface.getTweets("JerryBearySong");
        File nathan = new File("losebags.txt");
        Comparator<String> c1 = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.length() == o1.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
        };

        Comparator<Integer> c2 = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        TreeMap<String, Integer> wordMap = new TreeMap<>(c1);
        TreeMap<Integer, Integer> lengthMap = new TreeMap<>(c2);
        TreeSet<String> wordSet = new TreeSet<>();

        try {
            Scanner jerry = new Scanner(nathan);
            while (jerry.hasNext()) {
                String word = jerry.next();
                System.out.println("Adding string: " + word);
                if (!lengthMap.containsKey(word.length())) {
                    lengthMap.put(word.length(), 1);
                } else {
                    lengthMap.put(word.length(), lengthMap.remove(word.length()) + 1);
                }
                if (!wordSet.contains(word)) {
                    wordMap.put(word, 1);
                    wordSet.add(word);
                } else {
                    wordMap.put(word, wordMap.remove(word) + 1);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found! LOSEBAG");
        }

        System.out.println("wordMap: " + wordMap);
        System.out.println("lengthMap: " + lengthMap);
    }

    */
}
