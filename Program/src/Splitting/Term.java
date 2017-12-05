package Splitting;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 8 Oktober 2017
 * 
 */
public class Term {
    private String resultParse;
    private int idDoc; //mungkin ada bagusnya pake string tapi untuk sekarang pake int dulu
    
    public Term(File file, int idDoc) throws IOException {
        this.resultParse = parse(read(file));
        this.idDoc = idDoc;
    }
    
    public int getIdDoc() {
        return this.idDoc;
    }
    
    public String getResultParse() {
        return this.resultParse;
    }
    
    private String[] read(File file) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new FileReader(file));
        
        StringBuilder sb = new StringBuilder();
        String line = input.readLine();

        while (line != null) {
            sb.append(line);
            line = input.readLine();
        }
        
        input.close();
        String text = sb.toString().toLowerCase();
        
        String result = "";
        for(int i = 0; i < text.length(); i++){       
            char character = text.charAt(i);
            int ascii = (int) character;
            if((ascii>=65 && ascii<=90) || (ascii>=97 && ascii<=122) || (ascii == 32)) {
                result += character;
            }
        }
        return result.split(" ");
    }
    
    private String parse(String[] text) {
        HashMap<String, Integer> result = new HashMap<>();
        for(int i = 0;i<text.length;i++) {
            String temp = text[i];
            if(result.containsKey(temp)) {
                int count = result.get(temp) + 1;
                result.put(temp, count);
            }
            else if(temp.equals("")) {
                
            }
            else {
                result.put(temp, 1);
            }
        }
        return result.toString();
    }
}