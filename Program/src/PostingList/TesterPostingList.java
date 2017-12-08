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
public class TesterPostingList {
    public static void main(String[] args) {
        String input = "11 5 3 1 3 11 4 1 2 2 2 9 15 1 5 2 7 8 10 14";
        PostingList postList = new PostingList(input);
        postList.dGap();
        System.out.println(postList.print());
        postList.physicalPostingList();
        System.out.println(postList.print());
    }
}