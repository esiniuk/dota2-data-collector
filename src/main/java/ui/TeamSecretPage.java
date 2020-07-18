package ui;

import java.util.concurrent.TimeUnit;

import static drivers.DriverFactory.driver;
import static utils.RunProperties.getTeamPageAddress;

public class TeamSecretPage {

    public void open() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(getTeamPageAddress());
    }

    public void close() {

        driver.quit();
    }
}
