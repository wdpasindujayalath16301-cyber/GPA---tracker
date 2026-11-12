import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

class CourseModule{
    String name;
    int credits;
    String grade;
}


class Score{

    Map<String , Double> scores = Map.of(
        "A",4.0,
        "A-",3.7,
        "B+",3.3,
        "B",3.0,
        "B-",2.7,
        "C+",2.3,
        "C",2.0,
        "C-",1.7
        
    );

    public double show(String heee){
        for(String key :scores.keySet()){
            if (heee.equals(key)){
                return scores.get(key);
            }

        }
        return 0.0;

    }
}


public class GpaTracker {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){

            String name;
            String university;
            String degree;
            int numOfModules;
            int credits = 0;

            System.out.print("Enter your name: ");
            name = scanner.nextLine();

            System.out.print("Enter your university name: ");
            university = scanner.nextLine();

            System.out.print("Enter your degree: ");
            degree = scanner.nextLine();

            System.out.print("how many modules: ");
            numOfModules = scanner.nextInt();
            scanner.nextLine();

            
            ArrayList<CourseModule> modules = new ArrayList<>();
            Score obj1 = new Score();

            double total = 0;

            for (int i=0; i<numOfModules; i++){
                int kk = i+1;
                System.out.print("Enter your module "+kk+" name: ");
                String moduleName = scanner.nextLine();

                System.out.print("What is your result for that module : ");
                String moduleResult = scanner.nextLine().toUpperCase();

                while(!obj1.scores.containsKey(moduleResult)){
                    System.out.println("Invalid grade. Please enter a valid grade.");
                    System.out.println("What is your result for that module : ");
                    moduleResult = scanner.nextLine().toUpperCase();

                    
                }
                if (!obj1.scores.containsKey(moduleResult)) {
                    System.out.println("Invalid grade. Please enter a valid grade.");
                    i--; 
                    continue;
                }

                System.out.print("how many credits for "+moduleName+" :");
                int moduleCredit = scanner.nextInt();
                scanner.nextLine();

                credits=credits+moduleCredit;

                CourseModule obj2 = new CourseModule();
                obj2.name = moduleName;
                obj2.credits = moduleCredit;
                obj2.grade=moduleResult;

                modules.add(obj2);
            }

            for(CourseModule x: modules){
                total+=x.credits*obj1.show(x.grade);

            }

            double gpa = total/credits;

            System.out.println();
            System.out.println("*********************************************");
            System.out.println(name);
            System.out.println(degree);
            System.out.println(university);
            System.out.printf("your final gpa: %.2f\n", gpa);
            System.out.println();
            System.out.println("*********************************************");


        }catch(Exception e){
            System.out.println("Something went wrong..."+e);
        }
        

    }
    
}
