import jdk.nashorn.api.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static javafx.scene.input.KeyCode.T;

public class TweetAnalyzer {

    private class Node {
        private String msg;
        private int priority;

        private Node(String m, int p) {
            msg = m;
            priority = p;
        }

        private void changePriority(int p) {
            priority = p;
        }
    }

    public static void main(String[] args) {
        //Process p = Runtime.getRuntime().exec("python mdfdsjf.py");

        File nathan = new File("losebags.txt");

        TreeMap<String, Integer> eric = new TreeMap<>(c);

//        TreeSet<String> emma = new TreeSet<>();


        try {
            Scanner jerry = new Scanner(nathan);
            while (jerry.hasNext()) {
                String coke = jerry.next();
                System.out.println(coke);
                if (eric.get(coke) == null) {
                    eric.put(coke, 1);
                } else {
                    eric.put(coke, eric.remove(coke) + 1);
                }
                System.out.println(eric.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found! LOSEBAG");
        }


    }
}
