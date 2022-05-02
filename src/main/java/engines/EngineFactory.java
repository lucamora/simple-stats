package engines;

/**
 * Creates a new statistical engine defined by the given type
 * Reference: https://sourcemaking.com/design_patterns/factory_method
 */
public class EngineFactory {
    public Engine getEngine(String type) {
        type = type.trim().toLowerCase();

        switch (type) {
            case "integer":
                return new IntegerEngine();
            case "decimal":
                return new DecimalEngine();
            case "string":
                return new StringEngine();
            default:
                return null;
        }
    }
}
