package BitStream;


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
        Bitstream bitStream = new Bitstream();
        System.out.print("Masukkan bit 0/1 or close : ");
        String input = sc.next();
        while(!(input.equals("close"))) {
            System.out.print("Masukkan bit 0/1 or close : ");
            bitStream.writeBit(Byte.parseByte(input));
            input = sc.next();
        }
        bitStream.close();
        System.out.println(bitStream.getDecimal(0));
        System.out.println(bitStream.getDecimal(1));
    }
}