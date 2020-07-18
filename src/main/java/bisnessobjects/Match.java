package bisnessobjects;

public class Match {

    public Match(String winner, String firstPick, String secondPick, Ban oneBan, Ban twoBan, Ban threeBan, Ban fourBan, Ban fiveBan, Ban sixBan, Ban sevenBan, Ban eightBan, Pick onePick, Pick twoPick, Pick threePick, Pick fourPick, Ban nineBan, Ban tenBan, Pick fivePick, Pick sixPick, Pick sevenPick, Pick eightPick, Ban elevenBan, Ban twelveBan, Pick ninePick, Pick tenPick) {
        if (firstPick.contains(winner)) {
            this.winner = firstPick;
        } else {
            this.winner = secondPick;
        }
        this.firstPick = firstPick;
        this.secondPick = secondPick;
        this.ban1 = oneBan;
        this.ban2 = twoBan;
        this.ban3 = threeBan;
        this.ban4 = fourBan;
        this.ban5 = fiveBan;
        this.ban6 = sixBan;
        this.ban7 = sevenBan;
        this.ban8 = eightBan;
        this.pick1 = onePick;
        this.pick2 = twoPick;
        this.pick3 = threePick;
        this.pick4 = fourPick;
        this.ban9 = nineBan;
        this.ban10 = tenBan;
        this.pick5 = fivePick;
        this.pick6 = sixPick;
        this.pick7 = sevenPick;
        this.pick8 = eightPick;
        this.ban11 = elevenBan;
        this.ban12 = twelveBan;
        this.pick9 = ninePick;
        this.pick10 = tenPick;
    }

    private String winner;
    private String firstPick;
    private String secondPick;
    private Ban ban1;
    private Ban ban2;
    private Ban ban3;
    private Ban ban4;
    private Ban ban5;
    private Ban ban6;
    private Ban ban7;
    private Ban ban8;
    private Pick pick1;
    private Pick pick2;
    private Pick pick3;
    private Pick pick4;
    private Ban ban9;
    private Ban ban10;
    private Pick pick5;
    private Pick pick6;
    private Pick pick7;
    private Pick pick8;
    private Ban ban11;
    private Ban ban12;
    private Pick pick9;
    private Pick pick10;

}
