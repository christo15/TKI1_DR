package Trie;


/**
 * 
 * @author Rendra
 * @version 26 September 2017
 * 
 */

public class NodeTrie {
    private int data;
    private NodeTrie[] trieNode;

    public NodeTrie() {
        trieNode = new NodeTrie[26];
    }

    public int getData() {
        return data;
    } 

    public void setData(int input) {
        data = input;		
    }

    public NodeTrie getNext(int input) {
        if(trieNode[input] == null) {
            trieNode[input] = new NodeTrie();
        }
        return trieNode[input];
    }
}