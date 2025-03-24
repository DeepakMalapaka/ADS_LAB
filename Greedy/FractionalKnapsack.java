import java.util.*;
class Item
{
    int weight;
    int profit;
    int ratio;
    Item(int weight,int profit)
    {
        this.weight=weight;
        this.profit=profit;
        this.ratio=profit/weight;
    }
}

public class FractionalKnapsack {
    public static double MaxProfit(Item []items,int m)
    {
        Arrays.sort(items,(a,b)->Double.compare(b.ratio,a.ratio));
        double maxp=0.0;
        for(Item item:items)
        {
            if(item.weight<=m)
            {
                maxp=maxp+item.profit;
                System.out.println("The item weight:"+item.weight+" and item profit:"+item.profit);
                m-=item.weight;
            }
            else{
                double fraction=(double) m/item.weight;
                maxp+=fraction*item.profit;
                System.out.println("item weight:"+item.weight*fraction+ "item profit :"+item.profit*fraction+"- taken"+fraction*100+"%");
                break;
            }
        }
        return maxp;
    }
    public static void main(String args[])
    {
        Item []items={new Item(25, 18),new Item(24,15),new Item(15,10)};
        int m=20;
        double max=MaxProfit(items, m);
        System.out.println(max+"is the maximum profit that can be stored in the bag");
    }  
}
