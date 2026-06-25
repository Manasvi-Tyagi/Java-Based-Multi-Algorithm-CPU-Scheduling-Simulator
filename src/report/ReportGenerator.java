package report;

import java.util.List;
import metrics.ProcessResult;

public interface ReportGenerator {

    void generate(
            List<ProcessResult> results);
}