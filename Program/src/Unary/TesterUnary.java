package Unary;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 4 Desember 2017
 * 
 */
public class TesterUnary {
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan Value : ");
        int value = sc.nextInt();
        
        UnaryEncoder unary = new UnaryEncoder();
        unary.write(value);
        System.out.println(unary.read());
    }
}