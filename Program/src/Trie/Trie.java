package Trie;

import Splitting.Term;


/**
 * 
 * @author Rendra
 * @version 26 September 2017
 * 
 */

public class Trie {
    private static NodeTrie root;

    public Trie() {
        root = new NodeTrie();
    }

    public static void putString(Term data) {
        NodeTrie tempNode = root;
        int length = data.getKata().length();
        String kata = data.getKata();
        for(int a = 0; a<length;a++) {
            String temp = kata.charAt(a)+"";
            int num = getNum(temp);
            tempNode = tempNode.getNext(num);
        }
        tempNode.setData(data);
    }

    public static Term getValue(String term) {
        NodeTrie tempNode =root;
        for(int a = 0; a<term.length();a++) {
            String temp = term.charAt(a)+"";
            int num = getNum(temp);
            tempNode = tempNode.getNext(num);
        }
        String kata = tempNode.getKata();
        int frekuensi = tempNode.getFrekuensi();
        int docId = tempNode.getDocId();
        Term data = new Term(kata, frekuensi, docId);
        return data;
    }

    private static int getDocId(String term) {
        NodeTrie tempNode =root;
        for(int a = 0; a<term.length();a++) {
            String temp = term.charAt(a)+"";
            int num = getNum(temp);
            tempNode = tempNode.getNext(num);
        }
        return tempNode.getDocId();
    }
    
    public static int getNum(String input) {
        int number = 0;
        switch(input.toLowerCase()) {
            case "a" : number = 0;break;
            case "b" : number = 1;break;
            case "c" : number = 2;break;
            case "d" : number = 3;break;
            case "e" : number = 4;break;
            case "f" : number = 5;break;
            case "g" : number = 6;break;
            case "h" : number = 7;break;
            case "i" : number = 8;break;
            case "j" : number = 9;break;
            case "k" : number = 10;break;
            case "l" : number = 11;break;
            case "m" : number = 12;break;
            case "n" : number = 13;break;
            case "o" : number = 14;break;
            case "p" : number = 15;break;
            case "q" : number = 16;break;
            case "r" : number = 17;break;
            case "s" : number = 18;break;
            case "t" : number = 19;break;
            case "u" : number = 20;break;
            case "v" : number = 21;break;
            case "w" : number = 22;break;
            case "x" : number = 23;break;
            case "y" : number = 24;break;
            case "z" : number = 25;break;
            default : number = -1; break;
        }
        return number;
    }
}