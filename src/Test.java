import java.util.ArrayList;
import java.util.List;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//
		List<Integer> requestList = new ArrayList<Integer>();
		//requestList.add(1);
		//requestList.add(0);
		//requestList.add(6);
		requestList.add(1);
		
		requestList.add(4);
		
		requestList.add(2);
		//requestList.add(3);
		
		requestList.add(5);
		
		requestList.add(7);
		//requestList.add(6);
		
		//requestList.add(8);
		//requestList.add(9);
		requestList.add(10);
		
		OperationIF operation = new Operation();
		
		
		while(!requestList.isEmpty()){
			
			operation.move(requestList.remove(0));
		}
		
		
		
	}

}
