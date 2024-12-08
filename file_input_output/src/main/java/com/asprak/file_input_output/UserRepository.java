/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asprak.file_input_output;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rizalanggoro
 */
public class UserRepository {
    private final Gson gson = new Gson(); 
    private final String filename = "appdata/users.json"; 
    private final FileProvider fileProvider = new FileProvider(); 
    
    public boolean addUser(User user) {
        try {
            ArrayList<User> users = new ArrayList<>(); 
        
            if (fileProvider.isFileExists(filename)) {
                String jsonStr = fileProvider.read(filename); 
                if (jsonStr.trim().length() > 0)
                    users = gson.fromJson(jsonStr, new TypeToken<ArrayList<User>>(){}.getType()); 
            }

            users.add(user); 
            fileProvider.create(filename, gson.toJson(users)); 
            
            return true; 
        } catch (Exception e) {
            e.printStackTrace();
            return false; 
        }
    }
    
    public boolean addUsers(List<User> newUsers) {
        try {
            ArrayList<User> users = new ArrayList<>(); 
        
            if (fileProvider.isFileExists(filename)) {
                String jsonStr = fileProvider.read(filename); 
                if (jsonStr.trim().length() > 0)
                    users = gson.fromJson(jsonStr, new TypeToken<ArrayList<User>>(){}.getType()); 
            }

            users.addAll(newUsers); 
            fileProvider.create(filename, gson.toJson(users)); 
            
            return true; 
        } catch (Exception e) {
            e.printStackTrace();
            return false; 
        }
    }
    
    public List<User> getAllUsers() {
        try {
            if (fileProvider.isFileExists(filename)) {
                String jsonStr = fileProvider.read(filename); 
                if (jsonStr.trim().length() > 0)
                    return gson.fromJson(jsonStr, new TypeToken<List<User>>(){}.getType());
            }
            
            throw new Exception(); 
        } catch (Exception e) {
            return new ArrayList(); 
        }
    }
    
    public boolean deleteLastUser() {
        try {
            ArrayList<User> users = new ArrayList<>(); 
        
            if (fileProvider.isFileExists(filename)) {
                String jsonStr = fileProvider.read(filename); 
                if (jsonStr.trim().length() > 0)
                    users = gson.fromJson(jsonStr, new TypeToken<ArrayList<User>>(){}.getType()); 
                
                if (!users.isEmpty()) {
                    users.remove(users.size() - 1); 
                    fileProvider.create(filename, gson.toJson(users)); 
                    
                    return true; 
                }
            }

            return false; 
        } catch (Exception e) {
            return false; 
        }
    }
    
    public boolean deleteAllUsers() {
        try {
            fileProvider.delete(filename); 
            return true; 
        } catch (Exception e) {
            return false; 
        }
    }
}
