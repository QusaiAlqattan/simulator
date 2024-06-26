import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {
    static void run(int p_count, int cycleCount, String filePath) throws IOException, InterruptedException {

        // read from file
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int taskCount = Integer.parseInt(br.readLine());
        Task[] pool = new Task[taskCount];
        for (int i = 0; i < taskCount; i++) {
            // validate input
            int int1;
            int int2;
            int int3;

            try{
                line = br.readLine();
                String[] line_arr = line.split(" ");
                int1 = Integer.parseInt(line_arr[0]);
                int2 = Integer.parseInt(line_arr[1]);
                int3 = Integer.parseInt(line_arr[2]);
            }catch (IOException e) {
                System.out.println("Error reading from file: " + e.getMessage());
                return;
            }catch (NumberFormatException e){
                System.out.println("A line contains a nun numeric character: " + e.getMessage());
                return;
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("A line is missing a number");
                return;
            }

            Task n = new Task(i+1, int1, int2, int3);
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
