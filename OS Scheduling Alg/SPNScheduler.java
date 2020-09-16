

import java.util.ArrayList;
import java.util.List;

public class SPNScheduler {

    public static void processSPNScheduling(final List<String> processes, final List<String> arrivalTimeList, final List<String> durationList) {

        System.out.println("");
        
        System.out.println("SPN");
        
        System.out.println("");
        
        System.out.println("");

        
        int complete = 0;
        
        int shortestProcessIndex = 0;
        
        int shortestDuration = 0;
        
        
        List<Integer> completedList = new ArrayList<>();
        
        List<String> processedDetails = new ArrayList<>();
        
        
        pipulateProcessedDtailsList(processes, processedDetails);
        
        int serviceTime = 0;
        
        boolean found = false;
        

        while (complete != processes.size()) {

            shortestDuration = 0;
            
            found = false;

            for (int i = 0; i < processes.size(); i++) {


                if (shortestDuration == 0 && !completedList.contains(i) && Integer.parseInt(arrivalTimeList.get(i)) <= serviceTime) {
                	
                    shortestDuration = Integer.parseInt(durationList.get(i));
                    
                    shortestProcessIndex = i;
                    
                    found = true;
                }
                
                

                if (Integer.parseInt(durationList.get(i)) < shortestDuration && !completedList.contains(i) && Integer.parseInt(arrivalTimeList.get(i)) <= serviceTime) {
                    
                	shortestDuration = Integer.parseInt(durationList.get(i));
                    
                	shortestProcessIndex = i;
                    
                	found = true;
                }
                
            }
            

            

            if (found) {
            
            	String detail = processedDetails.get(shortestProcessIndex);

            	
                if (serviceTime > 0) {
                
                	for (int j = 0; j < serviceTime; j++) {
                    
                		detail = detail + " ";
                    
                	}
                	
                }
                
                for (int j = 0; j < shortestDuration; j++) {
                
                	detail = detail + "X";
                    
                	serviceTime++;
                }
                
                
                processedDetails.set(shortestProcessIndex, detail);
                
                completedList.add(shortestProcessIndex);
                
                complete++;
                
            } else {
            	
                serviceTime++;
            }

        }

        for(int j=0; j<processedDetails.size();j++){
        	
            System.out.println(processedDetails.get(j));
        }


    }

    private static void pipulateProcessedDtailsList(List<String> processes, List<String> processedDetails) {

        for(int i=0;i<processes.size();i++){
        	
            processedDetails.add(processes.get(i)+" ");
            
        }
    }

    
}













