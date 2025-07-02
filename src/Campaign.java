package src;
public class Campaign implements Executable{
    private int id;
    private String name;
    private PriorityLevel priority;
    private int duration;
    private String type;

    public Campaign(int id, String name, PriorityLevel priority, int duration, String type) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.duration = duration;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPriority(PriorityLevel priority) {
        this.priority = priority;
    }

    public PriorityLevel getPriority() {
        return priority;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void execute() {
        System.out.println("Executing Campaign " + name + " Priority is [" + priority + "]");
    }
    
    public String toString() {
        return id + " - " + name + " [" + priority + "] (" + duration + "s, " + type + ")";
    }

}
