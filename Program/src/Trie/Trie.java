package Trie;

import PostingList.PostingList;
import Sorting.Sorting;
import Splitting.Term;
import java.util.ArrayList;

/**
 *
 * @author Rendra
 * @version 26 September 2017
 *
 */
public class Trie {

    private NodeTrie root;
    private NodeTrieDgap droot;

    public Trie() {
        this.root = new NodeTrie();
    }

    public NodeTrie getRoot() {
        return this.root;
    }

    public void putString(Term data) {
        NodeTrie tempNode = root;
        int length = data.getKata().length();
        String kata = data.getKata();
        for (int a = 0; a < length; a++) {
            String temp = kata.charAt(a) + "";
            int num = getNum(temp);
            tempNode = tempNode.getNext(num);
        }
        tempNode.setData(data);
    }

    public ArrayList<Term> getValue(String term) {
        NodeTrie tempNode = root;
        for (int a = 0; a < term.length(); a++) {
            String temp = term.charAt(a) + "";
            int num = getNum(temp);
            tempNode = tempNode.getNext(num);
        }
        return tempNode.getData();
    }
    
    public void adv(NodeTrie input, NodeTrieDgap in, int index) {
        ArrayList<Term> result = input.getData();
        int[] idDoc = new int[result.size()];
        int[] frekuensi = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            idDoc[i] = result.get(i).getIdDoc(); //variable untuk menyimpan idDoc
            frekuensi[i] = result.get(i).getFrekuensi(); //variable untuk menyimpan frekuensi
        }
        Sorting sort = new Sorting(idDoc, frekuensi);
        String inputPostList = sort.printResult();
        PostingList postList = new PostingList(inputPostList);
        postList.dGap();
        String dGap = postList.print();
        in.setData(result.get(0).getKata(), dGap);
    }

    private void searchTrie(NodeTrie input, NodeTrieDgap in) {
        for (int i = 0; i < 26; i++) {
            NodeTrieDgap temp = in;
            if (input.getNextNode(i) != null) {
                searchTrie(input.getNextNode(i), temp.getNext(i));
            } else {
                adv(input, in, i);
            }
        }
    }

    public void process(NodeTrie input) {
        this.searchTrie(input, this.droot);
    }

    public String searchDgap(String input) {
        NodeTrieDgap temp = this.droot;
        for (int i = 0; i < input.length(); i++) {
            int x = this.getNum(input.charAt(i) + "");
            temp.getNextNode(x);
        }
        return temp.getDgap();
    }

    public int getNum(String input) {
        int number = 0;
        switch (input.toLowerCase()) {
            case "a":
                number = 0;
                break;
            case "b":
                number = 1;
                break;
            case "c":
                number = 2;
                break;
            case "d":
                number = 3;
                break;
            case "e":
                number = 4;
                break;
            case "f":
                number = 5;
                break;
            case "g":
                number = 6;
                break;
            case "h":
                number = 7;
                break;
            case "i":
                number = 8;
                break;
            case "j":
                number = 9;
                break;
            case "k":
                number = 10;
                break;
            case "l":
                number = 11;
                break;
            case "m":
                number = 12;
                break;
            case "n":
                number = 13;
                break;
            case "o":
                number = 14;
                break;
            case "p":
                number = 15;
                break;
            case "q":
                number = 16;
                break;
            case "r":
                number = 17;
                break;
            case "s":
                number = 18;
                break;
            case "t":
                number = 19;
                break;
            case "u":
                number = 20;
                break;
            case "v":
                number = 21;
                break;
            case "w":
                number = 22;
                break;
            case "x":
                number = 23;
                break;
            case "y":
                number = 24;
                break;
            case "z":
                number = 25;
                break;
            default:
                number = -1;
                break;
        }
        return number;
    }
}
