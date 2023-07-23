package ua.goit;

import org.jsoup.Connection.Response;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws WrongStatusException {
        Connection connect = Jsoup.connect("https://http.cat/" + code);

        try {
            Response response = connect.ignoreHttpErrors(true)
                    .ignoreContentType(true)
                    .execute();

            int i = response.statusCode();

            if (i != 404) {
                return "https://http.cat/" + code + ".jpg";
            } else {
                throw new WrongStatusException(String.valueOf(code));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
