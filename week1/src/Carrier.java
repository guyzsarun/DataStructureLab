
public class Carrier {
	private Aircraft[] ac;
	
	public Carrier() {
		ac=new Aircraft[5];
	}
	
	public Carrier(Aircraft a[]) {
		ac=new Aircraft[a.length];
		for (int i=0;i<a.length;i++) {
			a[i].setCurrentSpeed(0);
			this.ac[i]=a[i];
		}
	}
	
	public Aircraft[] getCrafts() {
		return this.ac;
	}
	
	public boolean planeLand(Aircraft p) {
		for (int i=0; i<this.ac.length; i++) {
			  if (ac[i] == null) {
				ac[i]=p;
				p.setCurrentSpeed(0);
			    return true;
			  }
			  
			}
		return false;
	}
	public boolean planeTakeoff(Aircraft p) {
		for (int i=0;i<this.ac.length;i++) {
			if (ac[i]==p) {
				ac[i]=null;
				p.setCurrentSpeed(10);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String s="";
		
		for (int i=0;i<this.ac.length;i++){
			if (ac[i] != null)
				s=s+"aircraft: speed= "+this.ac[i].getCurrentSpeed()+", maxspeed= "+this.ac[i].getMaxSpeed()+"\n";
		 }
		return s;
		
	}
	
}
