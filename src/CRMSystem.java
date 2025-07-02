package src;
import java.util.ArrayList;

public class CRMSystem {
    private ArrayList<Campaign> campaigns;
    private ArrayList<Worker> workers;

    public CRMSystem() {
        campaigns = new ArrayList<>();
        workers = new ArrayList<>();
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void addCampaign(Campaign campaign) {
        campaigns.add(campaign);
    }
    
    public void execution() {
        CampaignScheduler scheduler = new CampaignScheduler(campaigns, workers);
        scheduler.scheduleCampaigns();
    }

    public void workerSummary() {
        System.out.println("Workers Summary");
        for (Worker worker : workers) {
            System.out.println(worker.getName()+" is Assigned to "+worker.getCurrentTasks());
        }
    }
}
