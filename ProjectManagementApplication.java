import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * Created by Ravshan on 2016-12-01.
 */
//every class is in default package like ProjectManagementApplication class itself
public class ProjectManagementApplication {

    private static Project project;
    private static Scanner in = new Scanner(System.in);
//a method to register a consultant, it can throw an InputMismatchException 
    private static void registerAConsultant() {
        System.out.println("REGISTERING A CONSULTANT\n");
    System.out.print("Enter name of consultant: ");
    String name = in.next();
    int wage=0, workingTime=0;
    System.out.print("Enter working time payment of consultant(USD/hour): ");
    try {
        wage = in.nextInt();
    }
    catch(InputMismatchException e)
    {
        System.out.println("Only numbers accepted...");
    }

    System.out.print("Enter expected working time of consultant: ");
    try{
    workingTime = in.nextInt();
    }
    catch(InputMismatchException e)
    {
        System.out.println("Only numbers accepted...");
    }

    Worker consultant = new Consultant(name, wage, workingTime);
    project.workers.add(consultant);
    project.actualBudget=calculateProjectActualBudget();
	}
//a method to register a project manager, it can throw an InputMismatchException
    private static void registerAProjectManager() {
        System.out.println("REGISTERING PROJECT A MANAGER\n");
        System.out.print("Enter name of project manager: ");
        String name = in.next();
        int loan=0, workingTime=0, contractPayment=0;

        System.out.print("Enter loan of project manager(USD): ");
        try {
            loan = in.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Only numbers accepted...");
        }
        System.out.print("Enter expected monthly working time of project manager: ");
        try {
            workingTime = in.nextInt();
        }catch(InputMismatchException e)
        {
            System.out.println("Only numbers accepted...");
        }
        System.out.print("Enter contract payment of project manager: ");
        try {
            contractPayment = in.nextInt();
        }catch(InputMismatchException e)
        {
            System.out.println("Only numbers accepted...");
        }
        Worker projectManager = new ProjectManager(name, loan, workingTime, contractPayment);
        project.workers.add(projectManager);
        project.actualBudget=calculateProjectActualBudget();
    }

//a method to register an employee, it can throw an InputMismatchException
    private static void registerAnEmployee() {
        System.out.println("REGISTERING PROJECT AN EMPLOYEE\n");
        System.out.print("Enter name of employee: ");
        String name = in.next();
        int loan=0,workingTime=0,extraPayment=0;
        System.out.print("Enter loan of employee(USD): ");
         try {
             loan = in.nextInt();
         }catch(InputMismatchException e)
         {
             System.out.println("Only numbers accepted...");
         }
         System.out.print("Enter expected monthly working time of employee: ");
         try {
             workingTime = in.nextInt();
         }catch(InputMismatchException e)
         {
             System.out.println("Only numbers accepted...");
         }
         System.out.print("Enter extra working time payment of employee: ");
         try {
             extraPayment = in.nextInt();
         }catch(InputMismatchException e)
         {
             System.out.println("Only numbers accepted...");
         }
         Worker employee = new Employee(name, loan, workingTime, extraPayment);
        project.workers.add(employee);
        project.actualBudget=calculateProjectActualBudget();
    }

//a method to set actual project time, it can throw an InputMismatchException
    private static void setActualProjectTime() {
        System.out.print("Enter name of worker: ");
        String name = in.next();
        boolean found = false;
        for (Worker worker : project.workers) {
            if (0==name.compareTo(worker.name)) {
                System.out.print("Enter actual monthly working time of " + worker.name + ": ");
                int actualWorkingTime =0;
                try{
                    actualWorkingTime=in.nextInt();
                }catch(InputMismatchException e)
                {
                    System.out.println("Only numbers accepted...");
                }
                worker.actualWorkingTime = actualWorkingTime;
                project.actualTime += actualWorkingTime;
                found = true;
            }
            if (!found) {
                System.out.println("Wrong name entered. Try one more time");
                setActualProjectTime();
            }

        }
    }

//a method to calculate actual project budget
    private static int calculateProjectActualBudget() {
        int actualBudget = 0;
        for (Worker worker : project.workers) {
            if (worker instanceof Employee) {
                Employee e = (Employee) worker;
                actualBudget += e.loan*2;//they worked 2 months
                actualBudget += (e.actualWorkingTime - e.expectedWorkingTime) * (e.extraPayment);
            } else if (worker instanceof Consultant) {
                Consultant c = (Consultant) worker;
                actualBudget += c.actualWorkingTime * c.wagePerHour;
            } else {
                ProjectManager pm = (ProjectManager) worker;
                actualBudget += pm.loan + pm.contractPayment;
            }
        }
        return actualBudget;
    }

//a method to show further required budget  
    private static void showTheRequiredBudget() {
        System.out.println(project.info());
        System.out.println("Required additional budget: " +(project.actualBudget>project.budget ? abs((project.actualBudget - project.budget)):"0"));
    }

//a method to delete all workers of project
    private static void makeProjectResourceEmpty() {
        System.out.println("Making project resource empty...\n\n");
        project.workers.clear();
        project.actualTime=project.actualTime=0;
    }

//a method to show all information about each worker in project
    private static void showResourceOverallInfo() {
        System.out.println("RESOURCE OVERALL INFORMATION\n");
        for (Worker worker : project.workers) {
            System.out.println(worker.info()+"\n");
        }
    }

//a method to exit terminate program
    private static void exit() {
        System.out.println("Exiting...");
        System.exit(1);
    }


    public static void main(String[] args) {
        project = new Project("Space Rocket", 30000, 1000);
        System.out.println("WELCOME TO PROJECT MANAGEMENT APP");
        while (true) {
            System.out.println("\nSelect one of the options below:");
            System.out.println("1) Register a consultant\n" +
                    "2) Register a project manager\n" +
                    "3) Register an employee\n" +
                    "4) Set actual project time\n" +
                    "5) Calculate project actual budget\n" +
                    "6) Show the required budget\n" +
                    "7) Make the project resource empty\n" +
                    "8) Show the overall information related to the project resource\n" +
                    "9) Exit");
            int choice =0;
           try {
               choice = in.nextInt();
           }catch(InputMismatchException e)
           {
               System.out.println("Wrong choice, try again...");

           }
           switch (choice) {
                case 1:
                    registerAConsultant();
                    break;
                case 2:
                    registerAProjectManager();
                    break;
                case 3:
                    registerAnEmployee();
                    break;
                case 4:
                    setActualProjectTime();
                    break;
                case 5:
                    System.out.println("Actual budget of "+project.name+" is "+calculateProjectActualBudget());
                    break;
                case 6:
                    showTheRequiredBudget();
                    break;
                case 7:
                    makeProjectResourceEmpty();
                    break;
                case 8:
                    showResourceOverallInfo();
                    break;
                case 9:
                    exit();
                    break;
                default: break;
            }
        }
    }
}
