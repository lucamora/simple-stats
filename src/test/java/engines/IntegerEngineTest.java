package engines;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import results.Result;

import java.util.List;

import static org.junit.Assert.*;

public class IntegerEngineTest {
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
        engine = factory.getEngine("integer");
    }

    @Test
    public void type_ShouldReturnCorrectType() {
        assertEquals("integer", engine.type());
    }

    @Test
    public void stats_InvalidName_ShouldReturnNull() {
        Result stats = engine.stats("invalid");

        assertNull(stats);
    }

    @Test
    public void stats_CorrectName_ShouldReturnStats() {
        Result stats = engine.stats("min_value");

        assertNotNull(stats);
        assertEquals("min_value", stats.getName());
        assertEquals("0", stats.getResult());
    }

    @Test
    public void ingest_InvalidNumber_ShouldDiscardValue() {
        String data = "b";

        // check sum before ingestion
        int sumBefore = Integer.parseInt(engine.stats("sum").getResult());
        assertEquals(0, sumBefore);

        boolean success = engine.ingest(data);
        assertFalse(success);

        // check sum after ingestion
        int sumAfter = Integer.parseInt(engine.stats("sum").getResult());
        assertEquals(0, sumAfter);
    }

    @Test
    public void ingest_ValidNumber_ShouldUpdateStats() {
        String data = "5";

        // check sum before ingestion
        int sumBefore = Integer.parseInt(engine.stats("sum").getResult());
        assertEquals(0, sumBefore);

        boolean success = engine.ingest(data);
        assertTrue(success);

        // check sum after ingestion
        int sumAfter = Integer.parseInt(engine.stats("sum").getResult());
        assertEquals(5, sumAfter);
    }

    @Test
    public void export_ShouldReturnStatsList() {
        // add some data
        engine.ingest("2");
        engine.ingest("3");
        engine.ingest("4");
        engine.ingest("5");
        engine.ingest("110");

        // export statistics
        List<Result> statistics = engine.export();

        // check array size
        assertEquals(5, statistics.size());

        // check min value
        assertEquals("min_value", statistics.get(0).getName());
        int min = Integer.parseInt(statistics.get(0).getResult());
        assertEquals(2, min);

        // check max value
        assertEquals("max_value", statistics.get(1).getName());
        int max = Integer.parseInt(statistics.get(1).getResult());
        assertEquals(110, max);

        // check count
        assertEquals("count", statistics.get(2).getName());
        int count = Integer.parseInt(statistics.get(2).getResult());
        assertEquals(5, count);

        // check count over 100
        assertEquals("count_over_100", statistics.get(3).getName());
        int countOver = Integer.parseInt(statistics.get(3).getResult());
        assertEquals(1, countOver);

        // check sum
        assertEquals("sum", statistics.get(4).getName());
        int sum = Integer.parseInt(statistics.get(4).getResult());
        assertEquals(124, sum);
    }
}
