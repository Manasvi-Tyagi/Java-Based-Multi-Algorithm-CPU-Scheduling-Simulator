package process;

public class Process{
   private int id;    //encapsulation
   private int burstTime; 
   private int arrivalTime;
   private int priority;
   private int remainingTime;
   public Process(int id, int burstTime, int arrivalTime, int priority){
       this.id=id;
       this.burstTime=burstTime;
       this.arrivalTime=arrivalTime;
       this.priority=priority;
       this.remainingTime=burstTime;

   }
   public int getId(){
        return id;
    }
    public int getBurstTime(){
        return burstTime;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getPriority(){
        return priority;
    }
    public int getRemainingTime(){
        return remainingTime;
    }
    public void execute(int Time){
        this.remainingTime-=Time;
    }
}



