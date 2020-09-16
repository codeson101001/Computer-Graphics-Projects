
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//MFBS was a little harder to implement because of not online the queue that I had to keep track of but also the condition statements that I had to keep track of
//Managing these queues proved to be a little difficult
public class MFBScheduler {

	
	
	
	
    public static void processFBScheduling(final List<String> processes, final List<String> arrivalTimeList, final List<String> durationList, final int quantum) {
        
    	Queue<Integer> priorityQueue = new LinkedList<>();
        
    	pupulatePriorityQueue(processes, priorityQueue);
        
    	List<Queue> queueList = new ArrayList<>();
        
    	List<Integer> remainigTimeList = new ArrayList<>();
        
    	populateRemainingTimeList(remainigTimeList, durationList);
        
    	int cpuProcessIndex = 0;
        
    	queueList.add(priorityQueue);
        
    	int completed = 0;
        
    	int serviceTime = 0;
        
    	Queue<Integer> tempQueue;

        
    	
    	
    	
    	while(completed != processes.size()){

            for(int i=0; i< queueList.size(); i++){
                
            	final Queue<Integer> queue = queueList.get(i);
                
            	if(queue.peek()!= null) {

                    int processIndex = queue.peek();
                    
                    if(i == 0 && Integer.parseInt(arrivalTimeList.get(processIndex))<=serviceTime) {

                        processIndex = queue.poll();
                        
                        cpuProcessIndex = processIndex;
                        
                        int remainingTime = remainigTimeList.get(processIndex);
                        
                        for(int j=0; j<quantum;j++){
                            
                        	serviceTime++;
                            
                        	remainingTime--;
                        }
                        
                        remainigTimeList.set(processIndex, remainingTime);
                        
                        if(queue.peek() != null) {
                            
                        	int nextProcessIndex = queue.peek();
                            
                        	if(Integer.parseInt(arrivalTimeList.get(nextProcessIndex))<=serviceTime){
                                
                        		tempQueue = new LinkedList<>();
                                
                        		tempQueue.add(cpuProcessIndex);
                                
                        		queueList.add(tempQueue);
                                
                        		i=0;
                                
                        		continue;
                            
                        	} else{
                                
                        		remainingTime = remainigTimeList.get(processIndex);
                                
                        		if(remainingQueuesEmpty(queueList, i)){
                                    
                        			for(int x=0; x<remainigTimeList.get(processIndex); x++){
                                        
                        				serviceTime++;
                                        
                        				remainingTime--;
                                        
                        				if(Integer.parseInt(arrivalTimeList.get(nextProcessIndex))<=serviceTime){
                                            
                        					tempQueue = new LinkedList<>();
                                            
                        					tempQueue.add(cpuProcessIndex);
                                            
                        					queueList.add(tempQueue);
                                            
                        					remainigTimeList.set(processIndex, remainingTime);
                                            
                        					i=0;
                                            
                        					continue;
                                        }
                        				
                                    }
                                
                        		}else{
                                    
                        			tempQueue = new LinkedList<>();
                                    
                        			tempQueue.add(cpuProcessIndex);
                                    
                        			queueList.add(tempQueue);
                                    
                        			System.out.println("N");
                                    
                        			continue;
                                }
                        		
                            }
                        	
                        } else {
                            
                        	remainingTime = remainigTimeList.get(processIndex);
                            
                        	if(remainingQueuesEmpty(queueList, i)){
                                
                        		for(int x=0; x<remainigTimeList.get(processIndex); x++){
                                    
                        			serviceTime++;
                                    
                        			remainingTime--;

                                }
                        		
                                
                        		remainigTimeList.set(processIndex, remainingTime);
                                
                        		continue;

                            }else {
                                
                            	tempQueue = new LinkedList<>();
                                
                            	tempQueue.add(cpuProcessIndex);
                                
                            	queueList.add(tempQueue);
                                
                            	continue;
                            }

                        }

                    } else{
                        
                    	processIndex = queue.poll();
                        
                    	cpuProcessIndex = processIndex;
                        
                    	int remainingTime = remainigTimeList.get(processIndex);
                        
                    	for(int j=0; j<quantum;j++){
                            
                    		serviceTime++;
                            
                    		remainingTime--;
                        }
                    	
                        remainigTimeList.set(processIndex, remainingTime);
                        
                        if(queue.size()==0){
                            
                        	if(remainingQueuesEmpty(queueList, i)){
                               
                        		i=0;
                                
                        		continue;
                          
                        	} else{
                               
                        		tempQueue = new LinkedList<>();
                                
                        		tempQueue.add(cpuProcessIndex);
                               
                        		queueList.add(tempQueue);
                                
                        		continue;
                            }

                        } else{

                        }
                    }

                 //If all else fails this continue will go back to the beginning of the loop
                } else{
                    
                	continue;
                }
            }
        }

    }
    
    
    
    
    

    private static void populateRemainingTimeList(final List<Integer> remainigTimeList, final List<String> durationList) {
        
    	for(int i=0; i< durationList.size();i++){
            
        	remainigTimeList.add(Integer.parseInt(durationList.get(i)));
        }
    }

    
    
    
    private static boolean remainingQueuesEmpty(final List<Queue> queueList, final int index) {

        for(int i = index+1 ; i <queueList.size() ; i++){
        	
            Queue<Integer> queue = queueList.get(i);
            
            if(queue.size() > 0){
            	
                return false;
            }
        }
        return true;
    }

    
    
    
    
    private static void pupulatePriorityQueue(final List<String> processes, final Queue<Integer> priorityQueue) {

        for (int i = 0; i < processes.size(); i++) {
        	
            priorityQueue.add(i);
        }
    }
}










