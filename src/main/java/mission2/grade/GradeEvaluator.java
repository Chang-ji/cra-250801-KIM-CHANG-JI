package mission2.grade;

import mission2.grade.impl.GoldGrade;
import mission2.grade.impl.NormalGrade;
import mission2.grade.impl.SilverGrade;
import mission2.score.ScorePerson;

import java.util.ArrayList;
import java.util.List;

public class GradeEvaluator {
    private final List<GradeInterface> gradeList = new ArrayList<>();

    public GradeEvaluator() {
        gradeList.add(new GoldGrade());
        gradeList.add(new SilverGrade());
        gradeList.add(new NormalGrade());
    }

    public ScorePerson calGrade(ScorePerson sp) {
        for(GradeInterface grade : gradeList) {
            if(grade.matches(sp.getTotalCount())){
                sp.setGrade(grade.getGrade());
                return sp;
            }
        }

        throw new RuntimeException("등급이 맞지 않습니다.");
    }
}
