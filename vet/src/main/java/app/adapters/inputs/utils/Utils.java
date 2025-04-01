/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.inputs.utils;

import java.util.Scanner;

/**
 *
 * @author berna
 */
public abstract class Utils {
    //Usaremos esta clase para metodos estaticos
    
    private static Scanner reader =new Scanner(System.in);
    public static Scanner getReader(){
        return reader;
    }
    
    
}
