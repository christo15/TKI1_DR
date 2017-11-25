
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 25 November 2017
 * 
 */
public class TesterBitStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan biner : ");
        String bit = sc.next();
        Bitstream bitStream = new Bitstream();
        int result = bitStream.getDecimal(bit);
        System.out.println(result);
        System.out.println();
        System.out.println("Dikembalikan ke bentuk biner");
        System.out.println(bitStream.getBit(result));
    }
}