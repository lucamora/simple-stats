package sources;

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
