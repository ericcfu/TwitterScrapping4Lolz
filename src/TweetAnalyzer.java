
import java.util.*;

public class TweetAnalyzer {

    TreeMap<String, Integer> wordMap;
    TreeMap<Integer, Integer> lengthMap;
    TreeMap<String, Integer> linkMap;
    TreeMap<String, Integer> mentionMap;
    TreeMap<String, Integer> tagMap;
    TreeSet<String> wordSet = new TreeSet<>();


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
        linkMap = new TreeMap<>();
        mentionMap = new TreeMap<>();
        tagMap = new TreeMap<>();

        read("MAC");
    }

    public TreeMap<String, Integer> getWordMap() {
        return wordMap;
    }

    public TreeMap<Integer, Integer> getLengthMap() {
        return lengthMap;
    }

    public TreeMap<String, Integer> getLinkMap() {
        return linkMap;
    }

    public TreeMap<String, Integer> getMentionMap() {
        return mentionMap;
    }

    public TreeMap<String, Integer> getTagMap() {
        return tagMap;
    }

    public TreeSet<String> getWordSet() {
        return wordSet;
    }

    public static void main(String[] args) {

    }

    public static void main(String os) {
        read(os);
    }

    private static TreeMap<String, Integer> read(String os) {

        TweetAnalyzer analyzer = new TweetAnalyzer();

        List<String> tweets = TweetFetchInterface.getTweets("BarackObama", 200, os);

        for (int i = 0; i < tweets.size(); i += 1) {
            Scanner sc = new Scanner(tweets.get(i));
            while (sc.hasNext()) {
                String word = sc.next();
                if (word.contains("http")) {

                } else {
                    analyzer.readWord(word, analyzer);
                }
            }
        }

        System.out.println("wordMap: " + analyzer.wordMap);
        System.out.println("lengthMap: " + analyzer.lengthMap);

        return analyzer.wordMap;
    }

    private void readWord(String word, TweetAnalyzer analyzer) {
        word = cleanWord(word);
        if (!analyzer.lengthMap.containsKey(word.length())) {
            analyzer.lengthMap.put(word.length(), 1);
        } else {
            analyzer.lengthMap.put(word.length(), analyzer.lengthMap.remove(word.length()) + 1);
        }
        if (!analyzer.wordSet.contains(word)) {
            analyzer.wordMap.put(word, 1);
            analyzer.wordSet.add(word);
        } else {
            analyzer.wordMap.put(word, analyzer.wordMap.remove(word) + 1);
        }
    }

    private String cleanWord(String word) {
        return word.replaceAll("\\p{P}", "");
    }

}
