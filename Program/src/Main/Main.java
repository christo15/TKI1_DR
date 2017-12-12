package Main;

import Elias1.Elias;
import PostingList.PostingList;
import PostingList.PostingListEntry;
//import PostingList.PostingListEntry;
import Splitting.*;
import Trie.NodeTrie;
import Trie.Trie;
import VectorSpaceModel.VSM;
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
        for (int i = 0; i < temp.length; i++) {
            ArrayList<Term> term = temp[i].getArrayOfTerm();
            for (int j = 0; j < term.size(); j++) {
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
        String answer = "yes";
        while (answer.toLowerCase().equals("yes")) {
            System.out.println("Step 3 : Input query dan menelusuri trie baru berdasarkan input query yang dimasukkan");
            //Input query
            //Menelusuri trie baru berdasarkan input query yang dimasukkan
            Scanner sc = new Scanner(System.in);
            System.out.print("Masukkan query : ");
            String query = sc.next();
            System.out.println("PROCESS...");
            String dgap = trie.searchDgap(query); //menyimpan hasil dgap yang ditemukan berdasarkan query yang dimasukkan

            System.out.println();
            System.out.println("Step 4 : Mengembalikan dgap ke physical posting list");
            System.out.println("PROCESS...");
            //Mengembalikan dgap ke physical posting list
            PostingList postList = new PostingList(dgap);
            postList.physicalPostingList();

            System.out.println();
            System.out.println("Step 5 : Menghitung Similarity");
            System.out.println("PROCESS...");
            ArrayList<PostingListEntry> postListEntry = postList.getPostingListEntry();
            int length = postListEntry.size();
            double[] listOfVSM = new double[length];
            double IDF = postList.getIDF();
            for (int i = 0; i < postListEntry.size(); i++) {
                double TF = postListEntry.get(i).getTF();
                double vsm = VSM.getVSM(IDF, TF);
                listOfVSM[i] = vsm;
            }

            System.out.println();
            System.out.println("Step 6 : Menampilkan maksimal 10 dokumen terbaik");
            System.out.println("PROCESS...");
            System.out.println();
            for (int i = 1; i < listOfVSM.length; i++) {
                double tempVSM = listOfVSM[i];
                for (int a = i; a > 0; a--) {
                    if (tempVSM > listOfVSM[a - 1]) {
                        double tempVSM2 = listOfVSM[a - 1];
                        listOfVSM[a - 1] = tempVSM;
                        listOfVSM[a] = tempVSM2;
                        tempVSM = listOfVSM[a - 1];

                        int[] tempId1 = postListEntry.get(a).getDocId();
                        int[] tempId2 = postListEntry.get(a - 1).getDocId();
                        postListEntry.get(a).setDocId(tempId2);
                        postListEntry.get(a - 1).setDocId(tempId1);
                    }
                }
            }
            
            System.out.println("Dokumen terbaik :");
            //print dokumen yang sudah diurutkan berdasarkan vsm
            StringBuilder result = new StringBuilder();
            for(int i = 0;i<length;i++) {
                int[] docId = postListEntry.get(i).getDocId();
                result.append(i+1).append(". ");
                for(int j = 0;j<docId.length-1;j++) {
                    result.append(docId[j]).append(", ");
                }
                result.append(docId[length-1]).append("\n");
            }
            
            System.out.println();
            System.out.println("Apakah anda ingin mencari term kembali? Yes or No");
            answer = sc.next();
        }
    }
}
