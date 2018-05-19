public class Controller {
	private Thrower dad;
	private Frizz frizz;

	public Controller(Thrower thrower, Frizz frizz) {
		this.dad = thrower;
		this.frizz = frizz;
	}

	public void keyboard() {
		//Throwing
		if(StdDraw.isKeyPressed(32)) {
			if(this.dad.getHasFrizz()) {
				this.dad.tossFrizz();
			} 
		} if (StdDraw.isKeyPressed(82)) {
			this.dad.reset();
			this.frizz.reset();
		}
	}

	public void update() {
		this.keyboard();
	}

}