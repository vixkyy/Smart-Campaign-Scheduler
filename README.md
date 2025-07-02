# Smart-Campaign-Scheduler

# 🧠 Java-Based Priority Campaign Scheduler (CLI Edition)

This project is a **console-based smart campaign scheduling system** written entirely in Java. It simulates how campaigns (like SMS, email, or push notifications) can be assigned to available workers based on their priority and the worker's capacity (cores available).

---

## 🚀 Features

- Add and store campaigns with different priority levels (`PREMIUM`, `STANDARD`, `LOW`)
- Add workers with a fixed number of cores (parallel execution capacity)
- Assign campaigns to available workers based on priority
- Display worker assignment summary
- Console-based menu interface for interaction

---

## 📦 Project Structure

├── PriorityLevel.java
├── Executable.java
├── Campaign.java
├── Worker.java
├── CampaignScheduler.java
├── CRMSystem.java
└── Main.java

## 🧱 Classes & Responsibilities

### `Campaign.java`
Represents a campaign/task to be executed.

| Field      | Purpose                                      |
|------------|----------------------------------------------|
| `id`       | Unique identifier for the campaign           |
| `name`     | Name of the campaign                         |
| `priority` | Priority level (`PREMIUM`, `STANDARD`, `LOW`)|
| `duration` | Time in seconds (logical use, not yet used)  |
| `type`     | Campaign type (Email, SMS, Push, etc.)       |

✅ Implements `Executable` interface (with `execute()` method)  
✅ `toString()` overridden for clean logging

---

### `Worker.java`
Represents a processing unit (like an employee/server) capable of handling multiple campaigns.

| Field        | Purpose                                |
|--------------|----------------------------------------|
| `id`         | Unique worker ID                       |
| `name`       | Worker’s name                          |
| `cores`      | Number of campaigns the worker can run |
| `currentTasks`| List of campaigns assigned             |

✅ Handles task assignment  
✅ Provides availability check via `isAvailable()`

---

### `CampaignScheduler.java`
Handles core scheduling logic using a **PriorityQueue** to prioritize campaign execution.

| Method              | Role                                                  |
|---------------------|-------------------------------------------------------|
| `scheduleCampaigns` | Picks campaigns by priority and assigns to workers    |
| `findAvailableWorker` | Finds a worker with available cores                |

🔁 Uses Java `PriorityQueue` with custom comparator  
🏷 Priorities are ordered: `PREMIUM` < `STANDARD` < `LOW` (lower ordinal = higher priority)

---

### `CRMSystem.java`
Acts as a controller/facade to manage both workers and campaigns.

| Method        | Role                                |
|---------------|-------------------------------------|
| `addCampaign` | Adds new campaign                   |
| `addWorker`   | Adds a new worker                   |
| `execution`   | Triggers the scheduler              |
| `workerSummary`| Shows all workers and their tasks |

---

### `Main.java`
Handles **console-based menu UI** for interacting with the system.

Supported Options:
1. Add Campaign  
2. Add Worker  
3. Execute Campaigns  
4. Show Summary  
5. Exit

🔧 Uses `Scanner` for input  
📤 Sends data to `CRMSystem` controller  

---

## ⚙️ Technologies Used

- Java (JDK 8+)
- No external libraries
- CLI (Command-line interface) 
