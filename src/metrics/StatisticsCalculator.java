package metrics;

import java.util.List;

public class StatisticsCalculator {

    public double averageWaitingTime(
            List<ProcessResult> results) {

        int total = 0;

        for (ProcessResult r : results) {
            total += r.getWaitingTime();
        }

        return (double) total / results.size();
    }

    public double averageTurnaroundTime(
            List<ProcessResult> results) {

        int total = 0;

        for (ProcessResult r : results) {
            total += r.getTurnaroundTime();
        }

        return (double) total / results.size();
    }
}
