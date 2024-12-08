/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asprak.file_input_output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rizalanggoro
 */
public class FileProvider {
    public boolean isFileExists(String filepath) {
        File file = new File(filepath);
        return file.exists();
    }
    
    public String read(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            scanner.close();
            return stringBuilder.toString(); 
        } catch (FileNotFoundException e) {
            return ""; 
        }
    }

    public boolean create(String filepath, String data) {
        try {
            File file = new File(filepath);
            file.getParentFile().mkdirs();
            file.createNewFile();

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(data);
            fileWriter.close();

            return true; 
        } catch (IOException e) {
            return false; 
        }
    }

    public boolean delete(String filepath) {
        File file = new File(filepath);
        return file.delete();
    }
}
