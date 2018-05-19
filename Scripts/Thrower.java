public class Thrower extends GameObject {
	private static String sprite = "../Assets/testThrower.png";
	private static final int WIDTH = 50;
	private static final int HEIGHT = 100;

	private Physics physics;
	private boolean hasFrizz;
	private Frizz frizz;

	public Thrower(double x, double y) {
		super(x-(0.5*WIDTH), y-(0.5*HEIGHT), WIDTH, HEIGHT, sprite);
		this.physics = new Physics(0);
		this.frizz = frizz;
		this.hasFrizz = false;
	}

	public void tossFrizz() {
		if(this.hasFrizz) {
			this.frizz.toss(1);
			this.hasFrizz = false;
		}
	}

	public void giveFrizz(Frizz frizz) {
		this.frizz = frizz;
		this.hasFrizz = true;
	}

	public boolean getHasFrizz() {
		return this.hasFrizz;
	}

	public void reset() {
		this.hasFrizz = true;
	}

}