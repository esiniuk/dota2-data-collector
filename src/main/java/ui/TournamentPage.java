package ui;

import java.util.concurrent.TimeUnit;

import static drivers.DriverFactory.driver;
import static utils.RunProperties.getTournamentPageAddress;

public class TournamentPage {
    
    public void open() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(getTournamentPageAddress());
    }

    public void close() {

        driver.quit();
    }
}

