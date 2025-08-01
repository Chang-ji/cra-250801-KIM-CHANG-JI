package mission2.grade.impl;

import mission2.grade.GradeInterface;

public class GoldGrade implements GradeInterface {

    public static final int GRADE_MIN_SCORE = 50;
    public static final String GRADE_NAME = "GOLD";

    @Override
    public boolean matches(Integer totalScore) {
        return totalScore >= GRADE_MIN_SCORE;
    }

    @Override
    public String getGrade() {
        return GRADE_NAME;
    }
}
