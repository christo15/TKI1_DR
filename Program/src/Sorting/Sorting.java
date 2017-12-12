/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author Rendra
 * @version 9 Desember 2017
 * 
 */
public class Sorting {
    private int[] frequency;
    private int[] iD;

    public Sorting(int[] iD, int[] frequency) {
        this.frequency = frequency;
        this.iD = iD;
        sort();
    }
    
    public int[] getFrequency() {
        return this.frequency;
    } 

    public int[] getiD() {
        return this.iD;
    } 

    private void sort() {
        for(int i = 1;i<this.frequency.length;i++) {
            int temp = this.frequency[i];
            for(int a = i;a>0;a--) {
                if(temp>this.frequency[a-1]) {
                    int temp2 = this.frequency[a-1];
                    this.frequency[a-1] = temp;
                    this.frequency[a] = temp2;
                    temp = this.frequency[a-1];

                    int tempId1 = this.iD[a];
                    int tempId2 = this.iD[a-1];
                    this.iD[a] = tempId2;
                    this.iD[a-1] = tempId1;
                }
                else if(temp == this.frequency[a-1]) {
                    int tempId1 = this.iD[a];
                    int tempId2 = this.iD[a-1];
                    if(tempId1<=tempId2) {
                        this.iD[a] = tempId2;
                        this.iD[a-1] = tempId1;
                    }
                    else {
                        this.iD[a] = tempId1;
                        this.iD[a-1] = tempId2;
                    }
                }
            }
        }
    }
    
    public String printResult() {
        StringBuilder print = new StringBuilder();
        //print.append(this.iD.length).append(" ");
        int dokumen = 1; //variable untuk menyimpan banyak dokumen dengan frekuensi yang sama
        
        for(int i = 0;i<this.iD.length;i++) {
            int temp1 = this.frequency[i];
            int temp2 = 0;
            if(i != this.iD.length-1) {
                temp2 = this.frequency[i+1];
            }
            if(temp1 == temp2) {
                dokumen++;
            }
            else {
                print.append(temp1).append(" ").append(dokumen).append(" ");
                for(int j = i-(dokumen-1);j<dokumen+(i-(dokumen-1));j++) {
                    print.append(this.iD[j]).append(" ");
                }
                dokumen = 1;
            }
        }
        
        return print.toString();
    }
    
    public String print(int[] input) {
        StringBuilder print = new StringBuilder();
        
        for(int i = 0;i<input.length;i++) {
            print.append(input[i]).append(" ");
        }
        
        return print.toString();
    }
}