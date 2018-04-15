
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class TweetAnalyzer {

    TreeMap<String, Integer> wordMap;
    TreeMap<Integer, Integer> lengthMap;
    TreeMap<String, Integer> linkMap;
    TreeMap<String, Integer> mentionMap;
    TreeMap<String, Integer> tagMap;
    TreeSet<String> wordSet = new TreeSet<>();
    TreeSet<String> linkSet = new TreeSet<>();
    TreeSet<String> mentionSet = new TreeSet<>();
    TreeSet<String> tagSet =new TreeSet<>();


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


    public TweetAnalyzer(String handle, int numTweets, String os) {
        wordMap = new TreeMap<>(c1);
        lengthMap = new TreeMap<>(c2);
        linkMap = new TreeMap<>();
        mentionMap = new TreeMap<>();
        tagMap = new TreeMap<>();

        List<String> tweets = TweetFetchInterface.getTweets(handle, numTweets, os);

        for (int i = 0; i < tweets.size(); i += 1) {
            Scanner sc = new Scanner(tweets.get(i));
            while (sc.hasNext()) {
                String word = sc.next();
                if (word.contains("http")) {
                    readLink(word);
                } else if (word.contains("#")) {
                    readTag(word);
                } else if (word.contains("@")) {
                    readMention(word);
                } else {
                    readWord(word);
                }
            }
        }
    }

    private void readLink(String word) {
        if (!linkSet.contains(word)) {
            linkMap.put(word, 1);
            linkSet.add(word);
        } else {
            linkMap.put(word, linkMap.remove(word) + 1);
        }
    }

    private void readTag(String word) {
        if (!tagSet.contains(word)) {
            tagMap.put(word, 1);
            tagSet.add(word);
        } else {
            tagMap.put(word, tagMap.remove(word) + 1);
        }
    }

    private void readMention(String word) {
        if (!mentionSet.contains(word)) {
            mentionMap.put(word, 1);
            mentionSet.add(word);
        } else {
            mentionMap.put(word, mentionMap.remove(word) + 1);
        }
    }

    private void readWord(String word) {
        word = cleanWord(word);
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

    private String cleanWord(String word) {
        return word.replaceAll("\\p{P}", "");
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
}
