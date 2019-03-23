
public class MyProgram {
	public static void main(String [] args) {
		
		// initial
		Carrier ship1 = new Carrier();
		
		Aircraft jaguar=new Aircraft();
		Aircraft bear = new Aircraft();
		Aircraft[] a=new Aircraft[] {jaguar,bear};

		Carrier ship2 = new Carrier(a);
		Aircraft eagle = new Aircraft(50,100);	
	
		System.out.print("Ship2 initial\n"+ship2+"Eagle initial\n"+eagle);
		
		
		
		//state change 1
		
		System.out.print("\n\nState 1");
		ship2.planeTakeoff(jaguar);
		ship2.planeTakeoff(bear);
		

		System.out.print("\nTakeoff jaguar "+jaguar+"\nTakeoff bear "+bear);
		jaguar.setCurrentSpeed(105);
		bear.setCurrentSpeed(90);
		
		System.out.print("\n\nSpeed jaguar "+jaguar+"\nSpeed bear "+bear);
		
		//state change 2
		
		System.out.print("\n\nState 2");
		ship1.planeLand(jaguar);
		ship1.planeLand(bear);
		System.out.print("\nLand jaguar "+jaguar+"\nLand bear "+bear);
		System.out.print("\nSHIP1\n"+ship1);
		ship2.planeLand(eagle);
		System.out.print("\nLand eagle "+eagle);
		System.out.print("\nSHIP2\n"+ship2);
		
		
	
	}
}
