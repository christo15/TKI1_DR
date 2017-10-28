
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 13 September 2017
 * 
 */
public class TesterSplitting {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
//        BufferedReader input = new BufferedReader(new FileReader("0.txt"));
//        BufferedWriter output = new BufferedWriter(new FileWriter("FileOutput.txt"));
//        
//        StringBuilder sb = new StringBuilder();
//        String line = input.readLine();
//
//        while (line != null) {
//            sb.append(line);
//            //sb.append(System.lineSeparator());
//            line = input.readLine();
//        }
//        
//        input.close();
//        String text = sb.toString();
//        Splitting splitting = new Splitting();
//        
//        System.out.println("Result :");
//        System.out.println(splitting.split(text));
//        
//        HashMap<String, Integer> result = splitting.frekuensi(splitting.split(text));
//        System.out.println(result.toString());
//        
//        output.write(splitting.split(text));
//        output.close();

//        File folder = new File("D:\\Data\\Rendra\\Kuliah\\Rendra\\Topik Khusus Informatika\\Tugas Akhir\\dataset reuters");
//        File[] listOfFiles = folder.listFiles();
//
//        for (File file : listOfFiles) {
//            if (file.isFile()) {
//                System.out.println(file.getName());
//                BufferedReader input = new BufferedReader(new FileReader(file));
//                StringBuilder sb = new StringBuilder();
//                String line = input.readLine();
//
//                while (line != null) {
//                    sb.append(line);
//                    line = input.readLine();
//                }
//
//                input.close();
//                String text = sb.toString();
//                System.out.println(text);
//            }
//        }

        Parser parser = new Parser();
        Term[] temp = parser.parseDoc();
        for(int i = 0;i<temp.length;i++) {
            System.out.println(temp[i].getResultParse());
        }
    }
}