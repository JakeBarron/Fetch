public class Dog extends GameObject {

	private static String sprite = "../Assets/testDog.png";
	private static final int WIDTH = 120;
	private static final int HEIGHT = 60;

	private Physics physics;
	private boolean hasFrizz;

	public Dog(double x, double y) {
		super(x-(0.5*WIDTH), y-(0.5*HEIGHT), WIDTH, HEIGHT, sprite);
		this.physics = new Physics(4);
	}

	public void move() {
		double dx = this.getX() + physics.getVelocityX();
		double dy = this.getY() + physics.getVelocityY();
		super.move(dx, dy);
	}

	public void update() {
		physics.update();
		this.move();
	}

	public boolean hasFrizz() {
		return this.hasFrizz;
	}
}