package mission2.file;

import mission2.Attendance_mission2;
import mission2.day.Day;
import mission2.score.ScoreCalculator;
import mission2.score.ScorePerson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileProcess {
    private final Map<String, ScorePerson> personMap = new HashMap<>();
    private String path;


    public FileProcess(String path) {
        this.path = path;
    }

    public Map<String, ScorePerson> fileProcessing(ScoreCalculator scoreCalculator) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (int i = 0; i < 500; i++) {
                String line = br.readLine();
                if (isLineEqualsNull(line)) break;

                String[] parts = line.split("\\s+");
                if(!isCorrectParts(parts)) continue;

                String name = parts[0];
                String day = parts[1];

                // name 이 처음 들어오면 초기화
                personMap.put(name, personMap.getOrDefault(name, new ScorePerson(name)));

                ScorePerson sp = personMap.get(name);
                sp = scoreCalculator.basicScoreCalculation(sp, Day.from(day));
                personMap.replace(name, sp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return personMap;
    }

    private static boolean isLineEqualsNull(String line) {
        return line == null;
    }

    private static boolean isCorrectParts(String[] parts) {
        return parts.length == 2;
    }
}
