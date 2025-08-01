package mission2.file;

import mission2.score.ScoreCalculator;
import mission2.score.ScorePerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessTest {
    private ScoreCalculator scoreCalculator;
    private FileProcess fileProcess;

    @BeforeEach
    void setup() {
        scoreCalculator = new ScoreCalculator();
    }

    @Test
    void fileProcessingOnHannah() {
        // given
        fileProcess = new FileProcess("src/main/resources/attendance_weekday_500_hannah.txt");

        // when
        Map<String, ScorePerson> result =  fileProcess.fileProcessing(scoreCalculator);
        ScorePerson resultPerson = result.get("Hannah");

        // then
        Assertions.assertEquals(resultPerson.getName(), "Hannah");
        Assertions.assertEquals(resultPerson.getGrade(), "등급 없음");
        Assertions.assertEquals(resultPerson.getTotalCount(), 107);
    }

    @Test
    void fileProcessingOnHannahOnUpper500() {
        // given
        fileProcess = new FileProcess("src/main/resources/attendance_weekday_500_over.txt");

        // when
        Map<String, ScorePerson> result =  fileProcess.fileProcessing(scoreCalculator);
        ScorePerson resultPerson = result.get("Hannah");

        // then
        Assertions.assertEquals(resultPerson.getName(), "Hannah");
        Assertions.assertEquals(resultPerson.getGrade(), "등급 없음");
        Assertions.assertEquals(resultPerson.getTotalCount(), 107);
    }

    @Test
    void fileProcessingOnExceptionOnNotFile() {
        // given
        fileProcess = new FileProcess("src/main/resources/aaa.txt");

        // then
        assertThrows(RuntimeException.class, () -> fileProcess.fileProcessing(scoreCalculator));
    }

    @Test
    void fileProcessingOnExceptionOnNotFileFormat() {
        // given
        fileProcess = new FileProcess("src/main/resources/attendance_weekday_500_aaa.txt");

        // when
        Map<String, ScorePerson> result =  fileProcess.fileProcessing(scoreCalculator);

        // then
        Assertions.assertEquals(result.size(), 0);
    }
}