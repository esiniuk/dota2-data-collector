package solvesudoku;

import org.openqa.selenium.By;
import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static drivers.DriverFactory.driver;

public class MatchesDataCollector {

    private static final String getMatchesURL = "https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/" +
            "?min_players=10&skill=3start_at_match_id=5115606205" +
            "&key=F1122273457C04E077618005B35F7865";

    public String getJSON() {

        try {
            URL url = new URL(getMatchesURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setConnectTimeout(30000);

            con.connect();

            int resp = con.getResponseCode();
            if(resp == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                br.close();

                return sb.toString();
            } else {
                System.out.println("Ответ сервера: " + resp);
            }

        } catch(Exception e) { e.printStackTrace(); }

        return null;
    }

}
