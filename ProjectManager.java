/**
 * Created by Ravshan on 2016-12-01.
 */
public class ProjectManager extends WorkerWithLoan {
    public int contractPayment;

    public ProjectManager(String name, int loan, int workingTime, int contractPayment) {
        this.name = name;
        this.loan = loan;
        this.expectedWorkingTime = workingTime;
        this.contractPayment = contractPayment;
    }

    public String info() {
        String s="Name: "+this.name+"\nLoan: "+this.loan+" USD/hour"+"\nMonthly working time: "+this.expectedWorkingTime+" USD/hours"+"\nContract Payment: "+this.contractPayment+" USD/hour"+"\nActual working time: "+this.actualWorkingTime+" hours";
        return s;
    }
    @Override
    public String toString() {
        String s="Class name: ProjectManager\n";
        return super.toString()+s;
    }
}
