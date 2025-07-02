package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CRMSystem crm = new CRMSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Add Campaign");
            System.out.println("2. Add Worker");
            System.out.println("3. Execute");
            System.out.println("4. Summary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Campaign ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Campaign Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Campaign Priority (PREMIUM, STANDARD, LOW): ");
                    String priorityInput = sc.nextLine().toUpperCase();
                    PriorityLevel priority = PriorityLevel.valueOf(priorityInput);

                    System.out.print("Enter Campaign Duration (in seconds): ");
                    int duration = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Campaign Type (e.g., Email/SMS/Push): ");
                    String type = sc.nextLine();

                    Campaign campaign = new Campaign(id, name, priority, duration, type);
                    crm.addCampaign(campaign);
                    System.out.println("Campaign added.");
                    break;

                case 2:
                    System.out.print("Enter Worker ID: ");
                    int wid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Worker Name: ");
                    String wname = sc.nextLine();

                    System.out.print("Enter No. of Available Cores: ");
                    int cores = sc.nextInt();
                    sc.nextLine();

                    crm.addWorker(new Worker(wid, wname, cores));
                    System.out.println("Worker added.");
                    break;

                case 3:
                    System.out.println("Executing Campaign Scheduler...");
                    crm.execution();
                    break;

                case 4:
                    crm.workerSummary();
                    break;

                case 5:
                    System.out.println("Exiting CRM System...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
