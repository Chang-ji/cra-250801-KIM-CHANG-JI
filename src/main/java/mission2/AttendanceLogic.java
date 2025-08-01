package mission2;

import mission2.file.FileProcess;
import mission2.grade.GradeEvaluator;
import mission2.score.ScoreCalculator;
import mission2.score.ScorePerson;

import java.util.Map;

public class AttendanceLogic {
    private final FileProcess fileProcess;
    private final ScoreCalculator scoreCalculator;
    private final GradeEvaluator gradeEvaluator;

    public AttendanceLogic(FileProcess fileProcess, ScoreCalculator scoreCalculator, GradeEvaluator gradeEvaluator) {
        this.fileProcess = fileProcess;
        this.scoreCalculator = scoreCalculator;
        this.gradeEvaluator = gradeEvaluator;
    }

    public void execute() {
        Map<String, ScorePerson> personMap = fileProcess.fileProcessing(scoreCalculator);
        for(String key : personMap.keySet()) {
            ScorePerson scorePerson = personMap.get(key);
            // 보너스 점수 계산
            scorePerson = scoreCalculator.bonusScoreCalculation(scorePerson);
            // grade 평가
            scorePerson = gradeEvaluator.calGrade(scorePerson);
            personMap.replace(key, scorePerson);

            System.out.print("NAME : " + scorePerson.getName() + ", ");
            System.out.print("POINT : " + scorePerson.getTotalCount() + ", ");
            System.out.print("GRADE : " + scorePerson.getGrade());
            System.out.println();
        }

        System.out.println();
        System.out.println("Removed player");
        System.out.println("==============");

        for(String key : personMap.keySet()) {
            ScorePerson scorePerson = personMap.get(key);

            if (scorePerson.isRemovedPlayer()) {
                System.out.println(scorePerson.getName());
            }
        }
    }
}
