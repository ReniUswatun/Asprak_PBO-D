package com.io.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
    public static void main(String[] args) {
        String filepath = "appdata/users.json";

        FileProvider fileProvider = new FileProvider();
        Gson gson = new Gson();

        List<User> users = new ArrayList<>();

        String jsonStr = fileProvider.read(filepath);
        if (!jsonStr.isEmpty()) {
            users = gson.fromJson(jsonStr, new TypeToken<List<User>>() {
            }.getType());
        }

        for (User user : users) {
            System.out.println(user.name);
            System.out.println(user.address.city);
            System.out.println();
        }
    }
}