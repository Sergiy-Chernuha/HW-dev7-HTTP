package ua.goit;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.IOException;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws WrongStatusException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String statusImage = httpStatusChecker.getStatusImage(code);

        downloadImage(code, statusImage);
    }

    private void downloadImage(int code, String url) {
        Response response;

        try {
            response = Jsoup.connect(url).ignoreContentType(true).ignoreHttpErrors(true).execute();
            byte[] bytes = response.bodyAsBytes();
            FileOutputStream out = (new FileOutputStream(code + ".jpg"));

            out.write(bytes);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
