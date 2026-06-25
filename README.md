# Java-Based-Multi-Algorithm-CPU-Scheduling-Simulator



## Overview

Mini Operating System Scheduler is a Java-based simulation of CPU scheduling algorithms designed to demonstrate core Operating System concepts and Object-Oriented Programming principles. The project provides implementations of multiple CPU scheduling strategies and generates performance metrics such as waiting time and turnaround time for comparison.

The system follows a modular architecture where scheduling algorithms, process management, statistics calculation, and reporting are separated into independent components.

---

## Features

* First Come First Serve (FCFS) Scheduling
* Shortest Job First (SJF) Scheduling
* Priority Scheduling
* Round Robin Scheduling
* Waiting Time Calculation
* Turnaround Time Calculation
* Average Waiting Time
* Average Turnaround Time
* Modular Package Structure
* Extensible Scheduler Framework

---

## OOP Concepts Demonstrated

### Encapsulation

Process-related attributes such as process ID, arrival time, burst time, priority, and remaining execution time are encapsulated inside the Process class.

### Abstraction

The abstract Scheduler class defines a common contract for all scheduling algorithms while hiding implementation details.

```java
public abstract class Scheduler {
    public abstract List<ProcessResult>
    schedule(List<Process> processes);
}
```

### Inheritance

All scheduling algorithms inherit from the Scheduler base class.

* FCFSScheduler
* SJFScheduler
* PriorityScheduler
* RoundRobinScheduler

### Polymorphism

Different scheduling algorithms can be executed through the same Scheduler reference.

```java
Scheduler scheduler =
        new RoundRobinScheduler(2);

scheduler.schedule(processes);
```

### Modular Design

Each package has a single responsibility:

* Process Management
* Scheduling Logic
* Statistics Calculation
* Reporting

---

## Project Structure

```text
src
│
├── process
│   ├── Process.java
│   └── ProcessState.java
│
├── scheduler
│   ├── Scheduler.java
│   ├── FCFSScheduler.java
│   ├── SJFScheduler.java
│   ├── PriorityScheduler.java
│   └── RoundRobinScheduler.java
│
├── metrics
│   ├── ProcessResult.java
│   └── StatisticsCalculator.java
│
├── report
│   ├── ReportGenerator.java
│   └── ConsoleReportGenerator.java
│
├── input
│   └── ProcessFactory.java
│
└── Main.java
```

---

## Scheduling Algorithms

### 1. First Come First Serve (FCFS)

Processes are executed in the order of their arrival.

Example:

```text
P1 → P2 → P3
```

---

### 2. Shortest Job First (SJF)

Among available processes, the process with the smallest burst time is selected first.

Example:

```text
P1(6) P2(3) P3(1)

Execution:
P1 → P3 → P2
```

---

### 3. Priority Scheduling

Processes are executed according to priority values.

Example:

```text
Priority:

P1 = 3
P2 = 1
P3 = 2

Execution:
P2 → P3 → P1
```

---

### 4. Round Robin Scheduling

Each process receives a fixed time quantum.

Example:

```text
Quantum = 2

P1 → P2 → P3 → P1 → P2 → P3
```

Round Robin ensures fair CPU allocation among processes.

---

## Statistics Generated

For every process:

* Completion Time
* Waiting Time
* Turnaround Time

Overall metrics:

* Average Waiting Time
* Average Turnaround Time

---

## Sample Output

```text
PID   WT   TAT

1     7    12
2     5    8
3     5    9

Average Waiting Time: 5.67
Average Turnaround Time: 9.67
```

---

## Technologies Used

* Java
* Object-Oriented Programming
* Java Collections Framework
* ArrayList
* Queue
* LinkedList
* Comparator

---

## Learning Outcomes

This project helped in understanding:

* CPU Scheduling Algorithms
* Process Management Concepts
* OOP Design Principles
* Encapsulation
* Abstraction
* Inheritance
* Polymorphism
* Modular Software Architecture
* Java Collections Framework
* Separation of Concerns

---

## Future Enhancements

* Shortest Remaining Time First (SRTF)
* Multi-Level Queue Scheduling
* Multi-Level Feedback Queue Scheduling
* CPU Utilization Metrics
* Throughput Analysis
* Gantt Chart Generation
* GUI Dashboard using JavaFX/Swing
* CSV and PDF Report Generation

---

## Author

Garvit Tyagi
