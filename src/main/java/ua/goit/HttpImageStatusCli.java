package ua.goit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private Logger LOGGER = LoggerFactory.getLogger(HttpImageStatusCli.class);

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        while (true) {
            LOGGER.info("Enter HTTP status code: ");

            if (scanner.hasNext()) {
                try {
                    int i = scanner.nextInt();

                    try {
                        downloader.downloadStatusImage(i);
                        break;
                    } catch (WrongStatusException e) {
                        LOGGER.error(e.getMessage());
                    }
                } catch (InputMismatchException e) {
                    LOGGER.error("Please enter valid number!!!");
                    scanner.nextLine();
                }
            }
        }
    }
}
