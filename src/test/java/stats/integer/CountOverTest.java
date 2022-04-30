package stats.integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountOverTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        CountOver stats = new CountOver(10);
        assertEquals("count_over_10", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        CountOver stats = new CountOver(10);

        // initial value
        assertEquals(0, (int)stats.get());

        stats.update(9);
        assertEquals(0, (int)stats.get());

        stats.update(14);
        assertEquals(1, (int)stats.get());

        stats.update(5);
        assertEquals(1, (int)stats.get());
    }
}
