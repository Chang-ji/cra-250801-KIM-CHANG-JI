package mission2.day;

public enum Day {
    monday,
    tuesday,
    wednesday,
    thursday,
    friday,
    saturday,
    sunday;

    public static Day from(String dayName) {
        for (Day day : Day.values()) {
            if (day.name().equalsIgnoreCase(dayName)) {
                return day;
            }
        }
        throw new RuntimeException();
    }
}
