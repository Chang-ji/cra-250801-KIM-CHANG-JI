package mission2.score;

import mission2.day.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorTest {
    private ScoreCalculator scoreCalculator;

    @BeforeEach
    void setup() {
        scoreCalculator = new ScoreCalculator();
    }

    @Test
    void basicScoreCalculationOnBasicDay() {
        // given
        ScorePerson inputPerson = new ScorePerson("abc");

        // when
        ScorePerson outputPerson = scoreCalculator.basicScoreCalculation(inputPerson, Day.monday);

        // then
        Assertions.assertEquals(outputPerson.getTotalCount(), 1);
    }

    @Test
    void basicScoreCalculationOnWednesday() {
        // given
        ScorePerson inputPerson = new ScorePerson("abc");

        // when
        ScorePerson outputPerson = scoreCalculator.basicScoreCalculation(inputPerson, Day.wednesday);

        // then
        Assertions.assertEquals(outputPerson.getTotalCount(), 3);
    }

    @Test
    void basicScoreCalculationOnWeekend() {
        // given
        ScorePerson inputPerson = new ScorePerson("abc");

        // when
        ScorePerson outputPerson = scoreCalculator.basicScoreCalculation(inputPerson, Day.saturday);

        // then
        Assertions.assertEquals(outputPerson.getTotalCount(), 2);
    }

    @Test
    void NotBonusScoreCalculation() {
        // given
        ScorePerson inputPerson = new ScorePerson("abc");

        // when
        ScorePerson outputPerson = scoreCalculator.bonusScoreCalculation(inputPerson);

        // then
        Assertions.assertEquals(outputPerson.getTotalCount(), 0);

    }

    @Test
    void NotBonusScoreCalculationOnWednesday() {
        // given
        ScorePerson inputPerson = new ScorePerson("abc");
        for (int i = 0; i < 10; i++) {
            inputPerson.addDayCount(Day.wednesday);
        }

        // when
        ScorePerson outputPerson = scoreCalculator.bonusScoreCalculation(inputPerson);

        // then
        Assertions.assertEquals(outputPerson.getTotalCount(), 10);

    }

    @Test
    void BonusScoreCalculationOnWeekend() {
        // given
        ScorePerson inputPerson = new ScorePerson("abc");
        for (int i = 0; i < 10; i++) {
            inputPerson.addDayCount(Day.sunday);
        }

        // when
        ScorePerson outputPerson = scoreCalculator.bonusScoreCalculation(inputPerson);

        // then
        Assertions.assertEquals(outputPerson.getTotalCount(), 10);

    }
}