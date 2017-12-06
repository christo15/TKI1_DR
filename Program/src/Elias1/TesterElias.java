/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elias1;

import java.util.Scanner;

/**
 *
 * @author Rendra
 * @version 6 Desember 2017
 * 
 */
public class TesterElias {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan input decimal : ");
        int decimal = sc.nextInt();
        Elias elias = new Elias(decimal);
        System.out.println("Hasil Elias Gamma : " + elias.print());
        System.out.println("Back to Decimal : " + elias.backToDecimal());
    }
}