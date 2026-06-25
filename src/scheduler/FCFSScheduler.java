package scheduler;
import java.util.*;
import process.Process;
import metrics.ProcessResult;

public class FCFSScheduler extends Scheduler {
    @Override
    public List<ProcessResult> schedule(List<Process> processes){

        List<Process> sorted=new ArrayList<>(processes);
        sorted.sort(Comparator.comparingInt(Process::getArrivalTime));

        List<ProcessResult>result=new ArrayList<>();

        int currTime=0;

        for(Process p:sorted){
            if(currTime<p.getArrivalTime()){
                currTime=p.getArrivalTime();
            }
            currTime+=p.getBurstTime();
            int completionTime=currTime;
            int turnaroundTime=completionTime-p.getArrivalTime();
            int waitingTime=turnaroundTime-p.getBurstTime();
            result.add(new ProcessResult(p.getId(),completionTime,turnaroundTime,waitingTime));
        }
        return result;
    }
}
