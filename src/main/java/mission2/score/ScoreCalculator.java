package mission2.score;

import mission2.day.Day;

public class ScoreCalculator {

    public static final int WEDNESDAY_POINT = 3;
    public static final int WEEKEND_POINT = 2;
    public static final int BASIC_POINT = 1;
    public static final int BONUS_POINT = 10;

    public ScorePerson basicScoreCalculation(ScorePerson sp, Day day) {
        switch (day) {
            case wednesday -> {
                sp.addDayCount(day);
                sp.addTotalCnt(WEDNESDAY_POINT);
            }
            case saturday, sunday -> {
                sp.addDayCount(day);
                sp.addTotalCnt(WEEKEND_POINT);
            }
            default -> {
                sp.addDayCount(day);
                sp.addTotalCnt(BASIC_POINT);
            }
        }
        return sp;
    }

    public ScorePerson bonusScoreCalculation(ScorePerson sp) {
        if (sp.isWednesdaysMoreThen10Times()) {
            sp.addTotalCnt(BONUS_POINT);
        }

        if (sp.isWeekendMoreThen10Times()) {
            sp.addTotalCnt(BONUS_POINT);
        }

        return sp;
    }
}
