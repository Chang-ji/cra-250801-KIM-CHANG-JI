package mission2.grade;

import mission2.day.Day;
import mission2.score.ScoreCalculator;
import mission2.score.ScorePerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeEvaluatorTest {
    private GradeEvaluator gradeEvaluator;

    @BeforeEach
    void setup() {
        gradeEvaluator = new GradeEvaluator();
    }

    @Test
    void calGradeOnGOLD() {
        // given
        ScorePerson inputPerson = new ScorePerson("abc");
        inputPerson.setTotalCount(55);

        // when
        ScorePerson outputPerson = gradeEvaluator.calGrade(inputPerson);

        // then
        Assertions.assertEquals(outputPerson.getGrade(), "GOLD");
    }

    @Test
    void calGradeOnSILVER() {
        // given
        ScorePerson inputPerson = new ScorePerson("abc");
        inputPerson.setTotalCount(33);

        // when
        ScorePerson outputPerson = gradeEvaluator.calGrade(inputPerson);

        // then
        Assertions.assertEquals(outputPerson.getGrade(), "SILVER");
    }

    @Test
    void calGradeOnNORMAL() {
        // given
        ScorePerson inputPerson = new ScorePerson("abc");
        inputPerson.setTotalCount(3);

        // when
        ScorePerson outputPerson = gradeEvaluator.calGrade(inputPerson);

        // then
        Assertions.assertEquals(outputPerson.getGrade(), "NORMAL");
    }

    @Test
    void calGradeOnException() {
        // given
        ScorePerson inputPerson = new ScorePerson("abc");
        inputPerson.setTotalCount(-1);

        // then
        assertThrows(RuntimeException.class, () -> gradeEvaluator.calGrade(inputPerson));
    }
}