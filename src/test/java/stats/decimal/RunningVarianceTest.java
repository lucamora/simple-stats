package stats.decimal;

import org.junit.Test;

import static org.junit.Assert.*;

public class RunningVarianceTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        RunningVariance stats = new RunningVariance();
        assertEquals("variance", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        RunningVariance stats = new RunningVariance();

        // initial value
        assertEquals(0.0, stats.get(), 0.001);

        stats.update(3.0f);
        assertEquals(0.0, stats.get(), 0.001);

        stats.update(3.0f);
        assertEquals(0.0, stats.get(), 0.001);

        stats.update(12.0f);
        assertEquals(18.0, stats.get(), 0.001);
    }
}
