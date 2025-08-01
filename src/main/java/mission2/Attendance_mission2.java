package mission2;

import mission2.file.FileProcess;
import mission2.grade.GradeEvaluator;
import mission2.score.ScoreCalculator;
import mission2.score.ScorePerson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Attendance_mission2 {
    public static final String SRC_MAIN_RESOURCES_ATTENDANCE_WEEKDAY_500_TXT = "src/main/resources/attendance_weekday_500.txt";


    public static void main(String[] args) {
        FileProcess fileProcess = new FileProcess(SRC_MAIN_RESOURCES_ATTENDANCE_WEEKDAY_500_TXT);

        // 기본적이 점수 계산
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        GradeEvaluator gradeEvaluator = new GradeEvaluator();

        AttendanceLogic attendanceLogic = new AttendanceLogic(fileProcess, scoreCalculator, gradeEvaluator);
        attendanceLogic.execute();
    }
}
