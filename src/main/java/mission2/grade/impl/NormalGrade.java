package mission2.grade.impl;

import mission2.grade.GradeInterface;

public class NormalGrade implements GradeInterface {

    public static final int GRADE_MIN_SCORE = 0;
    public static final String GRADE_NAME = "NORMAL";

    @Override
    public boolean matches(Integer totalScore) {
        return totalScore >= GRADE_MIN_SCORE;
    }

    @Override
    public String getGrade() {
        return GRADE_NAME;
    }
}
