package stats.decimal;

import org.junit.Test;

import static org.junit.Assert.*;

public class RunningAverageTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        RunningAverage stats = new RunningAverage();
        assertEquals("average", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        RunningAverage stats = new RunningAverage();

        // initial value
        assertEquals(0.0, stats.get(), 0.001);

        stats.update(1.0f);
        assertEquals(1.0, stats.get(), 0.001);

        stats.update(5.0f);
        assertEquals(3.0, stats.get(), 0.001);

        stats.update(30.0f);
        assertEquals(12.0, stats.get(), 0.001);
    }
}
