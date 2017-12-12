/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VectorSpaceModel;

/**
 *
 * @author Rendra
 * @version 12 Desember 2017
 * 
 */
public class VSM {
    public static double getVSM(double IDF, double TF) {
        return (1 + TF)*IDF;
    }
}