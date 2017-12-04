package Splitting;


import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 20 September 2017
 * 
 */
public class Dokumen {
    public static File[] readDocuments() {
        File folder = new File("D:\\Data\\Rendra\\Kuliah\\Rendra\\Topik Khusus Informatika\\Tugas Akhir\\dataset reuters");
        File[] listOfFiles = folder.listFiles();
        
        return listOfFiles;
    }
}