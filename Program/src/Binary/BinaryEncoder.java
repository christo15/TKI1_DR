package Binary;

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
public class BinaryEncoder {
    //nanti ganti byte[] jadi bitstream pada saat digabung dengan program lain
    //hanya untuk ngetes
    private byte[] stream;
    
    public void write(int value, int jumlahBit) {
        this.stream = new byte[jumlahBit];
        makeBit(value);
    }
    
    public int read(int jumlahBit) {
        int value = getDecimal(this.stream, jumlahBit);
        return value;
    }
    
    private void makeBit(int value) {
        int temp = value;
        int i = 0;
        
        while(temp != 1) {
            int bit = temp%2;
            this.stream[i] = (byte) bit;
            temp /= 2;
            i++;
        }
        
        this.stream[i] = (byte) temp;
    }
    
    private int getDecimal(byte[] bit, int jumlahBit) {
        int decimal = 0;
        for(int i = 0;i<jumlahBit;i++) {
            if(bit[i] == 1) {
                decimal += (int) Math.pow(2, jumlahBit-i);
            }
        }
        return decimal;
    }
}