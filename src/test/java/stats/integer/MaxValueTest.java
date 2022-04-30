package stats.integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxValueTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        MaxValue stats = new MaxValue();
        assertEquals("max_value", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        MaxValue stats = new MaxValue();

        // initial value
        assertEquals(0, (int)stats.get());

        stats.update(-5);
        assertEquals(-5, (int)stats.get());

        stats.update(20);
        assertEquals(20, (int)stats.get());

        stats.update(13);
        assertEquals(20, (int)stats.get());
    }
}
