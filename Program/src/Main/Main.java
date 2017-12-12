package Main;

import Elias1.Elias;
import PostingList.PostingList;
//import PostingList.PostingListEntry;
import Splitting.*;
import Trie.NodeTrie;
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
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Step 1 : Mengambil semua file, parse semua term di setiap dokumen,\ndan memasukkan semua term tersebut ke dalam trie");
        System.out.println("PROCESS...");
        //Mengambil semua file, parse semua term di setiap dokumen, dan
        //memasukkan semua term tersebut ke dalam trie
        Parser parser = new Parser();
        Splitting.Process[] temp = parser.parseDoc();
        Trie trie = new Trie();
        for(int i = 0;i<temp.length;i++) {
            ArrayList<Term> term = temp[i].getArrayOfTerm();
            for(int j = 0;j<term.size();j++) {
                trie.putString(term.get(j));
            }
        }
        
        System.out.println();
        System.out.println("Step 2 : Menelusuri semua trie dan dijadikan posting list,\ndicari dgapnya, dan dimasukkan ke trie baru yang menyimpan hasil dgapnya");
        System.out.println("PROCESS...");
        //Menelusuri semua trie dan dijadikan posting list
        //Dicari dgapnya dan dimasukkan ke trie baru yang menyimpan hasil dgapnya
        NodeTrie tempNode = trie.getRoot();
        trie.process(tempNode);
        
        System.out.println();
        System.out.println("Step 3 : Input query dan menelusuri trie baru berdasarkan input query yang dimasukkan");
        //Input query
        //Menelusuri trie baru berdasarkan input query yang dimasukkan
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan query : ");
        String query = sc.next();
        String dgap = trie.searchDgap(query); //menyimpan hasil dgap yang ditemukan berdasarkan query yang dimasukkan
        
        System.out.println("Step 4 : Mengembalikan dgap ke physical posting list dan menghitung similaritasnya");
        //Mengembalikan dgap ke physical posting list
        //dan menghitung similaritinya
        PostingList postList = new PostingList(dgap);
        postList.physicalPostingList();
        
        //berikutnya tampilkan 10 dokumen terbaik
        
        
        System.out.println("Mau coba lagi? Yes or No");
        String answer = sc.next();
        if(answer.toLowerCase().equals("yes")) {
            while(true) {
                
            }
        }
        else {
            System.out.println("Apakah anda yakin? Yes or No");
            answer = sc.next();
            if(answer.toLowerCase().equals("no")) {
                while(true) {
                    
                }
            }
        }
//        //rendra dan vincent mengganggap jika yang dikerjakan christo udh selesai
//        //untuk 1 term
//        String input = "11 5 3 1 3 11 4 1 2 2 2 9 15 1 5 2 7 8 10 14";
//        //hasil dari tree dalam bentuk String
//        //yang nanti diolah ke posting list
//        PostingList postList = new PostingList(input);
//        postList.dGap();
//        String result = postList.getResult();
//        String[] tempResult = result.split(" ");
//        
//        Elias[] arrayOfByte = new Elias[input.length()];
//        for(int i = 0;i<tempResult.length;i++) {
//            arrayOfByte[i] = new Elias(Integer.parseInt(tempResult[i]));
//        }
//        //end process term
//        
//        String[] query1 = query.split(" ");
//        for(int i = 0;i<query1.length;i++) {
//            //Elias elias = Trie.getValue(query1[i]); //trie elias kristo
//            //ubah jadi desimal
//            //dapat d-gaps
//            //kembalikan lagi dari d-gaps ke postinglist asli agar bisa dihitung similaritynya
//        }
    }
}