package com.todo;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main {
    public static void main(String args[]) {
        Thread myThread = new Thread(() -> {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://jsonplaceholder.typicode.com/photos")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.code() == 200) {
                    System.out.println("success");
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        });

        System.out.println("sebelum thread");
        myThread.start();
        System.out.println("setelah thread");

    }
}