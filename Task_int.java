public interface Task_int {
    int getId();

    int getStartCycle();

    int getExecutionTime();

    int getPriority();

    String getState();

    void setState(String state);

    int compareTo(Task other);
}
