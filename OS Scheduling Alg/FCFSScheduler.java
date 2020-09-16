
//Because FCFS alg is so simple it only needs to import a List from Java
import java.util.List;


//This is my FCFSS alg which uses the List library
//It was one of the easiest to implement 
public class FCFSScheduler {

    public static void processFCFSScheduling(final List<String> processes, final List<String> arrivalTimeList, final List<String> durationList){
        
    	//This will all the method printSchedulingChart to help print all the items on the output console
    	printSchedulingChart(processes, arrivalTimeList, durationList);
    }

    
    
    
    private static void printSchedulingChart(final List<String> processes, final List<String> arrivalTimeList, final List<String> durationList) {
        
    	System.out.println("");
        
    	System.out.println("FCFS");
        
    	System.out.println("");

    	System.out.println("");
    	
    	//This variable will check to see if the servieTime is good enough
        int serviceTime = Integer.parseInt(arrivalTimeList.get(0));

        
        
        //This for loop will run through the entire A thorugh E
        for(int i = 0; i < processes.size(); i++){
        	
            System.out.print(processes.get(i));
            
            System.out.print(" ");

            if(Integer.parseInt(arrivalTimeList.get(i))> serviceTime) {
               
            	serviceTime = Integer.parseInt(arrivalTimeList.get(i));
            }
            
            
            //This loop will create the spaces that I need from the alg to work
            for(int j= 0; j <= serviceTime ; j ++){
            
            	System.out.print(" ");
            }
            
            
            
            for(int j=0; j < Integer.parseInt(durationList.get(i)); j++){
            
            	System.out.print("X");
            }
            

            
            //Here we are combining the service time to the Duration list that I created
            serviceTime = serviceTime + Integer.parseInt(durationList.get(i));

            System.out.println("");
        }

    }
}









