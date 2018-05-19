public class Scene {

	private static final int CWIDTH = 1200;
	private static final int CHEIGHT = 600;
	private static final int FLOORHEIGHT = 400;

	private GameObject background;
	private Dog Roux;
	private Frizz frizz;
	private Thrower Dad;

	public Scene() {
		int width = CWIDTH;
		int height = CHEIGHT;

		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(width, height);
		StdDraw.setXscale(0.0, width);
		StdDraw.setYscale(height, 0.0);
		
		this.background = new GameObject(0, 0, width, height, "../Assets/testScene.png");
		this.Roux = new Dog(CWIDTH/3, CHEIGHT*2/3);
		this.frizz = new Frizz(CWIDTH/4+25, CHEIGHT*2/3);
		this.Dad = new Thrower(CWIDTH/4, CHEIGHT*2/3);

		//Give dad frizz when initializing scene
		this.Dad.giveFrizz(frizz);

	}

	public void update() {
		this.frizz.update();
	}

	public void draw() {
		background.draw();
		Roux.draw();
		Dad.draw();
		frizz.draw();
	}

	public Thrower getThrower() {
		return this.Dad;
	}

	public Frizz getFrizz() {
		return this.frizz;
	}

	public static int getFloorHeight() {
		return FLOORHEIGHT;
	}

	public static int getHeight() {
		return CHEIGHT;
	}
}