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
            
          

            System.out.print("Enter your name: ");
            name = scanner.nextLine();

            System.out.print("Enter your university name: ");
            university = scanner.nextLine();

            System.out.print("Enter your degree: ");
            degree = scanner.nextLine();

            System.out.print("how many modules: ");
            int numOfModules = scanner.nextInt();
            scanner.nextLine();

            
           
            Score obj1 = new Score();

           

            ArrayList<CourseModule> modules = readModules(scanner, obj1, numOfModules);

            double gpa = calculateGpa(modules,obj1);

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
       static double calculateGpa(ArrayList<CourseModule> modules, Score scorer) {

       double total=0;
       int credits=0;

       for(CourseModule module:modules){
        total+=module.credits*scorer.show(module.grade);
        credits+=module.credits;
       }

       return  total/credits;
    }


    static ArrayList<CourseModule> readModules(Scanner scanner, Score scorer, int count){

        
             ArrayList<CourseModule> modules = new ArrayList<>();

            for (int i=0; i<count; i++){
                int kk = i+1;
                System.out.print("Enter your module "+kk+" name: ");
                String moduleName = scanner.nextLine();

                System.out.print("What is your result for that module : ");
                String moduleResult = scanner.nextLine().toUpperCase();

                while(!scorer.scores.containsKey(moduleResult)){
                    System.out.println("Invalid grade. Please enter a valid grade.");
                    System.out.print("What is your result for that module : ");
                    moduleResult = scanner.nextLine().toUpperCase();}


                System.out.print("how many credits for "+moduleName+" :");
                int moduleCredit = scanner.nextInt();
                scanner.nextLine();
                while(moduleCredit<=0){
                    System.out.println("credit can't be zero or negative");
                    System.out.print("how many credits for "+moduleName+" :");
                    moduleCredit = scanner.nextInt();
                    scanner.nextLine();
                }

                CourseModule obj2 = new CourseModule();
                obj2.name = moduleName;
                obj2.credits = moduleCredit;
                obj2.grade=moduleResult;

                modules.add(obj2);
            }
        return modules;        

    }

}
