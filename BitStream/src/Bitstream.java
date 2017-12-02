
import java.util.ArrayList;

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
    private ArrayList<Integer> data;
    private byte[] buffer; //berukuran 8 elemen, digunakan untuk memudahkan proses penulisan/pembacaan
    private int idxBuffer; //index berikutnya pada buffer yang akan ditulis/dibaca
    private int idxData; //byte berikutnya yang akan dipindahkan ke buffer pada mode read
    
    public Bitstream() {
        this.buffer = new byte[8];
        for(int i = 0;i<8;i++) {
            this.buffer[i] = 0;
        }
        this.data = new ArrayList<>();
        this.idxBuffer = 0;
        this.idxData = 0;
    }
    
    public Bitstream(byte[] input) {
        this.buffer = input;
        this.data = new ArrayList<>();
        this.idxBuffer = 0;
        this.idxData = 0;
    }
    
    public void writeBit(byte bit) {
        if(this.idxBuffer<8) {
            this.buffer[this.idxBuffer] = bit;
            this.idxBuffer++;
        }
        else {
            close();
            this.idxBuffer = 0;
            this.buffer[this.idxBuffer] = bit;
            this.idxData++;
        }
    }
    
    public byte readBit() {
        byte bit = this.buffer[this.idxBuffer];
        this.idxBuffer++;
        return bit;
    }
    
    /**
     * memindahkan isi buffer ke dalam data
     */
    public void close() {
        int decimal = getDecimal(this.buffer);
        this.data.add(decimal);
        this.idxData++;
        for(int i = 0;i<8;i++) {
            this.buffer[i] = 0;
        }
    }
    
    private int getDecimal(byte[] input) {
        byte[] bit = input;
        int decimal = 0;
        for(int i = 0;i<bit.length;i++) {
            if(bit[i] == 1) {
                decimal += (int) Math.pow(2, 7-i);
            }
        }
        return decimal;
    }
    
    public int getDecimal(int index) {
        return this.data.get(index);
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