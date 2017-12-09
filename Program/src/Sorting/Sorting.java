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
    }
    
    public int[] getFrequency() {
        return this.frequency;
    } 

    public int[] getiD() {
        return this.iD;
    } 

    public void sort() {
//        for(int i=0;i<this.iD.length;i++) {
//            int temp = iD[i];
//            for(int a = i;a>0;a--) {
//                if(temp<this.iD[a-1]) {
//                    int temp2 = this.iD[a-1];
//                    this.iD[a-1] = temp;
//                    this.iD[a] = temp2;
//                    temp = this.iD[a-1];
//
//                    int tempFa1 = this.frequency[a];
//                    int tempFa2 = this.frequency[a--];
//                    this.frequency[a] = tempFa2;
//                    this.frequency[a--] = tempFa1;
//                }
//            }
//        }

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
    
    public String print(int[] input) {
        StringBuilder print = new StringBuilder();
        
        for(int i = 0;i<input.length;i++) {
            print.append(input[i]).append(" ");
        }
        
        return print.toString();
    }
}