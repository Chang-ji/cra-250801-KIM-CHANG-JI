package mission2.day;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayTest {

    @Test
    void fromException() {
        assertThrows(RuntimeException.class, () -> Day.from("aaaa"));
    }
}