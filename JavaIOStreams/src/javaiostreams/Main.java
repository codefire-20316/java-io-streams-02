/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaiostreams;

import java.io.BufferedOutputStream;
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
//        try {
//            FileOutputStream fos = new FileOutputStream("file.txt");
//            BufferedOutputStream bos = new BufferedOutputStream(fos);
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Scanner scanner = new Scanner(System.in);

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("file.txt"))) {
            while (true) {
                String input = scanner.nextLine();

                if ("end".equalsIgnoreCase(input)) {
                    break;
                }

                bos.write(input.getBytes());
                bos.write("\r\n".getBytes());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("GOOD BYE!");
    }

}
