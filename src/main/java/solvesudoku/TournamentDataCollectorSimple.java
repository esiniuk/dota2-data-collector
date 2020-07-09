package solvesudoku;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static drivers.DriverFactory.driver;

public class TournamentDataCollectorSimple {

    public FileWriter fileWriter;

    public TournamentDataCollectorSimple() {
        try {
            this.fileWriter = new FileWriter("tournamentData.csv");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void collectData() throws IOException {
        try {
            for (int i = 0; i < 3; ++i) {
                List<WebElement> heroes = driver.findElements(By.className("img-icon"));
                int x = 1;
                for (int j = 0; j < heroes.size(); j++) {
                    String heroName = heroes.get(j).getAttribute("src").substring(39,
                            heroes.get(j).getAttribute("src").lastIndexOf("-"));
                    fileWriter.write(heroName + ",");
                    if (x % 5 == 0) {
                        fileWriter.write("\n");
                    }
                    x++;
                }
                try {
                    WebElement nextButton = driver.findElement(By.partialLinkText("Next"));
                    nextButton.click();
                } catch (NoSuchElementException e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        fileWriter.close();
    }
}
