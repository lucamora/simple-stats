package stats.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class MostSymbolsTest {
    @Test
    public void name_ShouldReturnCorrectName() {
        MostSymbols stats = new MostSymbols();
        assertEquals("most_symbols_word", stats.name());
    }

    // TODO: check MostSymbols::update(String value)
    @Test
    public void update_ShouldUpdateStats() {
        MostSymbols stats = new MostSymbols();

        //initial value
        assertNull(stats.get());

        stats.update("istituto");
        assertEquals("istituto", stats.get());

        stats.update("tecnico");
        assertEquals("tecnico", stats.get());

        stats.update("tecnologico");
        assertEquals("tecnologico", stats.get());

        stats.update("marconi");
        assertEquals("tecnologico", stats.get());

        stats.update("5ai");
        assertEquals("tecnologico", stats.get());
    }
}
