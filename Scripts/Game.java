/**
	Fetch
	Play fetch with my Dad, Mike, and my Dog, Roux.

	In loving memory of Michael Barron and Roux Barron
**/

public class Game {

	private static boolean isOver;
	private Scene scene;
	private Controller controller;

	public Game() {
		isOver = false;
		this.scene = new Scene();
		Thrower thrower = scene.getThrower();
		Frizz frizz = scene.getFrizz();
		this.controller = new Controller(thrower, frizz);
	}

	public void update() {
		//game update code
		controller.update();
		scene.update();
	}

	public void render() {
		//game draw code
		scene.draw();
		StdDraw.show(10);
	}

	public static void main(String[] args) {
		Game game = new Game();

		while(game.isOver == false) {
			game.update();
			game.render();
		}
	}

}