public class Processor {
    private final int id;
    private Task t = null;

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
        if (this.t == null) {
            this.t = t;
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

    public boolean isIdle(){
        return t == null;
    }
}
