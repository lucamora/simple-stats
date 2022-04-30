package stats.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        Shortest stats = new Shortest();
        assertEquals("shortest_word", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        Shortest stats = new Shortest();

        // initial value
        assertNull(stats.get());

        stats.update("abcd");
        assertEquals("abcd", stats.get());

        stats.update("abcde");
        assertEquals("abcd", stats.get());

        stats.update("de");
        assertEquals("de", stats.get());
    }
}
