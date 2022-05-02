package engines;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import results.Result;

import java.util.List;

import static org.junit.Assert.*;

public class DecimalEngineTest {
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
        engine = factory.getEngine("decimal");
    }

    @Test
    public void type_ShouldReturnCorrectType() {
        assertEquals("decimal", engine.type());
    }

    @Test
    public void stats_InvalidName_ShouldReturnNull() {
        Result stats = engine.stats("invalid");

        assertNull(stats);
    }

    @Test
    public void stats_CorrectName_ShouldReturnStats() {
        Result stats = engine.stats("average");

        assertNotNull(stats);
        assertEquals("average", stats.getName());
        assertEquals("0.000", stats.getResult());
    }

    @Test
    public void ingest_InvalidNumber_ShouldDiscardValue() {
        String data = "3.a";

        // check average before ingestion
        float avgBefore = Float.parseFloat(engine.stats("average").getResult());
        assertEquals(0.0, avgBefore, 0.001);

        boolean success = engine.ingest(data);
        assertFalse(success);

        // check average after ingestion
        float avgAfter = Float.parseFloat(engine.stats("average").getResult());
        assertEquals(0.0, avgAfter, 0.001);
    }

    @Test
    public void ingest_ValidNumber_ShouldUpdateStats() {
        String data = "3.2";

        // check average before ingestion
        float avgBefore = Float.parseFloat(engine.stats("average").getResult());
        assertEquals(0.0, avgBefore, 0.001);

        boolean success = engine.ingest(data);
        assertTrue(success);

        // check average after ingestion
        float avgAfter = Float.parseFloat(engine.stats("average").getResult());
        assertEquals(3.2, avgAfter, 0.001);
    }

    @Test
    public void export_ShouldReturnStatsList() {
        // add some data
        engine.ingest("2.0");
        engine.ingest("3.0");
        engine.ingest("4.0");
        engine.ingest("5.0");

        // export statistics
        List<Result> statistics = engine.export();

        // check array size
        assertEquals(3, statistics.size());

        // check average
        assertEquals("average", statistics.get(0).getName());
        float average = Float.parseFloat(statistics.get(0).getResult());
        assertEquals(3.5, average, 0.001);

        // check variance
        assertEquals("variance", statistics.get(1).getName());
        float variance = Float.parseFloat(statistics.get(1).getResult());
        assertEquals(1.25, variance, 0.001);

        // check range
        assertEquals("range", statistics.get(2).getName());
        float range = Float.parseFloat(statistics.get(2).getResult());
        assertEquals(3.0, range, 0.001);
    }
}
