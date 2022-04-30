package stats.integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinValueTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        MinValue stats = new MinValue();
        assertEquals("min_value", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        MinValue stats = new MinValue();

        // initial value
        assertEquals(0, (int)stats.get());

        stats.update(5);
        assertEquals(5, (int)stats.get());

        stats.update(-18);
        assertEquals(-18, (int)stats.get());

        stats.update(-50);
        assertEquals(-50, (int)stats.get());
    }
}
