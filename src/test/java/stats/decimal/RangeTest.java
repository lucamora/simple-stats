package stats.decimal;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        Range stats = new Range();
        assertEquals("range", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        Range stats = new Range();

        // initial value
        assertEquals(0.0, stats.get(), 0.001);

        stats.update(1.0f);
        assertEquals(0.0, stats.get(), 0.001);

        stats.update(3.0f);
        assertEquals(2.0, stats.get(), 0.001);

        stats.update(-5.0f);
        assertEquals(8.0, stats.get(), 0.001);
    }
}
