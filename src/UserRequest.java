import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class UserRequest {

	int numberOfFloor = 50;
	Timer timerRequest = new Timer();
	Timer timerExecution = new Timer();
	Timer timerWait = new Timer();
	TimerTask timerTask;//automatically stop 30s 
	
	
	Random random = new Random();
	OperationIF operation = new Operation();
	long repeatTime = 30;
	
	List<Integer> requestList = new CopyOnWriteArrayList<Integer>();
	

	public int generatedNumber(){
		return random.nextInt(numberOfFloor);
	}
	
	public UserRequest(int numberOfFloor){
		
		this.numberOfFloor = numberOfFloor;
		timerRequest = new Timer();
		timerExecution = new Timer();
		
	}
	
	public void call(){
		
		//should be in a loop within 30s
		timerRequest.scheduleAtFixedRate(new RequestTask(), 0, 50 * 1000);
		timerExecution.schedule(new ExecutionTask(), 0, 50 * 1000);
		
	}

	class RequestTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//System.out.println("RequestTask 0");
			while(true){
				//System.out.println("RequestTask 1");
				int requestFloor = generatedNumber();
				//add to queue
				requestList.add(requestFloor);
		}
		
	}
	
	}
	
	class ExecutionTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//System.out.println("ExecutionTask 0");
			operation.start();
			
			while(!requestList.isEmpty()){
				
				operation.move(requestList.remove(0));
				
			}//while
			operation.stop();
			
		}
		
		
	}
	
}
	
	
