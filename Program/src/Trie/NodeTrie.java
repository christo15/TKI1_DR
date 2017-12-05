package Trie;


/**
 * 
 * @author Rendra
 * @version 26 September 2017
 * 
 */

public class NodeTrie {
    private int frekuensi;
    private String docId;
    //atribut frekuensi dan docId nantinya akan ada di objek
    //objek akan dibuat dari kelas yang ada di Splitting
    private NodeTrie[] trieNode;

    public NodeTrie() {
        trieNode = new NodeTrie[26];
    }

    public int getFrekuensi() {
        return frekuensi;
    } 

    public String getDocId() {
        return this.docId;
    }
    
    public void setData(int frekuensi, String docId) {
        this.frekuensi = frekuensi;
        this.docId = docId;
    }

    public NodeTrie getNext(int input) {
        if(trieNode[input] == null) {
            trieNode[input] = new NodeTrie();
        }
        return trieNode[input];
    }
}