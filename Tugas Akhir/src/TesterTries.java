
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
        String input = sc.next();
        System.out.print("Frekuensi : ");
        int data = sc.nextInt();
        Trie tri = new Trie();
        tri.putString(input,data);
        System.out.println(tri.getValue(input));
    }
}