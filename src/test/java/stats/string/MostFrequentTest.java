package stats.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class MostFrequentTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        MostFrequent stats = new MostFrequent();
        assertEquals("most_frequent_word", stats.name());
    }

    @Test
    public void update_ShouldUpdateStats() {
        MostFrequent stats = new MostFrequent();

        // initial value
        assertNull(stats.get());

        stats.update("a");
        assertEquals("a", stats.get());

        stats.update("bc");
        assertEquals("a", stats.get());

        stats.update("bc");
        assertEquals("bc", stats.get());
    }
}
