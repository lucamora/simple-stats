package stats.integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        Sum stats = new Sum();
        assertEquals("sum", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        Sum stats = new Sum();

        // initial value
        assertEquals(0, (int)stats.get());

        stats.update(9);
        assertEquals(9, (int)stats.get());

        stats.update(14);
        assertEquals(23, (int)stats.get());

        stats.update(100);
        assertEquals(123, (int)stats.get());
    }
}
