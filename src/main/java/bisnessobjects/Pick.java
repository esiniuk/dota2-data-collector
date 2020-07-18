package bisnessobjects;

public class Pick {
    public Pick(String hero, PickBanDB pickBanDB, CounterPickDB counterPickDB) {

        this.hero = hero;
        this.gameNumber = pickBanDB.numberPicked;
        this.winrate = pickBanDB.winrate;
        this.opponentGameVersusNumber = counterPickDB.opponentNumberPicked;
        this.opponentWinrateVersus = counterPickDB.opponentWinrate;
    }

    private String hero;
    private Integer gameNumber;
    private Double winrate;
    private Integer opponentGameVersusNumber;
    private Double opponentWinrateVersus;
}
