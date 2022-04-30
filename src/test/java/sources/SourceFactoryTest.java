package sources;

import org.junit.Test;

import static org.junit.Assert.*;

public class SourceFactoryTest {
    @Test
    public void getSource_Console_ShouldReturnCorrectSource() {
        SourceFactory factory = new SourceFactory();
        Source source = factory.getSource("console");

        assertTrue(source instanceof ConsoleSource);
    }
}
