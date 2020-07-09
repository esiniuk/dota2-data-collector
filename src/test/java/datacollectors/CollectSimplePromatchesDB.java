import collectors.TournamentDataCollectorSimple;
import ui.TournamentPage;

import java.io.IOException;

public class CollectSimplePromatchesDB {

    private static TournamentPage tournamentPage = new TournamentPage();
    private static TournamentDataCollectorSimple tournamentDataCollector = new TournamentDataCollectorSimple();

    public static void main(String[] agrs) throws IOException {

        tournamentPage.open();
        tournamentDataCollector.collectData();
        tournamentPage.close();
    }
}
