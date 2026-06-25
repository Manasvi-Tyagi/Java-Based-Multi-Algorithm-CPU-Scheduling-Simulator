import input.*;
import scheduler.*;
import process.Process;
import report.*;
import metrics.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ProcessInput input = new ProcessInput();
        List<Process> processes = input.createProcesses();

        StatisticsCalculator stats =new StatisticsCalculator();

        
        System.out.println("\n\nFirst-Come, First-Served Scheduling Results:");
        Scheduler fcfsScheduler = new FCFSScheduler();
        List<ProcessResult> fcfsResults = fcfsScheduler.schedule(processes);

        ReportGenerator fcfsreportGenerator = new ConsoleReportGenerator();
        fcfsreportGenerator.generate(fcfsResults);
        System.out.println("Average Waiting Time: " + stats.averageWaitingTime(fcfsResults));
        System.out.println("Average Turnaround Time: " + stats.averageTurnaroundTime(fcfsResults));


        System.out.println("\n\nPriority Scheduling Results:");
        Scheduler pScheduler = new PriorityScheduler();
        List<ProcessResult> pResults = pScheduler.schedule(processes);

        ReportGenerator preportGenerator = new ConsoleReportGenerator();
        preportGenerator.generate(pResults);
        System.out.println("Average Waiting Time: " + stats.averageWaitingTime(pResults));
        System.out.println("Average Turnaround Time: " + stats.averageTurnaroundTime(pResults));


        System.out.println("\n\nRound-Robin Scheduling Results:");
        Scheduler rrScheduler = new RoundRobinScheduler(3);
        List<ProcessResult> rrResults = rrScheduler.schedule(processes);

        ReportGenerator rrreportGenerator = new ConsoleReportGenerator();
        rrreportGenerator.generate(rrResults);
        System.out.println("Average Waiting Time: " + stats.averageWaitingTime(rrResults));
        System.out.println("Average Turnaround Time: " + stats.averageTurnaroundTime(rrResults));


        System.out.println("\n\nShortest Job First Scheduling Results:");
        Scheduler sjfScheduler = new ShortestJobFirst();
        List<ProcessResult> sjfResults = sjfScheduler.schedule(processes);

        ReportGenerator sjfreportGenerator = new ConsoleReportGenerator();
        sjfreportGenerator.generate(sjfResults);
        System.out.println("Average Waiting Time: " + stats.averageWaitingTime(sjfResults));
        System.out.println("Average Turnaround Time: " + stats.averageTurnaroundTime(sjfResults));
    }
}