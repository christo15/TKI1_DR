package Trie;

import Splitting.Term;


/**
 * 
 * @author Rendra
 * @version 26 September 2017
 * 
 */

public class NodeTrie {
    private Term data;
    //atribut frekuensi dan docId nantinya akan ada di objek
    //objek akan dibuat dari kelas yang ada di Splitting
    private NodeTrie[] trieNode;

    public NodeTrie() {
        trieNode = new NodeTrie[26];
    }

    public int getFrekuensi() {
        return this.data.getFrekuensi();
    } 

    public int getDocId() {
        return this.data.getIdDoc();
    }
    
    public String getKata() {
        return this.data.getKata();
    }
    
    public void setData(Term data) {
        this.data = data;
    }

    public NodeTrie getNext(int input) {
        if(trieNode[input] == null) {
            trieNode[input] = new NodeTrie();
        }
        return trieNode[input];
    }
}