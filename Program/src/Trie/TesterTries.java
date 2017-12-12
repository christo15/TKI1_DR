package Trie;


import Splitting.Term;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 23 Oktober 2017
 * 
 */

public class TesterTries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Text input : ");
        String term = sc.next();
        System.out.print("Frekuensi : ");
        int frekuensi = sc.nextInt();
        System.out.print("Id Dokumen : ");
        int idDoc = sc.nextInt();
        Trie tri = new Trie();
        Term data = new Term(term, frekuensi, idDoc);
        tri.putString(data);
        //System.out.println("Frekuensi dari term " + term + " : " + tri.getValue(term));
        //System.out.println("Id Dokumen dari term " + term + " : " + Trie.getDocId(term));
    }
}