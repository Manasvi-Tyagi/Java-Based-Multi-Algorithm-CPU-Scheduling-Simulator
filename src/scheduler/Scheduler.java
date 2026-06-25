package scheduler;
import java.util.List;
import process.Process;
import metrics.ProcessResult;

public abstract class Scheduler {
    public abstract List<ProcessResult> schedule(List<Process> processes);
}
