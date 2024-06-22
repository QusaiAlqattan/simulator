public class Task implements Comparable<Task>{
    private final int id;
    private final int startCycle;
    private final int executionTime;
    private final int priority;
    private String state = "In Pool";

    public Task(int id, int startCycle, int executionTime, int priority){
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int compareTo(Task other) {
        // Compare tasks based on priority and duration
        if (this.priority == other.priority) {
            if (this.executionTime <= other.executionTime) {
                return -1;
            }else{
                return +1;
            }
        } else if (this.priority < other.priority) {
            return -1;
        }else {
            return +1;
        }
    }
}
