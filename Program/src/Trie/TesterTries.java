package Trie;


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
        String idDoc = sc.next();
        Trie tri = new Trie();
        tri.putString(term,frekuensi,idDoc);
        System.out.println("Frekuensi dari term " + term + " : " + Trie.getValue(term));
        System.out.println("Id Dokumen dari term " + term + " : " + Trie.getDocId(term));
    }
}