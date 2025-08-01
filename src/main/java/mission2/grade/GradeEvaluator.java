package mission2.grade;

import mission2.grade.impl.GoldGrade;
import mission2.grade.impl.NormalGrade;
import mission2.grade.impl.SilverGrade;
import mission2.score.ScorePerson;

import java.util.ArrayList;
import java.util.List;

public class GradeEvaluator {
    private List<GradeInterface> gradeList = new ArrayList<>();

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

        sp.setGrade("등급없음");
        return sp;
    }
}
