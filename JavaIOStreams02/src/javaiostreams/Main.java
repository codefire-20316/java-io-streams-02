/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaiostreams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author human
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    static {
        try {
            LOG.addHandler(new FileHandler("app.log", true));
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("file.txt"))) {

            dos.writeLong(1236745L);
            dos.writeUTF("Hello, World!");
            dos.writeInt(87654);
            dos.writeUTF("Hello, World!");
            dos.writeUTF("Hello, World!");

        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        try (DataInputStream dos = new DataInputStream(new FileInputStream("file.txt"))) {

            String input1 = dos.readUTF();
            long l = dos.readLong();
            int b = dos.readInt();
            String input2 = dos.readUTF();
            String input3 = dos.readUTF();

            System.out.println(l);
            System.out.println(input1);
            System.out.println(b);
            System.out.println(input2);
            System.out.println(input3);

        } catch (IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        System.out.println("GOOD BYE!");
    }

}
