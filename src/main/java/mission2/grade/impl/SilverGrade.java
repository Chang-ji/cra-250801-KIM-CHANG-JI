package mission2.grade.impl;

import mission2.grade.GradeInterface;

public class SilverGrade implements GradeInterface {

    public static final int GRADE_MIN_SCORE = 30;
    public static final String GRADE_NAME = "SILVER";

    @Override
    public boolean matches(Integer totalScore) {
        return totalScore >= GRADE_MIN_SCORE;
    }

    @Override
    public String getGrade() {
        return GRADE_NAME;
    }
}
