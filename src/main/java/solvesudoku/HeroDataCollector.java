package solvesudoku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static drivers.DriverFactory.driver;

public class HeroDataCollector {

    public void collectData() {
        try {
            FileWriter fileWriter = new FileWriter("herodata.csv");
//            fileWriter.write("HeroName,MidPick,MidWin,HardPick,HardWin,SafePick,SafeWin,RoamPick,PoamWin");
//            fileWriter.write("HeroName,Picks,Win,Bans,Win,Combined,Win,Radiant");
            fileWriter.write("HeroName,Enemy Picks,Enemy Win,Enemy Bans,Enemy Win,Combined,Enemy Win");
            fileWriter.append("\n");
            List<WebElement> heroes = driver.findElements(By.tagName("td"));
            int x = 1;
            for (WebElement hero : heroes) {
                if (!hero.getText().equals("")) {
                    fileWriter.write(hero.getText() + ",");
                }
                if (x % 8 == 0) {
                    fileWriter.append("\n");
                }
                x++;
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
