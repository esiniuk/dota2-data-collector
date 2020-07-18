package datacollectors;

import collectors.HeroDataCollector;
import ui.HeroPage;

public class CollectHeroDB {

    private static HeroPage heroPage = new HeroPage();
    private static HeroDataCollector heroDataCollector = new HeroDataCollector();

    public static void main (String[] agrs){

        for(int i = 0; i < 1 ; ++i) {
            heroPage.open();
            heroDataCollector.collectData();
        }
        heroPage.close();

    }
}
