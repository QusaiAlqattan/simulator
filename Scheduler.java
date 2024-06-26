//import java.util.LinkedList;
import java.util.PriorityQueue;

public class Scheduler {
    static private PriorityQueue<Task> queue = new PriorityQueue<>();
    static private Task[] pool;

    static void createPool(Task[] pool) {
        Scheduler.pool = pool;
    }

    static void updateQueue(int clockCount) {
        for (Task task : pool) {
            if (task.getStartCycle() == clockCount) {
                queue.add(task);
                task.setState("In Queue");
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
                    highestPriorityTask.setState("In Processor");
                }
            }
        }
    }

//    static Task findHighestPriorityTask(){
//        Task highestPriorityTask = null;
//
//        for (Task task : queue) {
//            if (highestPriorityTask == null || highestPriorityTask.compareTo(task) < 0) {
//                highestPriorityTask = task;
//            }
//        }
//
//        return highestPriorityTask;
//    }
}
