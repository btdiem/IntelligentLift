import java.util.Timer;
import java.util.TimerTask;


public class Operation implements OperationIF {

	public enum DOORSTATE {
	   OPEN, CLOSE;
	}
	public enum LIFTSTATE{
		STARTING, STOPPING;
	}
	
	int currentFloor = 0;
	int waitTime = 3*1000;
	DOORSTATE doorState = null;// true = open , false = close
	LIFTSTATE liftState = null;
//	Timer timerWait = new Timer();
	
//	static final String OPEN_STATE = "OPEN";
//	static final String CLOSE_STATE = "CLOSE";
//	static final String STARTING_STATE = "STARTING";
//	static final String STOPPING_STATE = "STOPPING";
	

	private void displayMessage(String message){
		
		System.out.println(message);
	}
	
	@Override
	public void move(int requestFloor) {
		// TODO Auto-generated method stub
		//Sysstem.out.println("Move() is called ");
		
		if (currentFloor == requestFloor )
			return;
		
		long currentTime = System.currentTimeMillis();
		if (currentFloor > requestFloor){
			
			displayMessage("Lift is moving down to " + requestFloor);
			//moveDown(requestFloor);
			
		}else{
			
			//moveUp(requestFloor);
			displayMessage("Lift is moving up to " + requestFloor);
			
		}
		open(requestFloor);
		wait(waitTime);
		close(requestFloor);
		
		displayMessage("MOVING TIME FROM " + currentFloor + " FROM " + requestFloor + " = " + (System.currentTimeMillis() - currentTime));
		
		currentFloor = requestFloor;
		
	}


	@Override
	public void close(int requestFloor) {
		// TODO Auto-generated method stub
		displayMessage("Lift is close the door at Floor " + requestFloor);
		doorState = DOORSTATE.CLOSE;

	}

	@Override
	public void open(int requestFloor) {
		// TODO Auto-generated method stub
		displayMessage("Lift is open the door at Floor " + requestFloor);
		doorState = DOORSTATE.OPEN;
	}

	@Override
	public void wait(final int seconds) {
		
		displayMessage("Lift is waiting within " + seconds);
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		timerWait.schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				displayMessage("Lift is waiting 3000 ");
//				this.cancel();
//				
//			}
//		}, 3000, 3000);
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
		if (liftState == null || liftState.equals(LIFTSTATE.STARTING)){
			
			displayMessage("Lift is stoping");
			liftState = LIFTSTATE.STOPPING;
			
			
		}else{
			
			displayMessage("Lift is stopped already");
			
		}

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		if (liftState == null || liftState.equals(LIFTSTATE.STOPPING)){
			
			displayMessage("Lift is starting");
			liftState = LIFTSTATE.STARTING;;
			
			
		}else{
			
			displayMessage("Lift is started already");
			
		}
		
		
	}

}
