
// https://leetcode.com/problems/top-k-frequent-words/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {

    static class MyMap extends HashMap<String, Integer> implements Comparable {

        @Override
        public int compareTo(Object o) {
            // TODO Auto-generated method stub

            return 0;
        }

    }

    public static List<String> topKFrequent(String[] words, int k) {


        // this [entries] will calculate all words freq
        HashMap<String, Integer> entries = new HashMap<String, Integer>();
        for (String s : words) {
            entries.put(s, entries.getOrDefault(s, 0) + 1);
        }

        // this [sortedEntries] will store all words according to their freq
        HashMap<Integer, PriorityQueue<String>> sortedEntries = new HashMap<>();

        // this queue will store and sort the all numbers in reverse order
        PriorityQueue<Integer> sortedValues = new PriorityQueue<Integer>(
                Collections.reverseOrder());

        
        for (String key : entries.keySet()) {
            int freq = entries.get(key);
            if (!sortedEntries.containsKey(freq)) {
                sortedValues.add(freq);
            }
            PriorityQueue<String> queue = sortedEntries.getOrDefault(freq, new PriorityQueue<>());
            queue.add(key);
            sortedEntries.put(freq, queue);
        }


        List<String> list = new ArrayList<>();
        while (!sortedValues.isEmpty()) {
            int i = sortedValues.poll();
            PriorityQueue<String> q = sortedEntries.get(i);
            while (!q.isEmpty()) {
                list.add(q.poll());
                if (list.size() == k) {
                    return list;
                }
            }
        }

        return list;

    }
    // public List<String> topKFrequent(String[] words, int k) {
    //     // calculate frequency of each word
    //     Map<String, Integer> freqMap = new HashMap<>();
    //     for(String word : words) {
    //         freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
    //     }
    //     // build the buckets
    //     TrieNode[] count = new TrieNode[words.length + 1];
    //     for(String word : freqMap.keySet()) {
    //         int freq = freqMap.get(word);
    //         if(count[freq] == null) {
    //             count[freq] = new TrieNode();
    //         }
    //         addWord(count[freq], word);
    //     }
    //     // get k frequent words
    //     List<String> list = new LinkedList<>();
    //     for(int f = count.length - 1; f >= 1 && list.size() < k; f--) {
    //         if(count[f] == null) continue;
    //         getWords(count[f], list, k);
    //     }
    //     return list;
    // }
    
    // private void getWords(TrieNode node, List<String> list, int k) {
    //     if(node == null) return;
    //     if(node.word != null) {
    //         list.add(node.word);
    //     }
    //     if(list.size() == k) return;
    //     for(int i = 0; i < 26; i++) {
    //         if(node.next[i] != null) {
    //             getWords(node.next[i], list, k);
    //         }
    //     }
    // }
    
    // private boolean addWord(TrieNode root, String word) {
    //     TrieNode curr = root;
    //     for(char c : word.toCharArray()) {
    //         if(curr.next[c - 'a'] == null) {
    //             curr.next[c - 'a'] = new TrieNode();
    //         }
    //         curr = curr.next[c - 'a'];
    //     }
    //     curr.word = word;
    //     return true;
    // }
    
    // class TrieNode {
    //     TrieNode[] next;
    //     String word;
    //     TrieNode() {
    //         this.next = new TrieNode[26];
    //         this.word = null;
    //     }
    // }
    public static void main(String[] args) {
        String[] words = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
        List<String> result = topKFrequent(words, 4);
        System.out.print(Arrays.toString(result.toArray()));
    }
}
