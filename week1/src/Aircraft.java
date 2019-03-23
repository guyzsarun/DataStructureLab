
public class Aircraft {
	private int currentSpeed;
	private int maxSpeed;
	public Aircraft(int currentSpeed,int maxSpeed){
		this.setMaxSpeed(maxSpeed);
		this.setCurrentSpeed(currentSpeed);
		
	}
	public Aircraft() {
		this.currentSpeed=0;
		this.maxSpeed=100;
	}
	
	public void setCurrentSpeed(int s) {
		if (s<0){
			this.currentSpeed=0;
		}
		else if (s>=this.maxSpeed) {
			currentSpeed=maxSpeed;
		}
		else {
			currentSpeed=s;
		}
		
	}
	public void setMaxSpeed(int m) {
		if (m<50) {
			maxSpeed=50;
		}
		else if (this.currentSpeed>m) {
			currentSpeed=m;
			maxSpeed=m;
		}
		else{
			maxSpeed=m;
		}
		
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	
	public int getCurrentSpeed() {
		return this.currentSpeed;
	}
	

	
	public String toString() {
		return ("aircraft: speed= "+currentSpeed+", maxSpeed= "+maxSpeed);
	}
	public boolean equals(Object o) {
		if (!(o instanceof Aircraft)) {
			return false;
		}
		else {
			return (((Aircraft)o).getMaxSpeed()==this.maxSpeed && ((Aircraft)o).getCurrentSpeed()==this.currentSpeed);
		}
		
		
	}
}
