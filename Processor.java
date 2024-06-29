import java.util.Objects;

public class Processor implements Processor_int{
    private final int id;
    private Task t = null;
    private String state = "Idle";
    private int passedCycles = 0;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Task getTask() {
        return t;
    }

    @Override
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

    @Override
    public int removeTask(){
        if (t != null){
            int id = this.t.getId();
            this.t = null;
            return id;
        }
        return 0;
    }

    @Override
    public String getState(){
        return state;
    }

    @Override
    public void updateState(int clockCount){
        passedCycles++;
        if (t == null || passedCycles == t.getExecutionTime()) {
//            if (this.id == 2) {
//                System.out.println("Processor should be Idel");
//            }
            this.removeTask();
            this.state = "Idle";
            passedCycles = 0;
        }
        else{
            this.state = "Busy";
        }
//        if (this.id == 2){
//            System.out.println("Clock count: " + clockCount);
//            System.out.println("State: " + state);
//            System.out.println("Passed cycles: " + passedCycles);
//            if (t != null){
//                System.out.println("Task: " + t.getId());
//                System.out.println("Duration: " + t.getExecutionTime());
//            }
//            System.out.println("###########################################");
//        }
    }
}
