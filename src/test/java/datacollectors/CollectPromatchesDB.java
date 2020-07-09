import collectors.TournamentDataCollector;
import ui.TournamentPage;

public class CollectPromatchesDB {

    private static TournamentPage tournamentPage = new TournamentPage();
    private static TournamentDataCollector tournamentDataCollector = new TournamentDataCollector();

    public static void main(String[] agrs) throws InterruptedException {

        tournamentPage.open();
        tournamentDataCollector.collectData();
        tournamentPage.close();
    }
}
