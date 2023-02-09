import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Grille {

	private Carte[][] grille = new Carte[4][4];
	private Carte[][] grilleDiff = new Carte[6][6];
	static int cptTentatives = 0;
	static int record;
	static int nbJ = 0; // nombre de joueurs
	static int choixTheme = 0; 
	static int difficulte = 0;
	static int init = 0; // variable seulement pour entrer 1 seule fois dans un if dans méthode dessiner
	static int init2 = 0;
	
	int scoreJ1 = 0;
	int scoreJ2 = 0;

	// Constructeur qui permet de générer une grille 4x4 Pokemon ( mode de base )
	public Grille() throws SlickException {

		int cptCarte = 0;

		while (cptCarte != 16) {
			int i = (int) (Math.random() * 4);
			int j = (int) (Math.random() * 4);

			if (grille[i][j] == null) {
				cptCarte++;
				String img = null;

				switch (cptCarte) {
				case 1:
					img = "/res/azumarill.png";
					break;
				case 2:
					img = "/res/azumarill.png";
					break;
				case 3:
					img = "/res/carapuce.png";
					break;
				case 4:
					img = "/res/carapuce.png";
					break;
				case 5:
					img = "/res/croco.png";
					break;
				case 6:
					img = "/res/croco.png";
					break;
				case 7:
					img = "/res/evoli.png";
					break;
				case 8:
					img = "/res/evoli.png";
					break;
				case 9:
					img = "/res/luxio.png";
					break;
				case 10:
					img = "/res/luxio.png";
					break;
				case 11:
					img = "/res/mew.png";
					break;
				case 12:
					img = "/res/mew.png";
					break;
				case 13:
					img = "/res/pikachu.png";
					break;
				case 14:
					img = "/res/pikachu.png";
					break;
				case 15:
					img = "/res/rondoudou.png";
					break;
				case 16:
					img = "/res/rondoudou.png";
					break;
				}
				grille[i][j] = new Carte(img);
			}
		}

	}

	// Méthode qui permet de générer une grille 6x6 Pokemon si le mode difficile est choisi par l'utilisateur
	public void difficile() {
		int cptCarte2 = 0;

		while (cptCarte2 != 36) {
			int i = (int) (Math.random() * 6);
			int j = (int) (Math.random() * 6);

			if (grilleDiff[i][j] == null) {
				cptCarte2++;
				String img2 = null;

				switch (cptCarte2) {
				case 1:
					img2 = "/res/azumarillDiff.png";
					break;
				case 2:
					img2 = "/res/azumarillDiff.png";
					break;
				case 3:
					img2 = "/res/carapuceDiff.png";
					break;
				case 4:
					img2 = "/res/carapuceDiff.png";
					break;
				case 5:
					img2 = "/res/crocoDiff.png";
					break;
				case 6:
					img2 = "/res/crocoDiff.png";
					break;
				case 7:
					img2 = "/res/evoliDiff.png";
					break;
				case 8:
					img2 = "/res/evoliDiff.png";
					break;
				case 9:
					img2 = "/res/luxioDiff.png";
					break;
				case 10:
					img2 = "/res/luxioDiff.png";
					break;
				case 11:
					img2 = "/res/mewDiff.png";
					break;
				case 12:
					img2 = "/res/mewDiff.png";
					break;
				case 13:
					img2 = "/res/pikachuDiff.png";
					break;
				case 14:
					img2 = "/res/pikachuDiff.png";
					break;
				case 15:
					img2 = "/res/rondoudouDiff.png";
					break;
				case 16:
					img2 = "/res/rondoudouDiff.png";
					break;
				case 17:
					img2 = "/res/hypoDiff.png";
					break;
				case 18:
					img2 = "/res/hypoDiff.png";
					break;
				case 19:
					img2 = "/res/bulbizarreDiff.png";
					break;
				case 20:
					img2 = "/res/bulbizarreDiff.png";
					break;
				case 21:
					img2 = "/res/arbokDiff.png";
					break;
				case 22:
					img2 = "/res/arbokDiff.png";
					break;
				case 23:
					img2 = "/res/barbichaDiff.png";
					break;
				case 24:
					img2 = "/res/barbichaDiff.png";
					break;
				case 25:
					img2 = "/res/chenipanDiff.png";
					break;
				case 26:
					img2 = "/res/chenipanDiff.png";
					break;
				case 27:
					img2 = "/res/feurissonDiff.png";
					break;
				case 28:
					img2 = "/res/feurissonDiff.png";
					break;
				case 29:
					img2 = "/res/noctaliDiff.png";
					break;
				case 30:
					img2 = "/res/noctaliDiff.png";
					break;
				case 31:
					img2 = "/res/papillusionDiff.png";
					break;
				case 32:
					img2 = "/res/papillusionDiff.png";
					break;
				case 33:
					img2 = "/res/pichuDiff.png";
					break;
				case 34:
					img2 = "/res/pichuDiff.png";
					break;
				case 35:
					img2 = "/res/sabeletteDiff.png";
					break;
				case 36:
					img2 = "/res/sabeletteDiff.png";
					break;
				}
				grilleDiff[i][j] = new Carte(img2);
			}
		}
	}

	// Méthode qui permet de générer une grille 4x4 ouv 6x6 Aengers selon le choix
	// de l'utilisateur
	public void avengers() {
		if (Grille.difficulte == 1) {
			for (int i = 0; i < grille.length; i++) {
				for (int j = 0; j < grille[i].length; j++) {
					grille[i][j] = null;
				}
			}
			int cptCarte = 0;

			while (cptCarte != 16) {
				int i = (int) (Math.random() * 4);
				int j = (int) (Math.random() * 4);

				if (grille[i][j] == null) {

					cptCarte++;
					String img = null;

					switch (cptCarte) {
					case 1:
						img = "/res/Captain.png";
						break;
					case 2:
						img = "/res/Captain.png";
						break;
					case 3:
						img = "/res/blackWidow.png";
						break;
					case 4:
						img = "/res/blackWidow.png";
						break;
					case 5:
						img = "/res/hawkeye.png";
						break;
					case 6:
						img = "/res/hawkeye.png";
						break;
					case 7:
						img = "/res/hulk.png";
						break;
					case 8:
						img = "/res/hulk.png";
						break;
					case 9:
						img = "/res/ironMan.png";
						break;
					case 10:
						img = "/res/ironMan.png";
						break;
					case 11:
						img = "/res/spiderMan.png";
						break;
					case 12:
						img = "/res/spiderMan.png";
						break;
					case 13:
						img = "/res/thanos.png";
						break;
					case 14:
						img = "/res/thanos.png";
						break;
					case 15:
						img = "/res/thor.png";
						break;
					case 16:
						img = "/res/thor.png";
						break;
					}
					grille[i][j] = new Carte(img);
				}

			}
		} else {
			if (Grille.difficulte == 2) {
				for (int i = 0; i < grilleDiff.length; i++) {
					for (int j = 0; j < grilleDiff[i].length; j++) {
						grilleDiff[i][j] = null;
					}
				}
				int cptCarte = 0;

				while (cptCarte != 36) {
					int i = (int) (Math.random() * 6);
					int j = (int) (Math.random() * 6);

					if (grilleDiff[i][j] == null) {

						cptCarte++;
						String img = null;

						switch (cptCarte) {
						case 1:
							img = "/res/CaptainDiff.png";
							break;
						case 2:
							img = "/res/CaptainDiff.png";
							break;
						case 3:
							img = "/res/blackWidowDiff.png";
							break;
						case 4:
							img = "/res/blackWidowDiff.png";
							break;
						case 5:
							img = "/res/hawkeyeDiff.png";
							break;
						case 6:
							img = "/res/hawkeyeDiff.png";
							break;
						case 7:
							img = "/res/hulkDiff.png";
							break;
						case 8:
							img = "/res/hulkDiff.png";
							break;
						case 9:
							img = "/res/ironManDiff.png";
							break;
						case 10:
							img = "/res/ironManDiff.png";
							break;
						case 11:
							img = "/res/spiderManDiff.png";
							break;
						case 12:
							img = "/res/spiderManDiff.png";
							break;
						case 13:
							img = "/res/thanosDiff.png";
							break;
						case 14:
							img = "/res/thanosDiff.png";
							break;
						case 15:
							img = "/res/thorDiff.png";
							break;
						case 16:
							img = "/res/thorDiff.png";
							break;
						case 17:
							img = "/res/blackPanthereDiff.png";
							break;
						case 18:
							img = "/res/blackPanthereDiff.png";
							break;
						case 19:
							img = "/res/captainMarvelDiff.png";
							break;
						case 20:
							img = "/res/captainMarvelDiff.png";
							break;
						case 21:
							img = "/res/deadpoolDiff.png";
							break;
						case 22:
							img = "/res/deadpoolDiff.png";
							break;
						case 23:
							img = "/res/drStrangeDiff.png";
							break;
						case 24:
							img = "/res/drStrangeDiff.png";
							break;
						case 25:
							img = "/res/gamoraDiff.png";
							break;
						case 26:
							img = "/res/gamoraDiff.png";
							break;
						case 27:
							img = "/res/grootDiff.png";
							break;
						case 28:
							img = "/res/grootDiff.png";
							break;
						case 29:
							img = "/res/lokiDiff.png";
							break;
						case 30:
							img = "/res/lokiDiff.png";
							break;
						case 31:
							img = "/res/rocketDiff.png";
							break;
						case 32:
							img = "/res/rocketDiff.png";
							break;
						case 33:
							img = "/res/visionDiff.png";
							break;
						case 34:
							img = "/res/visionDiff.png";
							break;
						case 35:
							img = "/res/antManDiff.png";
							break;
						case 36:
							img = "/res/antManDiff.png";
							break;
						}
						grilleDiff[i][j] = new Carte(img);
					}

				}
			}
		}
	}

	// Méthode permettant de dessiner les images de "choix" ainsi que la grille
	public void dessiner(Graphics g) throws SlickException {

		g.drawImage(new Image("/res/choixTheme.png"), 0, 0);

		if (Grille.choixTheme != 0) {
			g.clear();
			g.drawImage(new Image("/res/choixJoueur.png"), 0, 0);

		}
		if (Grille.nbJ != 0 && Grille.choixTheme != 0) {
			g.clear();
			g.drawImage(new Image("/res/choixDifficulte.png"), 0, 0);
		}

		if (Grille.nbJ != 0 && Grille.choixTheme != 0 && Grille.difficulte != 0) {

			g.clear();

			if (Grille.choixTheme == 2 && init == 0) {
				init++;
				avengers();
			}
			if (Grille.difficulte == 2 && init2 == 0 && Grille.choixTheme == 1) {
				init2++;
				difficile();
			}

			if (Grille.difficulte == 2) {
				for (int i = 0; i < grilleDiff.length; i++) {
					for (int j = 0; j < grilleDiff[i].length; j++) {

						g.drawImage(new Image(grilleDiff[i][j].getImg()), i * 137 + 5, j * 137 + 5);
					}
				}
			} else
				for (int i = 0; i < grille.length; i++) {
					for (int j = 0; j < grille[i].length; j++) {

						g.drawImage(new Image(grille[i][j].getImg()), i * 205 + 5, j * 205 + 5);

					}
				}
		}
	}

	// Méthode permettant de comparer récupérer quels cartes ont était retourné et
	// de les comparer pour mode normal/difficile et multijoueur
	public void retourner() {

		int cptX1 = -1;
		int cptX2 = -1;
		int cptY1 = -1;
		int cptY2 = -1;

		if (Grille.choixTheme == 2 && Grille.difficulte == 1) {
			// On regarde dans toute la grille quel cartes ne sont pas de dos ou noir (retourné)=> affectation i,j au variable
			for (int i = 0; i < grille.length; i++) {

				for (int j = 0; j < grille[i].length; j++) {

					if (!(grille[i][j].getImg().equals("/res/avengers.png"))
							&& !(grille[i][j].getImg().equals("/res/black.jpg"))) {

						if (cptX1 != -1) {
							cptX2 = i;
							cptY2 = j;
						} else {
							cptX1 = i;
							cptY1 = j;
						}

					}

				}
			}
		} else if (Grille.choixTheme == 1 && Grille.difficulte == 1) {

			for (int i = 0; i < grille.length; i++) {

				for (int j = 0; j < grille[i].length; j++) {

					if (!(grille[i][j].getImg().equals("/res/pokemon.png"))
							&& !(grille[i][j].getImg().equals("/res/black.jpg"))) {
						if (cptX1 != -1) {
							cptX2 = i;
							cptY2 = j;
						} else {
							cptX1 = i;
							cptY1 = j;
						}

					}

				}
			}
		}
		if (Grille.difficulte == 2 && Grille.choixTheme == 1) {
			for (int i = 0; i < grilleDiff.length; i++) {

				for (int j = 0; j < grilleDiff[i].length; j++) {

					if (!(grilleDiff[i][j].getImg().equals("/res/pokemonDiff.png"))
							&& !(grilleDiff[i][j].getImg().equals("/res/blackDiff.jpg"))) {
						if (cptX1 != -1) {
							cptX2 = i;
							cptY2 = j;
						} else {
							cptX1 = i;
							cptY1 = j;
						}

					}

				}
			}
		}
		if (Grille.difficulte == 2 && Grille.choixTheme == 2) {
			for (int i = 0; i < grilleDiff.length; i++) {

				for (int j = 0; j < grilleDiff[i].length; j++) {

					if (!(grilleDiff[i][j].getImg().equals("/res/avengersDiff.png"))
							&& !(grilleDiff[i][j].getImg().equals("/res/blackDiff.jpg"))) {
						if (cptX1 != -1) {
							cptX2 = i;
							cptY2 = j;
						} else {
							cptX1 = i;
							cptY1 = j;
						}

					}

				}
			}
		}
		if (cptX1 != -1 && cptX2 != -1 && Grille.choixTheme != 0 && Grille.nbJ != 0 && Grille.difficulte != 0) {
			try {
				Thread.sleep(400);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (Grille.difficulte == 2) {
				//Comparaison des 2 cartes retourné pour mode difficile011111111111
				if (grilleDiff[cptX1][cptY1].getImg().equals(grilleDiff[cptX2][cptY2].getImg())) {
					grilleDiff[cptX1][cptY1].setImage("/res/blackDiff.jpg");
					grilleDiff[cptX2][cptY2].setImage("/res/blackDiff.jpg");
					// pour 2 joueurs : savoir a qui le tour de jouer
					if (nbJ == 2) {
						if (cptTentatives % 2 == 0) {
							this.scoreJ1++;
							cptTentatives--; // Pour rejouer lorsque l'on trouve la bonne carte
						} else {
							this.scoreJ2++;
							cptTentatives--;
						}
					}
				}
				cptTentatives++;
				
				//si carte pas toruvé alors les remettre face caché 
				for (int i = 0; i < grilleDiff.length; i++) {
					for (int j = 0; j < grilleDiff[i].length; j++) {
						if (!(grilleDiff[i][j].getImg().equals("/res/blackDiff.jpg"))) {
							if (Grille.choixTheme == 2)
								grilleDiff[i][j].setImage("/res/avengersDiff.png");
							else
								grilleDiff[i][j].setImage("/res/pokemonDiff.png");

						}
					}

				}
			} else {
				if (grille[cptX1][cptY1].getImg().equals(grille[cptX2][cptY2].getImg())) {
					grille[cptX1][cptY1].setImage("/res/black.jpg");
					grille[cptX2][cptY2].setImage("/res/black.jpg");
					if (nbJ == 2) {
						if (cptTentatives % 2 == 0) {
							this.scoreJ1++;
							cptTentatives--;
						} else {
							this.scoreJ2++;
							cptTentatives--;
						}
					}
				}
				cptTentatives++;

				for (int i = 0; i < grille.length; i++) {
					for (int j = 0; j < grille[i].length; j++) {
						if (!(grille[i][j].getImg().equals("/res/black.jpg"))) {
							if (Grille.choixTheme == 2)
								grille[i][j].setImage("/res/avengers.png");
							else
								grille[i][j].setImage("/res/pokemon.png");

						}
					}

				}
			}
		}
	}

	public int getScoreJ1() {
		return scoreJ1;
	}

	public int getScoreJ2() {
		return scoreJ2;
	}

	// Méthode permettant de retourner les cartes cliqué si elles n'ont pas deja été trouvé ou retourné
	public void CarteCliquer(int x, int y) {

		int resX = -1;
		int resY = -1;
		if (Grille.difficulte == 2) {
			for (int i = 0; i < 6; i++) {
				// permet de récuperer numéro colonne et ligne selon l'endroit où on clique
				if (x > 5 + 137 * i && x < 137 + 137 * i) {
					resX = i;
				}
				if (y > 5 + 137 * i && y < 137 + 137 * i) {
					resY = i;
				}
				// Si carte != noir et égale alors les retourner
				if (resX != -1 && resY != -1 && !(grilleDiff[resX][resY].getImg().equals("/res/blackDiff.jpg"))) {
					grilleDiff[resX][resY].setImage(grilleDiff[resX][resY].getimgCarte());
				}

			}
		} else {
			for (int i = 0; i < 4; i++) {

				if (x > 5 + 205 * i && x < 205 + 205 * i) {
					resX = i;
				}
				if (y > 5 + 205 * i && y < 205 + 205 * i) {
					resY = i;
				}

				if (resX != -1 && resY != -1 && !(grille[resX][resY].getImg().equals("/res/black.jpg"))) {
					grille[resX][resY].setImage(grille[resX][resY].getimgCarte());
				}

			}
		}
	}

	// Parcours toute la grille et si toutes les cartes sont noir retourne true sinon false
	public boolean gagner() {

		boolean gagner = true;
		if (Grille.difficulte == 2) {
			for (int i = 0; i < grilleDiff.length; i++) {
				for (int j = 0; j < grilleDiff[i].length; j++) {

					if (!(grilleDiff[i][j].getImg().equals("/res/blackDiff.jpg"))) {
						gagner = false;
					}

				}
			}
		} else {
			for (int i = 0; i < grille.length; i++) {
				for (int j = 0; j < grille[i].length; j++) {

					if (!(grille[i][j].getImg().equals("/res/black.jpg"))) {
						gagner = false;
					}

				}
			}
		}
		return gagner;
	}

}
