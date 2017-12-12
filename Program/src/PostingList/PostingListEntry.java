package PostingList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 3 Desember 2017
 * 
 */
public class PostingListEntry {
    private int frek;
    private int[] docId;
    private int jdoc;
    
    public PostingListEntry(int frek, int jdoc, int[] docId) {
        this.frek = frek;
        this.jdoc = jdoc;
        this.docId = docId;
    }
    
    public int getFrek() {
        return this.frek;
    }
    
    public int getJdoc() {
        return this.jdoc;
    }
    
    public int[] getDocId() {
        return this.docId;
    }
    
    public void setDocId(int[] docId) {
        this.docId = docId;
    }
    
    public double getTF() {
        double pembilang = Math.log10(this.frek);
        double penyebut = Math.log10(2.0);
        return pembilang/penyebut;
    }
}