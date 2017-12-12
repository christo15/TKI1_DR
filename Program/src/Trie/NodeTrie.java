package Trie;

import Splitting.Term;
import java.util.ArrayList;

/**
 *
 * @author Rendra
 * @version 26 September 2017
 *
 */
public class NodeTrie {

    //private Term data;
    //atribut frekuensi dan docId nantinya akan ada di objek
    //objek akan dibuat dari kelas yang ada di Splitting
    private NodeTrie[] trieNode;
    private ArrayList<Term> data;

    public NodeTrie() {
        trieNode = new NodeTrie[26];
        this.data = new ArrayList<>();
    }

    public void setData(Term input) {
        this.data.add(input);
    }

    public ArrayList<Term> getData() {
        return this.data;
    }

    public NodeTrie getNext(int input) {
        if (trieNode[input] == null) {
            trieNode[input] = new NodeTrie();
        }
        return trieNode[input];
    }

    public NodeTrie getNextNode(int input) {
        return trieNode[input];
    }
}
