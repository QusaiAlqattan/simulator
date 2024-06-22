import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\qusai\\Desktop\\out_study\\atypon\\assign\\simulator_input\\test_1.txt";

        // read from file
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int taskCount = Integer.parseInt(br.readLine());
        Task[] pool = new Task[taskCount];
        for (int i = 0; i < taskCount; i++) {
            line = br.readLine();
            String[] line_arr = line.split(" ");
            Task n = new Task(i+1, Integer.parseInt(line_arr[0]), Integer.parseInt(line_arr[1]), Integer.parseInt(line_arr[2]));
            pool[i] = n;
        }

        // crete processors
        int p_count = 4;
        Processor[] processors = new Processor[p_count];
        for (int i = 0; i < p_count; i++) {
            processors[i] = (new Processor(i+1));
        }

        // total number of cycles
        int counter = 1;
        int cycleCount = 12;

        // create pool
        Scheduler.createPool(pool);

        while (counter <= cycleCount) {
            Clock.tic(counter, processors);
            counter++;
        }
    }
}