package metrics;

public class ProcessResult {
    private final int processId;
    private final int completionTime;
    private final int turnaroundTime;
    private final int waitingTime;
    public ProcessResult(int processId, int completionTime, int turnaroundTime, int waitingTime) {
        this.processId = processId;
        this.completionTime = completionTime;
        this.turnaroundTime = turnaroundTime;
        this.waitingTime = waitingTime;
    }
    public int getProcessId() {
        return processId;
    }
    public int getCompletionTime() {
        return completionTime;
    }
    public int getTurnaroundTime() {
        return turnaroundTime;
    }
    public int getWaitingTime() {
        return waitingTime;
    }

}
