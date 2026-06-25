package report;
import java.util.List;
import metrics.ProcessResult;
public class ConsoleReportGenerator implements ReportGenerator {
    @Override
    public void generate(List<ProcessResult> results) {
        System.out.println("Process ID\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (ProcessResult result : results) {
            System.out.printf("%d\t\t\t\t%d\t\t\t\t%d\t\t\t\t%d%n",
                    result.getProcessId(),
                    result.getCompletionTime(),
                    result.getTurnaroundTime(),
                    result.getWaitingTime());
        }
    }
}
