
//These are the methods that I used to finish this alg getShortestRemainingTimeProcess, populateProcessedDetails, and populateRemainingTimeList
import java.util.ArrayList;
import java.util.List;

public class SRTScheduler {

    public static void processSRTScheduling(final List<String> processes, final List<String> arrivalTimeList, final List<String> durationList) {

        System.out.println("");
        
        System.out.println("SRT");
        
        System.out.println("");
        
        System.out.println("");
        
        

        List<Integer> remainingTimeList = new ArrayList<>();
        
        populateRemainingTimeList(durationList, remainingTimeList);
        
        int shortestRemainingTimeProcessIndex = 0;
        
        int serviceTime = 0;
        
        
        List<Integer> completedList = new ArrayList<>();
        
        List<String> processedDetails = new ArrayList<>();
        
        
        populateProcessedDetails(processes, processedDetails);
        

        int completed = 0;

        
        while (completed != processes.size()) {

            shortestRemainingTimeProcessIndex = getShortestRemainingTimeProcess(remainingTimeList, arrivalTimeList, serviceTime, completedList);

            if (shortestRemainingTimeProcessIndex >= 0) {

                String detail = processedDetails.get(shortestRemainingTimeProcessIndex);
                
                int detailLength = detail.length() - 2;
                
                
                for (int x = 0; x <= serviceTime - detailLength; x++) {
                    
                	detail = detail + " ";
                }
                
                processedDetails.set(shortestRemainingTimeProcessIndex, detail + "X");
                
                int currentRemainingTime = remainingTimeList.get(shortestRemainingTimeProcessIndex);
                
                remainingTimeList.set(shortestRemainingTimeProcessIndex, currentRemainingTime - 1);

                serviceTime++;
                
                if (remainingTimeList.get(shortestRemainingTimeProcessIndex) == 0) {
                    
                	completed++;
                    
                	completedList.add(shortestRemainingTimeProcessIndex);
                }
            
            } else {
                
            	serviceTime++;
            
            }
            

        }

        for (String detail : processedDetails) {
           
        	System.out.println(detail);
        
        }


    }
    
    

    private static int getShortestRemainingTimeProcess(final List<Integer> remainingTimeList, final List<String> arrivalTime, final int serviceTime, final List<Integer> completedList) {
        
    	int shortestIndex = 0;
        
    	boolean found = false;

        for (int i = 0; i < remainingTimeList.size(); i++) {
            
        	if (!completedList.contains(i) && Integer.parseInt(arrivalTime.get(i)) <= serviceTime) {
                
        		shortestIndex = i;
               
        		break;
            }
        }


        for (int i = 0; i < arrivalTime.size(); i++) {

            if (remainingTimeList.get(i) <= remainingTimeList.get(shortestIndex) && Integer.parseInt(arrivalTime.get(i)) <= serviceTime && !completedList.contains(i)) {
                
            	if(remainingTimeList.get(i) < remainingTimeList.get(shortestIndex)) {
                   
            		shortestIndex = i;
               
            	}
                
            	found = true;
            }
        }

        if (!found) {
            
        	return -1;
        }
        return shortestIndex;
    }

    private static void populateProcessedDetails(final List<String> processes, final List<String> processedDetails) {
        
    	for (String process : processes) {
            
    		processedDetails.add(process + " ");
        }
    }

    private static void populateRemainingTimeList(final List<String> durationList, final List<Integer> remainingTimeList) {

        
    	for (String duration : durationList) {
            
        	remainingTimeList.add(Integer.parseInt(duration));
        }
    }
}













