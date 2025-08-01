package mission2;

import mission2.file.FileProcess;
import mission2.grade.GradeEvaluator;
import mission2.score.ScoreCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceLogicTest {
    private FileProcess fileProcess;
    private ScoreCalculator scoreCalculator;
    private GradeEvaluator gradeEvaluator;
    private AttendanceLogic attendanceLogic;


    @BeforeEach
    void setup() {
        fileProcess = new FileProcess("src/main/resources/attendance_weekday_500_hannah.txt");
        scoreCalculator = new ScoreCalculator();
        gradeEvaluator = new GradeEvaluator();
        attendanceLogic = new AttendanceLogic(fileProcess, scoreCalculator, gradeEvaluator);
    }

    @Test
    void executeLogic() {
        // given
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        attendanceLogic.execute();

        // then
        String result = out.toString();
        String expected = "NAME : Hannah, POINT : 127, GRADE : GOLD";
        Assertions.assertTrue(result.contains(expected));
        System.setOut(System.out); // 원래 스트림으로 복원
    }

    @Test
    void executeMain() {
        // given
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        String[] args = new String[]{""};
        Attendance_mission2.main(args);

        // then
        String result = out.toString();
        String expected = "NAME : Hannah, POINT : 127, GRADE : GOLD";
        Assertions.assertTrue(result.contains(expected));
        System.setOut(System.out); // 원래 스트림으로 복원
    }
}