package org.example;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.example.Utils.*;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception {
        String urlString = START_URL + code + EXTENSION;
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();

        if (responseCode == 404) {
            throw new Exception("No image found for status code: " + code);
        }
        return urlString;
    }
}
