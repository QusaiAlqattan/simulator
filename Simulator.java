import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Simulator {
    public static void run(int p_count, int cycleCount, String filePath) throws IOException, InterruptedException {

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
        Processor[] processors = new Processor[p_count];
        for (int i = 0; i < p_count; i++) {
            processors[i] = (new Processor(i+1));
        }

        // total number of cycles
        int counter = 1;

        // create pool
        Scheduler.createPool(pool);

        while (counter <= cycleCount) {
            Clock.tic(counter, processors);
            counter++;
            Thread.sleep(1000);
        }
    }
}
