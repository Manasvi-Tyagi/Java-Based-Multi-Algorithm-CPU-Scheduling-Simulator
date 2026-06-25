package input;
import java.util.*;
import process.Process;

public class ProcessInput {
    public List<Process> createProcesses(){
        List<Process> processes=new ArrayList<>();
        processes.add(new Process(1,0,5,2));
        processes.add(new Process(2,1,3,1));
        processes.add(new Process(3,2,8,4));
        processes.add(new Process(4,3,6,3));
        return processes;
    }
    
}
