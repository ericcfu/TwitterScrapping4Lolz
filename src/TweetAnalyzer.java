
import java.util.*;

public class TweetAnalyzer {

    TreeMap<String, Integer> wordMap;
    TreeMap<Integer, Integer> lengthMap;

    public TweetAnalyzer() {
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

        wordMap = new TreeMap<>(c1);
        lengthMap = new TreeMap<>(c2);
    }

    public static void main(String[] args) {
        read("MAC");
    }

    public static void main(String os) {
        read(os);
    }

    private static TreeMap<String, Integer> read(String os) {

        TweetAnalyzer analyzer = new TweetAnalyzer();

        List<String> tweets = TweetFetchInterface.getTweets("BarackObama", 100, os);

        TreeSet<String> wordSet = new TreeSet<>();

        for (int i = 0; i < tweets.size(); i += 1) {
            Scanner sc = new Scanner(tweets.get(i));
            while (sc.hasNext()) {
                String word = sc.next();
                if (!analyzer.lengthMap.containsKey(word.length())) {
                    analyzer.lengthMap.put(word.length(), 1);
                } else {
                    analyzer.lengthMap.put(word.length(), analyzer.lengthMap.remove(word.length()) + 1);
                }
                if (!wordSet.contains(word)) {
                    analyzer.wordMap.put(word, 1);
                    wordSet.add(word);
                } else {
                    analyzer.wordMap.put(word, analyzer.wordMap.remove(word) + 1);
                }

            }
        }

        System.out.println("wordMap: " + analyzer.wordMap);
        System.out.println("lengthMap: " + analyzer.lengthMap);

        return analyzer.wordMap;
    }

}
