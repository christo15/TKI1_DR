/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Splitting;

/**
 *
 * @author Rendra
 * @version 8 Desember 2017
 * 
 */
public class Term {
    private String kata;
    private int frekuensi;
    private int idDoc;
    
    public Term(String kata, int frekuensi, int idDoc) {
        this.kata = kata;
        this.frekuensi = frekuensi;
        this.idDoc = idDoc;
    }
    
    public String getKata() {
        return this.kata;
    }
    
    public int getFrekuensi() {
        return this.frekuensi;
    }
    
    public int getIdDoc() {
        return this.idDoc;
    }
}