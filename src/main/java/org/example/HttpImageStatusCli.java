package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter HTTP status code: ");
        String input = scanner.nextLine();

        try {
            int code = Integer.parseInt(input);
            try {
                downloader.downloadStatusImage(code);
                System.out.println("Image for HTTP status " + code + " downloaded successfully.");
            } catch (Exception e) {
                System.out.println("There is no image for HTTP status " + code);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}
