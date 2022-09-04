package com.codernck.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


/**
 *
 * Various ways to read files in Java
 * https://www.baeldung.com/reading-file-in-java
 * https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
 */
public class ReadFileUtil {
    public static void main(String[] args) {
        String fileName = "C:\\tmp\\f1.txt";
        ReadFileUtil readFile = new ReadFileUtil();
        readFile.readUsingBufferedReader(fileName);
        readFile.readUsingFileReader(fileName);
        readFile.readFileUsingInputStream(fileName);
        readFile.readUsingScanner(fileName);
        readFile.readUsingScanner2(fileName);
        readFile.readUsingPath(fileName);
    }

    private void readUsingPath(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        Path path = Paths.get(fileName);
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String placeHolder;
            while ((placeHolder = br.readLine()) != null) {
                stringBuilder.append(placeHolder);
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Reading with Scanner without need of loops
     * https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
     *
     */
    private void readUsingScanner2(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\\Z");
            stringBuilder.append(scanner.next());
            System.out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readUsingScanner(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void readFileUsingInputStream(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try(FileInputStream fis = new FileInputStream(fileName)) {
            int i;
            while ((i = fis.read()) != -1) {
                stringBuilder.append((char)i);
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readUsingFileReader(String fileName) {
        StringBuffer sb = new StringBuffer();
        try(FileReader fileReader = new FileReader(fileName)) {
            int i;
            while((i = fileReader.read()) != -1) {
                sb.append((char)i);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readUsingBufferedReader(String fileName) {
        File file = new File(fileName);
        StringBuffer sb = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String placeHolder;
            while ((placeHolder = br.readLine()) != null) {
                sb.append(placeHolder);
                sb.append("\n");
            }
            br.close();
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
