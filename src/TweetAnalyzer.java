import jdk.nashorn.api.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static javafx.scene.input.KeyCode.T;

public class TweetAnalyzer {

    public class Node {
        private String msg;
        private int priority;

        public Node(String m, int p) {
            msg = m;
            priority = p;
        }

        private void changePriority(int p) {
            priority = p;
        }

        private int getPriority() {
            return priority;
        }
    }

    public static void main(String[] args) {
        read();
    }

    private static void read() {

        //Process p = Runtime.getRuntime().exec("python mdfdsjf.py");
        List<String> tweets = TweetFetchInterface.getTweets("JerryBearySong");
        File nathan = new File("losebags.txt");
        Comparator<String> c1 = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        };

        TreeMap<String, Integer> eric = new TreeMap<>(c1);
        TreeMap<Integer, Integer> sahai = new TreeMap<>();
        TreeSet<String> emma = new TreeSet<>();

        try {
            Scanner jerry = new Scanner(nathan);
            while (jerry.hasNext()) {
                String coke = jerry.next();
                System.out.println("Adding string: " + coke);
                if (!sahai.containsKey(coke.length())) {
                    sahai.put(coke.length(), 1);
                } else {
                    sahai.put(coke.length(), sahai.remove(coke.length()) + 1);
                }
                if (!emma.contains(coke)) {
                    eric.put(coke, 1);
                    emma.add(coke);
                } else {
                    eric.put(coke, eric.remove(coke) + 1);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found! LOSEBAG");
        }

        System.out.println("eric: " + eric);
        System.out.println("sahai: " + sahai);
    }
}
