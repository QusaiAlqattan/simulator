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
        int totalCount = Integer.parseInt(br.readLine());
        Task[] pool = new Task[totalCount];
        for (int i = 0; i < totalCount; i++) {
            line = br.readLine();
            String[] line_arr = line.split(" ");
            Task n = new Task(i, Integer.parseInt(line_arr[0]), Integer.parseInt(line_arr[1]), Integer.parseInt(line_arr[2]));
            pool[i] = n;
        }

        Scheduler.createPool(pool);
    }
}