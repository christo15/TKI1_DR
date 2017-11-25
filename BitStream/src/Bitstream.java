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
public class Bitstream {
    public int getDecimal(String biner) {
        int length = biner.length();
        int decimal = 0;
        for(int i = 0;i<length;i++) {
            char temp = biner.charAt((length-1)-i);
            if(temp == '1') {
                decimal += (int) Math.pow(2, i);
            }
        }
        return decimal;
    }
    
    public String getBit(int decimal) {
        StringBuilder biner = new StringBuilder();
        int temp = decimal;
        
        while(temp != 1) {
            int bit = temp%2;
            temp /= 2;
            biner.append(bit);
        }
        biner.append(temp);
        return biner.toString();
    }
}