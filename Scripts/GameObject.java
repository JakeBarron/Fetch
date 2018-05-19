public class GameObject {

	public double x;
	public double y;
	private int width;
	private int height;
	private String image;

	private double homeX;
	private double homeY;

	public GameObject(double x, double y, int width, int height, String image) {
		this.x = this.homeX = x;
		this.y = this.homeY = y;
		this.width = width;
		this.height = height;
		this.image = image;
	}

	public void draw() {
		double screenX = x + width/2;
		double screenY = y + height/2;
		StdDraw.picture(screenX, screenY, image, width, height);
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void reset() {
		this.x = this.homeX;
		this.y = this.homeY;
	}

}