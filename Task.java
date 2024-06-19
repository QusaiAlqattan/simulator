public class Task {
    private final int id;
    private final int startCycle;
    private final int executionTime;
    private final int priority;

    public Task(int id, int startCycle, int executionTime, int priority) {
        this.id = id;
        this.startCycle = startCycle;
        this.executionTime = executionTime;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getStartCycle() {
        return startCycle;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getPriority() {
        return priority;
    }

}
