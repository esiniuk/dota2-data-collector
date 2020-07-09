package ui;

import static drivers.DriverFactory.driver;
import static utils.RunProperties.getHeroPageAddress;

public class HeroPage {
    
    public void open() {

        driver.get(getHeroPageAddress());
    }

    public void close() {

        driver.quit();
    }
}

