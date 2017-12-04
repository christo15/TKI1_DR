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
    public Term[] parseDoc() throws IOException {
        File[] file = Dokumen.readDocuments();
        Term[] term = new Term[file.length];
        for(int i = 0;i<term.length;i++) {
            term[i] = new Term(file[i]);
        }
        return term;
    }
}