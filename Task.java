public class Task implements Comparable<Task>, Task_int{
    private final int id;
    private final int startCycle;
    private final int executionTime;
    private final int priority;

    public Task(int id, int startCycle, int executionTime, int priority){
        this.id = id;
        this.startCycle = startCycle;
        this.executionTime = executionTime;
        this.priority = priority;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getStartCycle() {
        return startCycle;
    }

    @Override
    public int getExecutionTime() {
        return executionTime;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    // compares tasks based on there priority, and execution time
    @Override
    public int compareTo(Task other) {
        // Compare tasks based on priority and duration
        if (this.priority == other.priority) {
            return Integer.compare(other.executionTime, this.executionTime);
        } else if (this.priority < other.priority) {
            return +1;
        }else {
            return -1;
        }
    }
}
