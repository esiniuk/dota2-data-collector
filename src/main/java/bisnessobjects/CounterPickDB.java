package bisnessobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CounterPickDB {

    public CounterPickDB(String team, String heroName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(team + ".csv"));
        String hero;
        Map<String, String[]> counterDB = new HashMap<String, String[]>();
        while ((hero = br.readLine()) != null) {
            String[] trueHero = hero.split(",");
            String[] stats = {trueHero[1], trueHero[2], trueHero[3], trueHero[4]};
            counterDB.put(trueHero[0], stats);
        }
        opponentNumberPicked = Integer.parseInt(counterDB.get(heroName)[0]);
        opponentWinrate = Double.parseDouble(counterDB.get(heroName)[1]);
        opponentNumberBanned = Integer.parseInt(counterDB.get(heroName)[2]);
        opponentWinrateWhenBanned = Double.parseDouble(counterDB.get(heroName)[3]);
    }

    public Integer opponentNumberPicked;
    public Double opponentWinrate;
    public Integer opponentNumberBanned;
    public Double opponentWinrateWhenBanned;
}
