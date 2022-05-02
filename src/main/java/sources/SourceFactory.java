package sources;

/**
 * Creates a new data source defined by the given type
 * Reference: https://sourcemaking.com/design_patterns/factory_method
 */
public class SourceFactory {
    public Source getSource(String type) {
        type = type.trim().toLowerCase();

        switch (type) {
            case "console":
                return new ConsoleSource();
            default:
                return null;
        }
    }
}
