//import java.util.LinkedList;
import java.util.PriorityQueue;

public class Scheduler {
    static private PriorityQueue<Task> queue = new PriorityQueue<>();
    static private Task[] pool;

    // fills the pool with the created gives tasks
    static void createPool(Task[] pool) {
        Scheduler.pool = pool;
    }

    // copied the created tasks from the pool to the queue
    static void updateQueue(int clockCount) {
        for (Task task : pool) {
            if (task.getStartCycle() == clockCount) {
                queue.add(task);
            }
        }
//        for (Task task : queue) {
//            System.out.println(task.getId());
//            System.out.println(task.getStartCycle());
//            System.out.println(task.getExecutionTime());
//            System.out.println(task.getPriority());
//            System.out.println("###########################33");
//        }
    }

    // assigns tasks to the idle processors
    static void assignTasks(Processor[] processors) {
        for (Processor p : processors) {
            if(p.getState().equals("Idle")) {
                if (!queue.isEmpty()) {
                    // get task from queue
                    Task highestPriorityTask = queue.poll();
                    p.setTask(highestPriorityTask);
                    System.out.println("******************************");
                    System.out.println("Assign T" + highestPriorityTask.getId() + " to P" + p.getId());
                    System.out.println("******************************");
                    queue.remove(highestPriorityTask);
                }
            }
        }
    }
}
