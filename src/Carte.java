import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Carte {

	private String imgCarte; // face de la carte
	private String img; // dos de la carte

	public Carte() {
		
		img = "/res/pokemon.png";

		if (Grille.difficulte == 2) {
			img = "/res/pokemonDiff.png";
		}
		if (Grille.choixTheme == 2) {
			if (Grille.difficulte == 2) {
				img = "/res/avengersDiff.png";
			} else
				img = "/res/avengers.png";
		}
	}

	public Carte(String imgCarte) {
		this.imgCarte = imgCarte;
		img = "/res/pokemon.png";

		if (Grille.difficulte == 2) {
			img = "/res/pokemonDiff.png";
		}

		if (Grille.choixTheme == 2) {
			if (Grille.difficulte == 2) {
				img = "/res/avengersDiff.png";
			} else
				img = "/res/avengers.png";
		}
	}

	public String getImg() {
		return img;
	}

	public void setImage(String img) {
		this.img = img;
	}

	public String getimgCarte() {
		return imgCarte;
	}

	public void setimgCarte(String imgCarte) {
		this.imgCarte = imgCarte;
	}
}