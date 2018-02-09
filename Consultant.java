/**
 * Created by Ravshan on 2016-12-01.
 */
public class Consultant extends WorkerWithoutLoan {
    public Consultant(String name, int vage, int workingTime) {
        this.name=name;
        this.wagePerHour=vage;
        this.expectedWorkingTime=workingTime;
    }
    public String info() {
        String s="Name: "+this.name+"\nWorking time payment: "+this.wagePerHour+" USD/hour"+"\nActual working time: "+this.actualWorkingTime+" hours";
        return s;
    }

    @Override
    public String toString() {
        String s="Class name: Consultant\nChild of ";
        return s+super.toString();
    }
}
