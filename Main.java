import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        // Validate input
        if (args.length < 3) {
            System.out.println("Not enough arguments");
            return;
        }

        Path filePath = Paths.get(args[2]);

        if (!Files.exists(filePath) || !Files.isRegularFile(filePath) || !args[2].endsWith(".txt")) {
            System.out.println("Provided path is not valid");
            return;
        }

        int arg0, arg1;

        try {
            arg0 = Integer.parseInt(args[0]);
            arg1 = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("One or both of the first two arguments are not valid integers.");
            return;
        }

        // If all validations pass, run the simulator
        Simulator.run(arg0, arg1, args[2]);
    }
}
