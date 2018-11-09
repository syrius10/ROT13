package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length >= 1) {
            for (String file : args) {
                //create a FileInputStream for the file
                try (InputStream in = new BufferedInputStream(new FileInputStream(file))) {
                    rot13(in, System.out);
                }
            }
        } else {
            System.out.print("Input string to encrypt/decrypt then press enter: ");
            rot13(System.in, System.out);
        }
    }

    private static void rot13(InputStream inputStream, OutputStream outputStream) throws IOException {
        int ch;
        while ((ch = inputStream.read()) != -1) {
            outputStream.write(rot13((char) ch));
        }
    }

    private static char rot13(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (((c - 'A') + 13) % 26 + 'A');
        }
        if (c >= 'a' && c <= 'z') {
            return (char) (((c - 'a') + 13) % 26 + 'a');
        }
        return c;
    }
}
