/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author Rendra
 * @version 9 Desember 2017
 * 
 */
public class TesterSorting {
    public static void main(String[] args) {
        int[] id = {6, 5, 7, 4, 2, 3, 1};
        int[] frekuensi = {4, 3, 4, 2, 4, 3, 1};
        Sorting sort = new Sorting(id, frekuensi);
        System.out.println("Sebelum di sort :");
        System.out.println(sort.print(id));
        System.out.println(sort.print(frekuensi));
        System.out.println();
        sort.sort();
        System.out.println("Sesudah di sort :");
        System.out.println(sort.print(id));
        System.out.println(sort.print(frekuensi));
        System.out.println();
        System.out.println("Hasil untuk dimasukkan ke Posting List :");
        System.out.println(sort.printResult());
    }
}