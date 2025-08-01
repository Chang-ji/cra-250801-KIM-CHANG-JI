package mission2.score;

import lombok.Getter;
import lombok.Setter;
import mission2.day.Day;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Setter
@Getter
public class ScorePerson {
    public static final int BONUS_DAY = 10;
    private String name;
    private Map<Day, Integer> dayCount = new HashMap<>() {{
        put(Day.monday, 0);
        put(Day.tuesday, 0);
        put(Day.wednesday, 0);
        put(Day.thursday, 0);
        put(Day.friday, 0);
        put(Day.saturday, 0);
        put(Day.sunday, 0);
    }};
    private String grade = "등급 없음";
    private Integer totalCount = 0;

    public ScorePerson(String name) {
        this.name = name;
    }

    public void addTotalCnt(Integer score) {
        this.totalCount += score;
    }

    public void addDayCount(Day day) {
        dayCount.put(day, dayCount.getOrDefault(day, 0) + 1);
    }

    public boolean isWednesdaysMoreThen10Times() {
        int cnt = dayCount.get(Day.wednesday);
        return cnt >= BONUS_DAY;
    }

    public boolean isWeekendMoreThen10Times() {
        int cnt = dayCount.get(Day.saturday) + dayCount.get(Day.sunday);
        return cnt >= BONUS_DAY;
    }

    public boolean isRemovedPlayer() {
        int wednesdayCnt = dayCount.get(Day.wednesday);
        int weekendCnt = dayCount.get(Day.saturday) + dayCount.get(Day.sunday);

        return wednesdayCnt == 0 && weekendCnt == 0 && Objects.equals(grade, "NORMAL");
    }
}
