package Binary;

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
public class TesterBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan value : ");
        int value = sc.nextInt();
        BinaryEncoder binary = new BinaryEncoder();
        binary.write(value, 3);
        System.out.println(binary.print());
        
        System.out.println(binary.read(3));
    }
}