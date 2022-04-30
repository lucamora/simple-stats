package sources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ConsoleSource extends Source {
    private BufferedReader reader;
    private boolean stop;

    @Override
    public void setup() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        stop = false;
    }

    @Override
    public void process() {
        while (!stop) {
            String data;
            try {
                data = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (!data.isEmpty()) {
                notifyObservers(data);
            }
            else {
                stop = true;
            }
        }
    }
}
