package mission2.score;

import mission2.day.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScorePersonTest {
    private ScorePerson inputPerson;

    @BeforeEach
    void setup() {
        inputPerson = new ScorePerson("abc");
    }


    @Test
    void isRemovedPlayerOnWeekEnd() {
        // when
        inputPerson.addDayCount(Day.wednesday);

        // then
        assertFalse(inputPerson.isRemovedPlayer());
    }

    @Test
    void isRemovedPlayerOnWednesday() {
        // when
        inputPerson.addDayCount(Day.saturday);

        // then
        assertFalse(inputPerson.isRemovedPlayer());
    }

    @Test
    void isRemovedPlayerOn() {
        // when
        inputPerson.setGrade("NORMAL");

        // then
        Assertions.assertTrue(inputPerson.isRemovedPlayer());
    }
}