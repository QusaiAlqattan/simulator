import java.util.Objects;

public interface Processor_int {
    int getId();

    Task getTask();

    void setTask(Task t);

    int removeTask();

    String getState();

    void updateState(int clockCount);
}