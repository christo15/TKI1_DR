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
    public int getDecimal(String bit) {
        int length = bit.length();
        int result = 0;
        for(int i = 0;i<length;i++) {
            char temp = bit.charAt((length-1)-i);
            if(temp == '1') {
                result += (int) Math.pow(2, i);
            }
        }
        return result;
    }
    
    public String getBit(int decimal) {
        StringBuilder result = new StringBuilder();
        int temp = decimal;
        
        while(temp != 1) {
            int bit = temp%2;
            temp = temp / 2;
            result.append(bit);
        }
        result.append(temp);
        return result.toString();
    }
}