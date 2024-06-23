import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Simulator.run(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
    }
}