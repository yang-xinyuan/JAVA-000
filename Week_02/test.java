package com.wendao.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder().url("http://localhost:8808/test").build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } finally {
            client.clone();
        }
    }
}
