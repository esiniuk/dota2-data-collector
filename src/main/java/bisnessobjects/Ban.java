package bisnessobjects;

public class Ban {

    public Ban(String hero, PickBanDB pickBanDB, CounterPickDB counterPickDB) {
        this.hero = hero;
        this.gameNumberBanned = pickBanDB.numberBanned;
        this.winrate = pickBanDB.winrateWhenBanned;
        this.opponentGameNumberWhenBannedVersus = counterPickDB.opponentNumberBanned;
        this.opponentWinrateWhenBannedVersus = counterPickDB.opponentWinrateWhenBanned;
    }

    private String hero;
    private Integer gameNumberBanned;
    private Double winrate;
    private Integer opponentGameNumberWhenBannedVersus;
    private Double opponentWinrateWhenBannedVersus;
}
