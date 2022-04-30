package stats.integer;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        Count stats = new Count();
        assertEquals("count", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        Count stats = new Count();

        // initial value
        assertEquals(0, (int)stats.get());

        stats.update(10);
        assertEquals(1, (int)stats.get());

        stats.update(14);
        assertEquals(2, (int)stats.get());

        stats.update(5);
        assertEquals(3, (int)stats.get());
    }
}
