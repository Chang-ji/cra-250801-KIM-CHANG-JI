package mission1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Attendance_mission1 {

    public static final String SRC_MAIN_RESOURCES_ATTENDANCE_WEEKDAY_500_TXT = "src/main/resources/attendance_weekday_500.txt";

    public static final int GOLD = 1;
    public static final int SILVER = 2;
    public static final int NORMAL = 0;

    public static final int BONUS_POINT = 10;

    public static final int MONDAY_INDEX = 0;

    public static final int TUESDAY_INDEX = 1;

    public static final int WEDNESDAY_INDEX = 2;
    public static final int WEDNESDAY_POINT = 3;

    public static final int THURSDAY_INDEX = 3;

    public static final int FRIDAY_INDEX = 4;

    public static final int SATURDAY_INDEX = 5;
    public static final int SATURDAY_POINT = 2;

    public static final int SUNDAY_INDEX = 6;
    public static final int SUNDAY_POINT = 2;

    static class Node {
        String w;
        String wk;

        public Node(String w, String wk) {
            this.w = w;
            this.wk = wk;
        }
    }

    static Map<String, Integer> id1 = new HashMap<>();
    static int idCnt = 0;

    static int[][] dat = new int[100][100];
    static int[] points = new int[100];
    static int[] grade = new int[100];
    static String[] names = new String[100];

    static int[] wed = new int[100];
    static int[] weeken = new int[100];

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        try (BufferedReader br = new BufferedReader(new FileReader(SRC_MAIN_RESOURCES_ATTENDANCE_WEEKDAY_500_TXT))) {
            for (int i = 0; i < 500; i++) {
                if (splitPartAndBreak(br)) break;
            }

            for (int i = 1; i <= idCnt; i++) {
                if (isWednesdaysMoreThen10Times(i)) {
                    points[i] += BONUS_POINT;
                }

                if (isWeekendMoreThen10Times(i)) {
                    points[i] += BONUS_POINT;
                }

                if (isLargerThan50Points(i)) {
                    grade[i] = GOLD;
                } else if (isBetween30And50Points(i)) {
                    grade[i] = SILVER;
                } else {
                    grade[i] = NORMAL;
                }

                System.out.print("NAME : " + names[i] + ", ");
                System.out.print("POINT : " + points[i] + ", ");
                System.out.print("GRADE : ");

                if (isGoldPlayer(i)) {
                    System.out.println("GOLD");
                } else if (isSilverPlayer(i)) {
                    System.out.println("SILVER");
                } else {
                    System.out.println("NORMAL");
                }
            }

            System.out.println();
            System.out.println("Removed player");
            System.out.println("==============");
            for (int i = 1; i <= idCnt; i++) {
                if (isRemovedPlayer(i)) {
                    System.out.println(names[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean splitPartAndBreak(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null) return true;

        String[] parts = line.split("\\s+");
        if (isCorrectParts(parts)) {
            basicAttendanceScoreCalculation(new Node(parts[0], parts[1]));
        }
        return false;
    }

    private static boolean isCorrectParts(String[] parts) {
        return parts.length == 2;
    }

    public static void basicAttendanceScoreCalculation(Node node) {
        if (!id1.containsKey(node.w)) {
            id1.put(node.w, ++idCnt);
            names[idCnt] = node.w;
        }
        int id2 = id1.get(node.w);

        int addPoint = 0;
        int index = 0;

        switch (node.wk) {
            case "monday":
                index = MONDAY_INDEX;
                addPoint++;
                break;
            case "tuesday":
                index = TUESDAY_INDEX;
                addPoint++;
                break;
            case "wednesday":
                index = WEDNESDAY_INDEX;
                addPoint += WEDNESDAY_POINT;
                wed[id2]++;
                break;
            case "thursday":
                index = THURSDAY_INDEX;
                addPoint++;
                break;
            case "friday":
                index = FRIDAY_INDEX;
                addPoint++;
                break;
            case "saturday":
                index = SATURDAY_INDEX;
                addPoint += SATURDAY_POINT;
                weeken[id2]++;
                break;
            case "sunday":
                index = SUNDAY_INDEX;
                addPoint += SUNDAY_POINT;
                weeken[id2]++;
                break;
        }

        dat[id2][index]++;
        points[id2] += addPoint;
    }

    private static boolean isWednesdaysMoreThen10Times(int i) {
        return dat[i][3] > 9;
    }

    private static boolean isWeekendMoreThen10Times(int i) {
        return dat[i][5] + dat[i][6] > 9;
    }

    private static boolean isLargerThan50Points(int i) {
        return points[i] >= 50;
    }

    private static boolean isBetween30And50Points(int i) {
        return points[i] >= 30;
    }

    private static boolean isGoldPlayer(int i) {
        return grade[i] == 1;
    }

    private static boolean isSilverPlayer(int i) {
        return grade[i] == 2;
    }

    private static boolean isRemovedPlayer(int i) {
        return grade[i] != 1 && grade[i] != 2 && wed[i] == 0 && weeken[i] == 0;
    }
}
