import solvesudoku.MatchesDataCollector;

public class CollectMatchesDB {

    private static MatchesDataCollector matchesDataCollector = new MatchesDataCollector();

    public static void main (String[] agrs){

        System.out.println(matchesDataCollector.getJSON());

        boolean[][] booleanData2 = new boolean[][]{{true, false}, {true, false}};
    }
}
