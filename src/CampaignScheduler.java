package src;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class CampaignScheduler {
    private PriorityQueue<Campaign> campaignQueue;
    private ArrayList<Worker> workers;

    public CampaignScheduler(ArrayList<Campaign> campaigns, ArrayList<Worker> workers) {
        this.workers = workers;

        campaignQueue = new PriorityQueue<>(new Comparator<Campaign>() {
            public int compare(Campaign c1, Campaign c2) {
                return c1.getPriority().ordinal() - c2.getPriority().ordinal();
            }
        });
        campaignQueue.addAll(campaigns);
    }
    
    public Worker findAvailableWorker() {
        for (Worker worker : workers) {
            if (worker.isAvailable()) {
                return worker;
            }
        }
        return null;
    }

    public void scheduleCampaigns() {
        while (!campaignQueue.isEmpty()) {
            Campaign campaign = campaignQueue.poll();
            Worker availableWorker = findAvailableWorker();

            if (availableWorker != null) {
                availableWorker.assignCampaign(campaign);
                campaign.execute();
            }
            else {
                System.out.println("No available Workers for " + campaign.getName());
            }
        }
    }
}
