package engines;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import results.Result;

import java.util.List;

import static org.junit.Assert.*;

public class StringEngineTest {
    private static EngineFactory factory;
    private Engine engine;

    @BeforeClass
    public static void setup() {
        // create an EngineFactory instance when starting tests
        factory = new EngineFactory();
    }

    @Before
    public void init() {
        // create a new Engine instance before each test
        engine = factory.getEngine("string");
    }

    @Test
    public void type_ShouldReturnCorrectType() {
        assertEquals("string", engine.type());
    }

    @Test
    public void stats_InvalidName_ShouldReturnNull() {
        Result stats = engine.stats("invalid");

        assertNull(stats);
    }

    @Test
    public void stats_CorrectName_ShouldReturnStats() {
        Result stats = engine.stats("shortest_word");

        assertNotNull(stats);
        assertEquals("shortest_word", stats.getName());
        assertNull(stats.getResult());
    }

    @Test
    public void ingest_ShouldUpdateStats() {
        String data = "abc";

        // check shortest word before ingestion
        String shortestBefore = engine.stats("shortest_word").getResult();
        assertNull(shortestBefore);

        boolean success = engine.ingest(data);
        assertTrue(success);

        // check shortest word after ingestion
        String shortestAfter = engine.stats("shortest_word").getResult();
        assertEquals("abc", shortestAfter);
    }

    @Test
    public void export_ShouldReturnStatsList() {
        // add some data
        engine.ingest("abcdefg");
        engine.ingest("a");
        engine.ingest("abc");
        engine.ingest("ab");
        engine.ingest("abc");
        engine.ingest("aaabbbcccddd");

        // export statistics
        List<Result> statistics = engine.export();

        // check array size
        assertEquals(4, statistics.size());

        // check shortest word
        assertEquals("shortest_word", statistics.get(0).getName());
        String shortest = statistics.get(0).getResult();
        assertEquals("a", shortest);

        // check longest word
        assertEquals("longest_word", statistics.get(1).getName());
        String longest = statistics.get(1).getResult();
        assertEquals("aaabbbcccddd", longest);

        // check most frequent word
        assertEquals("most_frequent_word", statistics.get(2).getName());
        String frequent = statistics.get(2).getResult();
        assertEquals("abc", frequent);

        // check most symbols word
        assertEquals("most_symbols_word", statistics.get(3).getName());
        String symbols = statistics.get(3).getResult();
        assertEquals("abcdefg", symbols);
    }
}
