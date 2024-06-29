public interface Task_int {
    int getId();

    int getStartCycle();

    int getExecutionTime();

    int getPriority();

    int compareTo(Task other);
}
