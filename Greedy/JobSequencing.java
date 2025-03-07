class Job 
{
    int id,profit,deadline;
    Job(int id,int profit,int deadline)
    {
        this.id=id;
        this.profit=profit;
        this.deadline=deadline;
    }
}
public class JobSequencing {
    public static void ScheduleJobs(Job []jobs)
    {
        int n=jobs.length;
        boolean slots[]=new boolean[n];
        int result[]=new int[n];
        int totalProfit=0;
        for(Job job:jobs)
        {
            for(int j=job.deadline-1;j>=0;j--)
            {
                if(!slots[j])
                {
                    slots[j]=true;
                    result[j]=job.id;
                    totalProfit=totalProfit+job.profit;
                    break;
                }
            }
        }
        for(int i:result)
        {
            if(i!=0)
            System.out.println(i+" ");
        }
        System.out.println("The total profit is:"+totalProfit);
    }
    public static void main(String args[])
    {
        Job[] jobs={
            new Job(1,20,2),
            new Job(2,15,2),
            new Job(3, 10, 1),
            new Job(4,5 , 3),
            new Job(5, 1, 3)
        };
        ScheduleJobs(jobs);
    }
}
