package solvesudoku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static drivers.DriverFactory.driver;

public class TeamSecretCollector {
    public FileWriter fileWriter;

    public TeamSecretCollector() {
        try {
            this.fileWriter = new FileWriter("teamSecret.csv");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void collectData() throws InterruptedException {
        try {
            fileWriter.write("Hero,Picks,Win,Bans,Win");
            fileWriter.append("\n");
              for (int i = 0; i < 119; i++) {
              try {
                    List<WebElement> heroesList = driver.findElements(By.xpath(".//a[contains(@href,'/heroes/')]"));
                    List<WebElement> picksList = driver.findElements(By.xpath(".//td[contains(@class,'r-tab r-group-1 shown')]"));
                    List<WebElement> winsList = driver.findElements(By.xpath(".//td[contains(@class,'r-tab r-group-1 shown')]"));
                    List<WebElement> bansList = driver.findElements(By.xpath(".//td[contains(@class,'r-tab r-group-2 cell-divider')]"));
                    List<WebElement> winsList1 = driver.findElements(By.xpath(".//td[contains(@class,'r-tab r-group-2')]"));
                    fileWriter.write(heroesList.get(i).getText() + "," + picksList.get(i).getText() + "," + winsList.get(i).getText() + "," + bansList.get(i).getText() + "," + winsList1.get(i).getText());
                  fileWriter.append("\n");

                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e);
                }
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);;
       }



    }

}

