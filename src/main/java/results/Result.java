package results;

/**
 * Stats value returned by a statistical engine
 */
public class Result {
    private final String name;
    private final String result;

    public Result(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
