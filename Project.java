import java.util.ArrayList;

/**
 * Created by Ravshan on 2016-12-01.
 */
public class Project {
    public String name;
    public ArrayList<Worker> workers;
    public int budget;
    public int expectedTime;
    public int actualTime;
    public int actualBudget;
    public Project(String name, int budget, int expectedTime)
    {
        workers=new ArrayList<Worker>();
        this.name=name;
        this.budget=budget;
        this.expectedTime=expectedTime;
    }


    public String info() {
        String s="Project name: "+name+"\nExpected budget: "+budget+"\nExpected time: "+expectedTime+"\nActual budget: "+actualBudget+"\nActual time: "+actualTime;
        return s;

    }
    @Override
    public String toString() {
        String s="Class name: Project\n Child of ";
        return s+super.toString();
    }
}
