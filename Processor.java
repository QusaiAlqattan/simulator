import java.util.Objects;

public class Processor {
    private final int id;
    private Task t = null;
    private String state = "Idle";

    public Processor(int id, Task t) {
        this.id = id;
        this.t = t;
    }

    public int getId() {
        return id;
    }

    public Task getTask() {
        return t;
    }

    public void setTask(Task t) {
        // check state
        if (Objects.equals(this.state, "Idle")) {
            this.t = t;
            this.state = "Busy";
        } else {
            // Throw exception and say the processor is busy
            throw new IllegalStateException("Processor is busy");
        }
    }

    public int removeTask(){
        int id = this.t.getId();
        this.t = null;
        return id;
    }

    public String getState(){
        return state;
    }

    public void updateState(int clockCount){
        if (clockCount == t.getExecutionTime() + t.getStartCycle()) {
            this.removeTask();
            this.state = "Idle";
        }
        else{
            this.state = "Busy";
        }
    }
}
