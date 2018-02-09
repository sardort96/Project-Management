/**
 * Created by Ravshan on 2016-12-01.
 */
public class Employee extends WorkerWithLoan{
    public int extraPayment;
    public Employee(String name, int loan, int workingTime, int extraPayment) {
        this.name = name;
        this.loan = loan;
        this.expectedWorkingTime = workingTime;
        this.extraPayment = extraPayment;
    }

    public String info() {
        String s="Name: "+this.name+"\nLoan: "+this.loan+" USD/hour"+"\nMonthly working time: "+this.expectedWorkingTime+" hours"+"\nExtra working time payment: "+this.extraPayment+" USD/hour"+"\nActual working time: "+this.actualWorkingTime+" hours";
        return s;
    }


    @Override
    public String toString() {
        String s="Class name: Employee\nChild of ";
        return s+super.toString();
    }
}
