
//These are the methods that are used to get this alg complete populateProcessedDetailList, updateWaitingList, populateWaitingList, and getShortestRationProcessIndex
//This is my project for the implementation of 6 of the schduleing alg from chapter 6
//To complete this project I mainly looked at the slides to understand the alg that I was coding and from there code it in Java


import java.util.ArrayList;
import java.util.List;



public class HRRNScheduler {

    public static void processHRRNScheduling(final List<String> processes, final List<String> arrivalTimeList, final List<String> durationList) {

        System.out.println("");
        
        System.out.println("HRRN");
        
        System.out.println("");

        System.out.println("");
        
        
        //Here there are two integer lists that are being created, I did this to better aid the HRRN alg 
        List<Integer> completedList = new ArrayList<>();
       
        List<Integer> waitingTimeList = new ArrayList<>();
        
        int highestRatioProcessIndex = 0;
        
        //For the two lists that I have created above these are the two variable that are associated with it
        int completed = 0;
        
        int serviceTime = 0;
        
        List<String> processedDetails = new ArrayList<>();
        
        populateWaitingList(waitingTimeList, processes.size());
        
        populateProcessedDetailList(processes, processedDetails);

        
        
        
        //This loop will exit if and when the process array is equal to complete
        while (completed != processes.size()) {
            
        	updateWaitingList(waitingTimeList, arrivalTimeList, serviceTime);
            
        	highestRatioProcessIndex = getShortestRationProcessIndex(waitingTimeList, arrivalTimeList, durationList, completedList, serviceTime);
            
        	if(highestRatioProcessIndex >=0) {
                
        		String detail = processedDetails.get(highestRatioProcessIndex);
                
        		for(int i=0; i < serviceTime ; i++){
                
        			detail = detail + " ";
                }
                
        		for (int i = 0; i < Integer.parseInt(durationList.get(highestRatioProcessIndex)); i++) {
                
        			//Here we are combining the X with the details variable
        			detail = detail + "X";
                    
        			serviceTime++;
                }
                
        		completedList.add(highestRatioProcessIndex);
                
        		completed++;
                
        		processedDetails.set(highestRatioProcessIndex, detail);
            
        	}else{
                
        		serviceTime++;
            }


        }

        for(int j=0; j< processedDetails.size(); j++){
            
        	System.out.println(processedDetails.get(j));
        }
    }
    
    
    
    private static void populateProcessedDetailList(final List<String> processes, final List<String> processedDetails) {
        
    	for(int i=0 ; i< processes.size(); i++){
            
    		processedDetails.add(processes.get(i) + " ");
        }
    }
    
    
    

    private static void updateWaitingList(final List<Integer> waitingTimeList, final List<String> arrivalTimeList, final int serviceTime) {
        
    	for (int i = 0; i < arrivalTimeList.size(); i++) {
           
    		if (Integer.parseInt(arrivalTimeList.get(i)) <= serviceTime) {
                
    			int waitingTime = serviceTime - Integer.parseInt(arrivalTimeList.get(i));
                
    			waitingTimeList.set(i, waitingTime);
            }
        }
    }

    
    
    private static int getShortestRationProcessIndex(final List<Integer> waitingTimeList, final List<String> arrivalTimeList, final List<String> durationList, final List<Integer> completedList, int serviceTime) {
       
    	double maxRatio = 0;
        
    	int highestRatioIndex = -1;

        for (int i = 0; i < arrivalTimeList.size(); i++) {
           
        	int ratio = (waitingTimeList.get(i) + Integer.parseInt(durationList.get(i))) / Integer.parseInt(durationList.get(i));
           
        	if (ratio > maxRatio && !completedList.contains(i) && Integer.parseInt(arrivalTimeList.get(i))<=serviceTime) {
               
        		maxRatio = ratio;
                
        		highestRatioIndex = i;
            }
        }

        	return highestRatioIndex;
    }

    
    
    
    
    private static void populateWaitingList(final List<Integer> waitingTimeList, final int noOfProcesses) {


        for (int i = 0; i < noOfProcesses; i++) {
            
        	waitingTimeList.add(0);
        	
        }
        
    }
    
}









