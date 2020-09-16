
/*DXM151030
 * This is my project for the implementation of 6 of the schduleing alg from chapter 6
 * To complete this project I mainly looked at the slides to understand the alg that I was coding and from there code it in Java
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInputProcessor {

    private static final List<String> shcedulingMethodList = Arrays.asList("FCFS","RR","SPN","SRT","HRRN","FB","ALL");

    public static void main (String []args){

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the scheduling method or type ALL for all of the scheduling methods: ");
        
        //These are my lists of strings
        List <String> processes = new ArrayList<>();
        
        List <String> arrivalTimeList = new ArrayList<>();
        
        List <String> durationList = new ArrayList<>();

        String schedulingMethod = scanner.next();

        
        if(!isValidSchedulingMethod(schedulingMethod)){
        
        	System.out.println("Invaild Input, try again");
            
        	//Once I am done with this method I need to exit it
        	System.exit(0);
        }
        
        //This is the file that we are getting from the resource folder
        File file = new File("./jobs.txt");

        //This is my try catch to get anything that comes through
        BufferedReader br = null;
        
        
        
        
        try {
        	
            br = new BufferedReader(new FileReader(file));
            
            String st;
            
            while ((st = br.readLine()) != null){
            	
                String []jobDetails = st.split("\\s+");
                
                processes.add(jobDetails[0]);
                
                arrivalTimeList.add(jobDetails[1]);
                
                durationList.add(jobDetails[2]);
            }

        }catch (FileNotFoundException ex) {
            
        	ex.printStackTrace();
        
        }catch (IOException ex) {
        	
            ex.printStackTrace();
        }


        //These conditions will account for all of the algs that were requested from the requirements 
        if(schedulingMethod.equals("FCFS")){
            
        	FCFSScheduler.processFCFSScheduling(processes, arrivalTimeList, durationList);
        
        }else if(schedulingMethod.equals("RR")){
            
        	RRScheduler.processRRScheduling(processes, arrivalTimeList, durationList, 1);
        }else if(schedulingMethod.equals("SPN")){
            
        	SPNScheduler.processSPNScheduling(processes, arrivalTimeList, durationList);
        
        }else if(schedulingMethod.equals("SRT")){
            
        	SRTScheduler.processSRTScheduling(processes, arrivalTimeList, durationList);
        }else if(schedulingMethod.equals("HRRN")){
            
        	HRRNScheduler.processHRRNScheduling(processes, arrivalTimeList, durationList);
        }else if(schedulingMethod.equals("FB")){
            
        	MFBScheduler.processFBScheduling(processes, arrivalTimeList, durationList, 1);
        }else if(schedulingMethod.equals("ALL")){
            
        	//These are for all of the scheduling alg 
        	FCFSScheduler.processFCFSScheduling(processes, arrivalTimeList, durationList);
            
        	RRScheduler.processRRScheduling(processes, arrivalTimeList, durationList, 1);
            
        	SPNScheduler.processSPNScheduling(processes, arrivalTimeList, durationList);
            
        	SRTScheduler.processSRTScheduling(processes, arrivalTimeList, durationList);
            
        	HRRNScheduler.processHRRNScheduling(processes, arrivalTimeList, durationList);
            
        	MFBScheduler.processFBScheduling(processes, arrivalTimeList, durationList, 1);
        }
    }

    
    
    private static boolean isValidSchedulingMethod(final String schedulingMethod) {

        if (shcedulingMethodList.contains(schedulingMethod)){
            
        	return true;
        }
        
        return false;
    }
}







