/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Sorting.Sorting;
import Splitting.Parser;
import Splitting.Term;
import Trie.NodeTrie;
import Trie.Trie;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Rendra_2
 */
public class Coba {

    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        Splitting.Process[] temp = parser.parseDoc();
        Trie trie = new Trie();
        for (int i = 0; i < 1; i++) {
            ArrayList<Term> term = temp[i].getArrayOfTerm();
            for (int j = 0; j < term.size(); j++) {
                trie.putString(term.get(j));
            }
        }

        NodeTrie tempNode = trie.getRoot();
        trie.process(tempNode);
        String input = "date";
        String dgap = trie.searchDgap(input);
        System.out.println(dgap);
    }
}
