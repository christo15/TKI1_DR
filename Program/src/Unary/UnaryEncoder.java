package Unary;

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
public class UnaryEncoder {
    //nanti ganti byte[] jadi bitstream pada saat digabung dengan program lain
    //hanya untuk ngetes
    private byte[] stream;
    
    public byte[] getStream() {
        return this.stream;
    }
    
    public void write(int value) {
        if(value == 1) {
            this.stream = new byte[value];
            this.stream[0] = 0;
        }
        else if(value == 2) {
            this.stream = new byte[value];
            this.stream[0] = 1;
            this.stream[1] = 0;
        }
        else {
            this.stream = new byte[value];
            for(int i = 0;i<value - 1;i++) {
                this.stream[i] = 1;
            }
            this.stream[value-1] = 0;
        }
    }
    
    public int read() {
        int value = 0;
        int i = 0;
        while(this.stream[i] != 0) {
            value++;
            i++;
        }
        return value;
    }
    
    public String print() {
        StringBuilder print = new StringBuilder();
        for(int i = 0;i<this.stream.length;i++) {
            print.append(this.stream[i]);
        }
        return print.toString();
    }
}