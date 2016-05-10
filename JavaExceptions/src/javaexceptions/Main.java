/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author human
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        
        while (true) {
            System.out.print("Enter number: ");
            String input = scanner.nextLine();

            try {
                number = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Input is not a number!");
            }
        }
        
        File file = new File("number.txt");
        
        try (FileOutputStream fos = new FileOutputStream(file)) {
            
            String numb = Integer.toString(number);
            
            fos.write(numb.getBytes());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
