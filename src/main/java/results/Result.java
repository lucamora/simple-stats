package results;

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
