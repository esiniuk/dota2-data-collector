import solvesudoku.TeamSecretCollector;
import ui.TeamSecretPage;

public class CollectTeamSecretDB {
        private static TeamSecretPage teamSecretPage = new TeamSecretPage();
        private static TeamSecretCollector teamSecretCollector = new TeamSecretCollector();
        public static void main(String[] args) throws InterruptedException {
            teamSecretPage.open();
            teamSecretCollector.collectData();
            teamSecretPage.close();

        }
    }

