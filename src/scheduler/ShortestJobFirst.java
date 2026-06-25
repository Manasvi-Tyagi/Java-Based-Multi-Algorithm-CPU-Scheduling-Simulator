package scheduler;
import process.Process;
import metrics.ProcessResult;
import java.util.*;

public class ShortestJobFirst extends Scheduler {
@Override
public List<ProcessResult> schedule(List<Process> processes) {

    List<ProcessResult> results = new ArrayList<>();

    List<Process> remaining = new ArrayList<>(processes);

    int currentTime = 0;

    while (!remaining.isEmpty()) {

        Process shortest = null;

        for (Process p : remaining) {
            if (p.getArrivalTime() <= currentTime) {

                if (shortest == null ||
                    p.getBurstTime() < shortest.getBurstTime()) {
                    shortest = p;
                }
            }
        }

        if (shortest == null) {
            currentTime++;
            continue;
        }

        currentTime += shortest.getBurstTime();

        int completionTime = currentTime;
        int turnaroundTime =
                completionTime - shortest.getArrivalTime();
        int waitingTime =
                turnaroundTime - shortest.getBurstTime();

        results.add(
            new ProcessResult(
                shortest.getId(),
                completionTime,
                turnaroundTime,
                waitingTime
            )
        );

        remaining.remove(shortest);
    }

    return results;
}
}