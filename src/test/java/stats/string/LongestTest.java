package stats.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        Longest stats = new Longest();
        assertEquals("longest_word", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        Longest stats = new Longest();

        // initial value
        assertNull(stats.get());

        stats.update("abcd");
        assertEquals("abcd", stats.get());

        stats.update("a");
        assertEquals("abcd", stats.get());

        stats.update("abcdef");
        assertEquals("abcdef", stats.get());
    }
}
