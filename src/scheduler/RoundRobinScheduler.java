package scheduler;
import java.util.*;
import process.Process;
import metrics.ProcessResult;

public class RoundRobinScheduler extends Scheduler{
    private int quantum;
    public RoundRobinScheduler(int quantum){
        this.quantum=quantum;
    }
    @Override
    public List<ProcessResult> schedule(List<Process> processes){
        List<ProcessResult> result = new ArrayList<>();


        if(processes==null || processes.isEmpty()){
            return result;
        }
        List<Process> sorted=new ArrayList<>(processes);
        sorted.sort(Comparator.comparingInt(Process::getArrivalTime));

        Queue<Process> readyQueue = new LinkedList<>();
        int currentTime = sorted.get(0).getArrivalTime();
        int nextArrival=0;
int completed = 0;
        int totalProcesses = sorted.size();

        while (nextArrival < totalProcesses &&
                sorted.get(nextArrival).getArrivalTime() <= currentTime) {

            readyQueue.offer(sorted.get(nextArrival));
            nextArrival++;
        }

        while (completed < totalProcesses) {

            if (readyQueue.isEmpty()) {

                currentTime =
                        sorted.get(nextArrival)
                                .getArrivalTime();

                while (nextArrival < totalProcesses &&
                        sorted.get(nextArrival)
                                .getArrivalTime() <= currentTime) {

                    readyQueue.offer(
                            sorted.get(nextArrival)
                    );

                    nextArrival++;
                }

                continue;
            }

            Process current = readyQueue.poll();

            int executeTime = Math.min(
                    quantum,
                    current.getRemainingTime()
            );

            current.execute(executeTime);

            currentTime += executeTime;

            while (nextArrival < totalProcesses &&
                    sorted.get(nextArrival)
                            .getArrivalTime() <= currentTime) {

                readyQueue.offer(
                        sorted.get(nextArrival)
                );

                nextArrival++;
            }

            if (current.getRemainingTime() > 0) {

                readyQueue.offer(current);

            } else {

                completed++;

                int completionTime = currentTime;

                int turnaroundTime =
                        completionTime
                                - current.getArrivalTime();

                int waitingTime =
                        turnaroundTime
                                - current.getBurstTime();

                result.add(
                        new ProcessResult(
                                current.getId(),
                                completionTime,
                                waitingTime,
                                turnaroundTime
                        )
                );
            }
        }

        return result;
    }
}
