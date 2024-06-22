import java.util.LinkedList;

public abstract class Scheduler {
    static LinkedList<Task> queue = new LinkedList<>();
    static Task[] pool;

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
    }

    static void assignTasks(Processor[] processors) {
        for (Processor p : processors) {
            if(p.getState().equals("Idle")) {
                // get task from queue
                for (Task task : queue) {
                    Task highestPriorityTask = findHighestPriorityTask();
                    p.setTask(highestPriorityTask);
                }
            }
        }
    }

    static Task findHighestPriorityTask(){
        Task highestPriorityTask = null;

        for (Task task : queue) {
            if (highestPriorityTask == null || highestPriorityTask.compareTo(task) < 0) {
                highestPriorityTask = task;
            }
        }

        return highestPriorityTask;
    }
}
