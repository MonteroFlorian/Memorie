import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MainProjetB {

	public static void main(String[] args) throws SlickException {
		// TODO Auto-generated method stub
		BasicGame monJeu = new BasicGame("Jeu du memory");
		AppGameContainer app = new AppGameContainer(monJeu);
		app.setDisplayMode(1100, 825, false);
		app.start();

	}

}
