package engines;

import org.junit.Test;

import static org.junit.Assert.*;

public class EngineFactoryTest {
    @Test
    public void getSource_Integer_ShouldReturnCorrectSource() {
        EngineFactory factory = new EngineFactory();
        Engine engine = factory.getEngine("integer");

        assertTrue(engine instanceof IntegerEngine);
    }

    @Test
    public void getSource_Decimal_ShouldReturnCorrectSource() {
        EngineFactory factory = new EngineFactory();
        Engine engine = factory.getEngine("decimal");

        assertTrue(engine instanceof DecimalEngine);
    }

    @Test
    public void getSource_String_ShouldReturnCorrectSource() {
        EngineFactory factory = new EngineFactory();
        Engine engine = factory.getEngine("string");

        assertTrue(engine instanceof StringEngine);
    }
}
