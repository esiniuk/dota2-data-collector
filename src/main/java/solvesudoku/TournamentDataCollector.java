package solvesudoku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static drivers.DriverFactory.driver;

public class TournamentDataCollector {

    public FileWriter fileWriter;

    public TournamentDataCollector() {
        try {
            this.fileWriter = new FileWriter("tournamentData.csv");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void collectData() throws InterruptedException {
        try {
            fileWriter.write("Winner, First Pick, Second Pick, Ban 1, Ban 2, Ban 3, Ban 4, Ban 5, Ban 6, " +
                    "Pick 1, Pick 2, Pick 3, Pick 4, Ban 7, Ban 8, Ban 9, Ban 10, Pick 5, Pick 6, Pick 7, Pick 8, " +
                    "Ban 11, Ban 12, Pick 9, Pick 10");
            fileWriter.append("\n");
            for (int i = 0; i < 2; ++i) {
                List<WebElement> seriesList = driver.findElements(By.xpath(".//div/a[contains(@title, 'Series')]"));
                int y = seriesList.size();
                if (y > 20) {
                    y = 20;
                }
                System.out.println(seriesList.size());
                int x = 0;
                for (int k = 0; k < y; k++) {
                    try {
                        List<WebElement> seriesListTemp = driver.findElements(By.xpath(".//div/a[contains(@title, 'Series')]"));
                        System.out.println("click: " + seriesListTemp.get(x).getText());
                        seriesListTemp.get(x).click();
                        List<WebElement> matches = driver.findElements(By.className("match-link"));
                        List<WebElement> winners = driver.findElements(By.cssSelector(".team-text-tag"));
                        for (int j = 0; j < matches.size(); j++) {
                            fileWriter.write(winners.get(j).getText() + ",");
                            writeHeroesName(j);
                        }
                        x++;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e);
                    }
                    driver.navigate().back();
                }
                try {
                    WebElement nextButton = driver.findElement(By.className("next"));

                    nextButton.click();
                    System.out.println("trying to click next button");
                } catch (NoSuchElementException e) {
                    System.out.println(e);
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void writeHeroesName(int matchNumber) throws IOException {
        List<WebElement> teamNames = driver.findElements(By.cssSelector(".team-text-full"));
        System.out.println();
        if (driver.findElements(By.className("seq")).size() < 22) {
            return;
        }
        try {
            if (driver.findElements(By.className("seq")).get(22 * matchNumber).getAttribute("innerText").contains("6")) {
                fileWriter.write(teamNames.get(1).getText() + ",");
                fileWriter.write(teamNames.get(0).getText() + ",");
            } else {
                fileWriter.write(teamNames.get(0).getText() + ",");
                fileWriter.write(teamNames.get(1).getText() + ",");
            }
        } catch (IndexOutOfBoundsException e) {
            fileWriter.write(teamNames.get(0).getText() + ",");
            fileWriter.write(teamNames.get(1).getText() + ",");
        }
        for (int i = 1; i < 23; i++) {
            try {
                String xpath = String.format(".//*[@class='seq' and text() = %s]/..//a", i);
                List<WebElement> heroElement = driver.findElements(By.xpath(xpath));
                fileWriter.write(heroElement.get(matchNumber).getAttribute("href").substring(32) + ",");
            } catch (IndexOutOfBoundsException e) {
                fileWriter.write(",");
            }
        }
        fileWriter.append("\n");
    }
}
