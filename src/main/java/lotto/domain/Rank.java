package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0, "낙첨"),
    FIFTH(3, 5000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - %d개");

    private final int count;
    private final int prizeMoney;
    private final String message;

    Rank(int count, int prizeMoney, String message) {
        this.count = count;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String formatMessage(int value) {
        return String.format(message, value);
    }

    public static Rank valueOf(int count, boolean isBonus) {
        if (count == 5 && isBonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(count))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(int count) {
        return this.count == count;
    }
}