package ua.goit;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger LOGGER= LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        HttpStatusChecker httpStatusChecker= new HttpStatusChecker();
        String statusImage;

        try {
            statusImage = httpStatusChecker.getStatusImage(200);

            LOGGER.info("Link for 200 status: {}",statusImage);
        } catch (WrongStatusException e) {
            LOGGER.error("Wrong status: "+e.getMessage());
        }
//_________________________________________________
        HttpStatusImageDownloader downloader=new HttpStatusImageDownloader();
        try {
            downloader.downloadStatusImage(404);
        } catch (WrongStatusException e) {
            LOGGER.error(e.getMessage());
        }
//        ________________________________________

        HttpImageStatusCli cli=new HttpImageStatusCli();
        cli.askStatus();

    }
}