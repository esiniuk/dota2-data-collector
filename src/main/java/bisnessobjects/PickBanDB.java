package bisnessobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PickBanDB {

    public PickBanDB(String team, String heroName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(team + ".csv"));
        String hero;
        Map<String, String[]> counterDB = new HashMap<String, String[]>();
        while ((hero = br.readLine()) != null) {
            String[] trueHero = hero.split(",");
            String[] stats = {trueHero[1], trueHero[2], trueHero[3], trueHero[4]};
            counterDB.put(trueHero[0], stats);
        }
        numberPicked = Integer.parseInt(counterDB.get(heroName)[0]);
        winrate = Double.parseDouble(counterDB.get(heroName)[1]);
        numberBanned = Integer.parseInt(counterDB.get(heroName)[2]);
        winrateWhenBanned = Double.parseDouble(counterDB.get(heroName)[3]);
    }

    public Integer numberPicked;
    public Double winrate;
    public Integer numberBanned;
    public Double winrateWhenBanned;
}
