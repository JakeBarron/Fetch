public class Physics {
	private int speed;
	private double gravity;
	private double drag;
	private double terminal;
	private double velocityX;
	private double velocityY;
	private boolean isGrounded;

	public Physics(int speed) {
		this.speed = speed;
		this.drag = 0.1;
		this.gravity = 0.2;
		this.terminal = 8;
		this.velocityX = 0.0;
		this.velocityY = 0.0;
		this.isGrounded = true;
	}

	public double getVelocityX() {
		return this.velocityX;
	}

	public double getVelocityY() {
		return this.velocityY;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public void land() {
		this.velocityY = 0;
		this.isGrounded = true;
	}

	public void applyGravity() {
		if (velocityY < terminal && !this.isGrounded) {
			velocityY += gravity;
		}
	}

	public void applyDrag() {
		if(velocityX > 0.5) {
			this.velocityX -= this.drag;
		} else if(velocityX < -0.5) {
			this.velocityX += this.drag;
		}
		else {
			this.velocityX = 0;
		}
	}

	public void toss(int strength) {
		this.isGrounded = false;
		this.velocityY = -speed - strength;
		this.velocityX = speed*strength;
	}

	public void update() {
		this.applyGravity();
		this.applyDrag();
	}
}