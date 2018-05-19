public class Frizz extends GameObject {
	private static String sprite = "../Assets/testFrisbee.png";
	private static final int WIDTH = 20;
	private static final int HEIGHT = 10;

	private Physics physics;
	private boolean isTossed;
	private double ground;

	public Frizz(double x, double y) {
		super(x-(0.5*WIDTH), y-(0.5*HEIGHT), WIDTH, HEIGHT, sprite);
		this.physics = new Physics(10);
		this.isTossed = false;
	}

	public void toss(int strength) {
		if (!this.isTossed) {
			physics.toss(strength);
			this.isTossed = true;
			this.generateGround();
			// System.out.println("ground: " + this.ground);
		}
	}

	public void move() {
		double dx = this.getX() + this.physics.getVelocityX();
		double dy = this.getY() + this.physics.getVelocityY();
		super.move(dx,dy);
	}

	public boolean isTouchingX(GameObject gameObject, double ratio) {
		double overlap = this.getWidth() * ratio;
		return ( Math.abs(this.getX()-gameObject.getX() ) < overlap);
	}

	public boolean isTouchingY(GameObject gameObject, double ratio) {
		double overlap = this.getHeight() * ratio;
		return ( Math.abs( this.getY()- gameObject.getY() ) < overlap);
	}

	private void generateGround() {
		this.ground = Math.random() * (Scene.getHeight()-Scene.getFloorHeight()) + Scene.getFloorHeight() - 25;
	}

	public void checkLanded() {
		//System.out.println("Checking. Y = " + super.getY());
		if(super.getY() > this.ground) {
			this.isTossed = false;
			this.physics.land();
		}
	}

	public void update() {
		if(isTossed) {
			this.checkLanded();
			physics.update();
			this.move();
		}
	}

	public boolean getIsTossed() {
		return this.isTossed;
	}

	public void reset() {
		System.out.printf("Frizz(X: %f, Y: %f, velocityX: %f, velocityY: %f)", super.getX(), super.getY(), this.physics.getVelocityX(), this.physics.getVelocityY());
		super.reset();
		this.isTossed = false;
	}
} //end Frizz