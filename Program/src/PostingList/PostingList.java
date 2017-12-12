package PostingList;


import java.util.ArrayList;

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
public class PostingList {
    private int nDokumen;
    private ArrayList<PostingListEntry> postingListEntry;
    private String result;
    
    public PostingList(String input) {
        this.postingListEntry = new ArrayList<>();
        postingList(input);
    }
    
    public int getDokumen() {
        return this.nDokumen;
    }
    
    public ArrayList<PostingListEntry> getPostingListEntry() {
        return this.postingListEntry;
    }
    
    public String getResult() {
        return this.result;
    }
    
    private void postingList(String input) {
        StringBuilder result = new StringBuilder();
        String[] temp = input.split(" ");
        int i = 0;
        this.nDokumen = Integer.parseInt(temp[i]);
        i++;
        int nDokumen = this.nDokumen; //disimpan supaya nDokumen tidak hilang
        result.append(this.nDokumen).append(" ");
        while(nDokumen != 0) {
            int frek = Integer.parseInt(temp[i]);
            i++;
            int lengthDocId = Integer.parseInt(temp[i]);
            i++;
            result.append(frek).append(" ").append(lengthDocId).append(" ");
            int[] docId = new int[lengthDocId];
            for(int j = 0;j<lengthDocId;j++) {
                int tempDocId = Integer.parseInt(temp[i]);
                result.append(tempDocId).append(" ");
                docId[j] = tempDocId;
                i++;
                nDokumen--;
            }
            PostingListEntry temp1 = new PostingListEntry(frek, lengthDocId, docId);
            this.postingListEntry.add(temp1);
        }
        this.result = result.toString();
        //return result.toString();
    }
    
    public void dGap() {
        int length = this.postingListEntry.size();
        for(int i = 0;i<length;i++) {
            int[] postListEntry = this.postingListEntry.get(i).getDocId();
            if(postListEntry.length == 2) {
                int temp1 = postListEntry[0];
                int temp2 = postListEntry[1];
                temp2 = temp2 - temp1;
                postListEntry[1] = temp2;
                this.postingListEntry.get(i).setDocId(postListEntry);
            }
            else if(postListEntry.length>2) {
                for(int j = postListEntry.length-1;j>0;j--) {
                    int temp1 = postListEntry[j];
                    int temp2 = postListEntry[j-1];
                    temp1 = temp1 - temp2;
                    postListEntry[j] = temp1;
                }
                this.postingListEntry.get(i).setDocId(postListEntry);
            }
        }
    }
    
    public void physicalPostingList() {
        int length = this.postingListEntry.size();
        for(int i = 0;i<length;i++) {
            int[] postListEntry = this.postingListEntry.get(i).getDocId();
            if(postListEntry.length == 2) {
                int temp1 = postListEntry[0];
                int temp2 = postListEntry[1];
                temp2 = temp2 + temp1;
                postListEntry[1] = temp2;
                this.postingListEntry.get(i).setDocId(postListEntry);
            }
            else if(postListEntry.length>2) {
                for(int j = 0;j<postListEntry.length-1;j++) {
                    int temp1 = postListEntry[j];
                    int temp2 = postListEntry[j+1];
                    temp2 = temp1 + temp2;
                    postListEntry[j+1] = temp2;
                }
                this.postingListEntry.get(i).setDocId(postListEntry);
            }
        }
    }
    
    public String print() {
        StringBuilder print = new StringBuilder();
        
        print.append(this.nDokumen).append(" ");
        for(int i = 0;i<this.postingListEntry.size();i++) {
            PostingListEntry temp = this.postingListEntry.get(i);
            print.append(temp.getFrek()).append(" ").append(temp.getJdoc()).append(" ");
            int[] docId = temp.getDocId();
            for(int j = 0;j<temp.getJdoc();j++) {
                print.append(docId[j]).append(" ");
            }
        }
        
        return print.toString();
    }
}