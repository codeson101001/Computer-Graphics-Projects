
//RR was a little chalageing but after some manipulation with the array list and collections this made it easier
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RRScheduler {


    public static void processRRScheduling(final List<String> processes, final List<String> arrivalTimeList, final List<String> durationList, final int quantum) {

        System.out.println("");
        
        System.out.println("RR");
        
        System.out.println("");
        
        System.out.println("");
        

        
        List<String> remainingTimeList = new ArrayList<>();
        
        populateRemainingList(durationList, remainingTimeList);
        
        List<String> processedDetails = new ArrayList<>();
        
        pupulateProcessedDetails(processes, processedDetails);
        

        int serviceTime = 0;

        while (true) {
        	
            boolean processed = true;
            
            boolean isTimeRemainingForJob = false;
            

            for (int i = 0; i < processes.size(); i++) {

                int remainingJobTime = Integer.parseInt(remainingTimeList.get(i));
                
                if (remainingJobTime > 0) {
                	
                    processed = false;

                    if (remainingJobTime > quantum) {

                        if (Integer.parseInt(arrivalTimeList.get(i)) <= serviceTime) {

                            remainingTimeList.set(i, Integer.toString(remainingJobTime - quantum));
                            
                            String detail = processedDetails.get(i);
                            
                            int detailLength = detail.length();
                            

                            for (int j = 0; j < serviceTime - (detailLength - 2); j++) {
                            	
                                detail = detail + " ";
                            }
                            
                            for (int j = 0; j < quantum; j++) {
                            	
                                detail = detail + "X";
                            }
                            
                            serviceTime = serviceTime + quantum;
                            
                            processedDetails.set(i, detail);
                            
                            if(Integer.parseInt(remainingTimeList.get(i))>0){
                            	
                                isTimeRemainingForJob = true;
                                
                            }

                        }

                    } else {

                        if (Integer.parseInt(arrivalTimeList.get(i)) <= serviceTime) {


                            remainingTimeList.set(i, Integer.toString(0));
                            
                            String detail = processedDetails.get(i);
                            
                            int detailLength = detail.length();
                            
                            for (int j = 0; j < serviceTime - (detailLength - 2); j++) {
                            	
                                detail = detail + " ";
                            }
                            
                            for (int j = 0; j < remainingJobTime; j++) {
                            	
                                detail = detail + "X";
                                
                            }
                            
                            serviceTime = serviceTime + remainingJobTime;
                            
                            processedDetails.set(i, detail);
                            
                        }
                        
                    }
                    
                }
                
            }
            
            if(!isTimeRemainingForJob){
            	
                serviceTime++;
                
            }
            
            if (processed) {
            	
                break;
                
            }


        }
        
        for (int i = 0; i < processedDetails.size(); i++) {
        	
            System.out.println(processedDetails.get(i));
            
        }
    }

    private static void pupulateProcessedDetails(final List<String> processes, final List<String> processedDetails) {
    	
        for (int i = 0; i < processes.size(); i++) {
        	
            processedDetails.add(processes.get(i) + " ");
            
        }
        
    }

    private static void populateRemainingList(final List<String> durationList, final List<String> remainingTimeList) {
    	
        for (String duration : durationList) {
        	
            remainingTimeList.add(duration);
            
        }
        
    }
    
}















