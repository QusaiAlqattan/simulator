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
//        for (Task task : queue) {
//            System.out.println(task.getId());
//            System.out.println(task.getStartCycle());
//            System.out.println(task.getExecutionTime());
//            System.out.println(task.getPriority());
//            System.out.println("###########################33");
//        }
    }

    static void assignTasks(Processor[] processors) {
        if (!queue.isEmpty()) {
            for (Processor p : processors) {
                if(p.getState().equals("Idle")) {
                    // get task from queue
                    Task highestPriorityTask = findHighestPriorityTask();
                    p.setTask(highestPriorityTask);
                    System.out.println("*****************************");
                    System.out.println(highestPriorityTask.getId());
                    System.out.println("******************************");
                    queue.remove(highestPriorityTask);
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
