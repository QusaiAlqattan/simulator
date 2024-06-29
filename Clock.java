public abstract class Clock {
    static void tic(int clockCount, Processor[] processors) {
        // processors update state
        for (Processor processor : processors) {
            processor.updateState(clockCount);
        }

        // update queue
        Scheduler.updateQueue(clockCount);

        // assign tasks
        Scheduler.assignTasks(processors);

        // log
        System.out.println("Clock number: " + clockCount);
        for (Processor processor : processors) {
            System.out.println("P"+ processor.getId() + " state: " + processor.getState());
            if (processor.getTask() != null)
                System.out.println("P"+ processor.getId() + " assigned T" + processor.getTask().getId());
        }
        System.out.println("###############################################");
    }
}
