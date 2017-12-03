
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
    
    public PostingList() {
        this.postingListEntry = new ArrayList<>();
    }
    
    public String postingList(String input) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        this.nDokumen = input.charAt(i);
        i++;
        int temp = this.nDokumen;
        result.append(this.nDokumen);
        while(temp != 0) {
            int frek = input.charAt(i);
            i++;
            temp--;
            int lengthDocId = input.charAt(i);
            i++;
            temp--;
            result.append(frek).append(lengthDocId);
            int[] docId = new int[lengthDocId];
            for(int j = 0;j<lengthDocId;j++) {
                result.append(input.charAt(i));
                docId[j] = input.charAt(i);
                i++;
                temp--;
            }
            PostingListEntry temp1 = new PostingListEntry(frek, lengthDocId, docId);
            this.postingListEntry.add(temp1);
        }
        return result.toString();
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
                for(int j = 0;j<postListEntry.length-1;j--) {
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
        
        print.append(this.nDokumen);
        for(int i = 0;i<this.postingListEntry.size();i++) {
            PostingListEntry temp = this.postingListEntry.get(i);
            print.append(temp.getFrek()).append(temp.getJdoc());
            int[] docId = temp.getDocId();
            for(int j = 0;j<temp.getJdoc();j++) {
                print.append(docId[j]);
            }
        }
        
        return print.toString();
    }
}