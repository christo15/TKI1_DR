package Splitting;


import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


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
public class Parser {
    public Process[] parseDoc() throws IOException {
        File[] file = Dokumen.readDocuments();
        Process[] process = new Process[file.length];
        for(int i = 0;i<process.length;i++) {
            process[i] = new Process(file[i], i+1);
        }
        return process;
    }
}