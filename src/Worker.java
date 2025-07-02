package src;
import java.util.ArrayList;

public class Worker {
    private int id;
    private String name;
    private int coresavailable;

    public Worker(int id, String name, int coresavailable) {
        this.id = id;
        this.name = name;
        this.coresavailable = coresavailable;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCoresavailable() {
        return coresavailable;
    }

    private ArrayList<Campaign> currentTasks = new ArrayList<>();

    public boolean isAvailable() {
        if (currentTasks.size() < coresavailable) {
            return true;
        } else {
            return false;
        }
    }

    public void assignCampaign(Campaign campaign) {
        currentTasks.add(campaign);
        System.out.println("Assigned " + campaign + " to " + name);
    }

    public ArrayList<Campaign> getCurrentTasks() {
        return currentTasks;
    }

    public String toString() {
        return id + " - " + name + " (Cores: " + coresavailable + ")";
    }

}
