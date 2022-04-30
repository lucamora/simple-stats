import engines.*;
import results.Result;
import sources.ConsoleSource;
import sources.Source;
import sources.SourceFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SimpleStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("> starting simple stats");

        System.out.println("> select stats engine: [string|decimal|integer]");
        String eng = reader.readLine();

        System.out.println("> select data source: [console]");
        String src = reader.readLine();

        // create statistics engine
        EngineFactory engineFactory = new EngineFactory();
        Engine engine = engineFactory.getEngine(eng);

        // check if engine has been created
        if (engine == null) {
            System.out.println("> invalid engine");
            return;
        }

        // create data source
        SourceFactory sourceFactory = new SourceFactory();
        Source source = sourceFactory.getSource(src);

        // check if source has been created
        if (source == null) {
            System.out.println("> invalid source");
            return;
        }

        // configure source
        source.setup();

        // register engine to data source
        source.addObserver(engine);

        System.out.println("> loading data");

        // process data source
        source.process();

        System.out.println("> exporting stats");

        // get exported results
        List<Result> statistics = engine.export();

        // print results in YAML format
        System.out.printf("results:\n  engine: %s\n  stats:\n", engine.type());
        for (Result res : statistics) {
            System.out.printf("    - name: %s\n", res.getName());
            System.out.printf("      value: %s\n", res.getResult());
        }
    }
}