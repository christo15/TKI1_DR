package Main;

import Elias1.Elias;
import PostingList.PostingList;
import PostingList.PostingListEntry;
import Splitting.*;
import Trie.Trie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 8 Desember 2017
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        Splitting.Process[] temp = parser.parseDoc();
        //System.out.println(temp[0].print());
        Trie tree1 = new Trie();
        ArrayList<Term> term = temp[0].getArrayOfTerm();
        for(int i = 0;i<term.size();i++) {
            Trie.putString(term.get(i));
        }
        
        //rendra dan vincent mengganggap jika yang dikerjakan christo udh selesai
        //untuk 1 term
        String input = "11 5 3 1 3 11 4 1 2 2 2 9 15 1 5 2 7 8 10 14";
        //hasil dari tree dalam bentuk String
        //yang nanti diolah ke posting list
        PostingList postList = new PostingList(input);
        postList.dGap();
        String result = postList.getResult();
        String[] tempResult = result.split(" ");
        
        Elias[] arrayOfByte = new Elias[input.length()];
        for(int i = 0;i<tempResult.length;i++) {
            arrayOfByte[i] = new Elias(Integer.parseInt(tempResult[i]));
        }
        //end process term
        
        //menangani query input
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan query : ");
        String query = sc.next();
        
        String[] query1 = query.split(" ");
        for(int i = 0;i<query1.length;i++) {
            //Elias elias = Trie.getValue(query1[i]); //trie elias kristo
            //ubah jadi desimal
            //dapat d-gaps
            //kembalikan lagi dari d-gaps ke postinglist asli agar bisa dihitung similaritynya
        }
        
        
        //berikutnya tampilkan 10 dokumen terbaik
    }
}