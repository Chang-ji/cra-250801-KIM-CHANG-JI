package mission2;

import mission2.file.FileProcess;
import mission2.grade.GradeEvaluator;
import mission2.score.ScoreCalculator;

public class Attendance_mission2 {
    public static final String SRC_MAIN_RESOURCES_ATTENDANCE_WEEKDAY_500_TXT = "src/main/resources/attendance_weekday_500.txt";

    public static void main(String[] args) {
        FileProcess fileProcess = new FileProcess(SRC_MAIN_RESOURCES_ATTENDANCE_WEEKDAY_500_TXT);
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        GradeEvaluator gradeEvaluator = new GradeEvaluator();

        AttendanceLogic attendanceLogic = new AttendanceLogic(fileProcess, scoreCalculator, gradeEvaluator);
        attendanceLogic.execute();
    }
}
