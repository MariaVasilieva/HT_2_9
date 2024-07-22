package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.example.Utils.*;

public class HttpStatusImageDownloader {

    private HttpStatusChecker statusChecker = new HttpStatusChecker();

    public void downloadStatusImage(int code) throws Exception {
        String imageUrl = statusChecker.getStatusImage(code);
        HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
        String fileName = DIRECTORY_FOR_SAVE + "\\images\\" +  code + EXTENSION;
        try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            Files.deleteIfExists(Paths.get(fileName));
            throw e;
        }
    }
}