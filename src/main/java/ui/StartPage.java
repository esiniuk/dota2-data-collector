package ui;

import static utils.RunProperties.getWebPortalAddress;
import static drivers.DriverFactory.driver;

public class StartPage {
    
    public void open() {

        driver.get(getWebPortalAddress());
    }

    public void close() {

        driver.quit();
    }
}

