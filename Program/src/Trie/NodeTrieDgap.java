package Trie;

import PostingList.PostingListEntry;
import Splitting.Term;
import java.util.ArrayList;

/**
 *
 * @author Rendra
 * @version 26 September 2017
 *
 */
public class NodeTrieDgap {

    //private Term data;
    //atribut frekuensi dan docId nantinya akan ada di objek
    //objek akan dibuat dari kelas yang ada di Splitting

    private NodeTrieDgap[] trieNode;
    private String term;
    private String dgap;
    //private int count = 0;

    public NodeTrieDgap() {
        trieNode = new NodeTrieDgap[26];
    }

    public void setData(String term ,String dgap) {
        this.dgap = dgap;
        this.term = term;
    }

    public String getDgap() {
        return this.dgap;
    }
    
    public String getTerm() {
        return this.term;
    }

    public NodeTrieDgap getNext(int input) {
        if (trieNode[input] == null) {
            trieNode[input] = new NodeTrieDgap();
        }
        return trieNode[input];
    }

    public NodeTrieDgap getNextNode(int input) {
        return trieNode[input];
    }
}