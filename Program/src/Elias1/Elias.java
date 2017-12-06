/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elias1;

import Binary.BinaryEncoder;
import Unary.UnaryEncoder;

/**
 *
 * @author Rendra
 * @version 6 Desember 2017
 * 
 */
public class Elias {
    private UnaryEncoder unary;
    private BinaryEncoder binary;
    private int decimal;
    private byte[] elias;
    
    public Elias(int decimal) {
        this.unary = new UnaryEncoder();
        this.binary = new BinaryEncoder();
        this.decimal = decimal;
        makeElias();
    }
    
    public byte[] getElias() {
        return this.elias;
    }
    
    private void makeElias() {
        int n = 0;
        while(this.decimal - ((int) Math.pow(2, n)) >= 0) {
            n++;
        }
        if(n != 0) {
            n--;
        }
        
        int m = this.decimal - ((int) Math.pow(2, n));
        this.unary.write(n+1);
        byte[] resultUnary = this.unary.getStream();
        
        this.binary.write(m, n);
        byte[] resultBinary = this.binary.getStream();
        
        int length = resultUnary.length + resultBinary.length;
        this.elias = new byte[length];
        
        for(int i = 0;i<resultUnary.length;i++) {
            this.elias[i] = resultUnary[i];
        }
        
        for(int i = 0;i<resultBinary.length;i++) {
            this.elias[(resultUnary.length) + i] = resultBinary[i];
        }
    }
    
    public int backToDecimal() {
        int n = this.unary.read();
        int resultUnary = (int) Math.pow(2,n);
        int resultBinary = this.binary.read(this.elias.length-this.unary.getStream().length);
        return resultUnary + resultBinary;
    }
    
    public String print() {
        StringBuilder print = new StringBuilder();
        for(int i = 0;i<this.elias.length;i++) {
            print.append(this.elias[i]);
        }
        return print.toString();
    }
}