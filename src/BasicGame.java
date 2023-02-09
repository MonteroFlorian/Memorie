import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BasicGame extends org.newdawn.slick.BasicGame {

	Grille gr;

	public BasicGame(String title) throws SlickException {
		super(title);
		gr = new Grille();

		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {

		// Lire le record dans les fichiers .txt
		
		if (Grille.nbJ == 1 && Grille.difficulte == 1) {
			try {
				BufferedReader r = new BufferedReader(new FileReader("record.txt"));
				String val;
				try {
					val = r.readLine();
					Grille.record = Integer.valueOf(val);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (Grille.nbJ == 1 && Grille.difficulte == 2) {
			try {
				BufferedReader r = new BufferedReader(new FileReader("recordDiff.txt"));
				String val;
				try {
					val = r.readLine();
					Grille.record = Integer.valueOf(val);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		gr.dessiner(g);

		//Mise en page pour 1 joueur mode facile/difficile
		if (Grille.nbJ == 1 && Grille.difficulte != 0) {
			g.drawImage(new Image("/res/parchemin.png"), 823, 0);
			g.drawImage(new Image("/res/Rejouer.png"), 860, 570);
			g.setColor(Color.black);
			g.drawString("Nombre de coups : " + Grille.cptTentatives, 850, 100);
			g.drawString("Record : " + Grille.record, 850, 200);
			
		}
		
		//Mise en page pour 2 joueur mode facile/difficile
		
		if (Grille.nbJ == 2 && Grille.difficulte != 0) {
			g.drawImage(new Image("/res/parchemin.png"), 823, 0);
			g.drawImage(new Image("/res/Rejouer.png"), 860, 570);
			if (Grille.cptTentatives % 2 == 0) {
				g.setColor(Color.blue);
				g.drawString("Score joueur 1 : " + gr.getScoreJ1(), 830, 300);
				g.setColor(Color.black);
				g.drawString("Score joueur 2 : " + gr.getScoreJ2(), 830, 350);
			} else {
				g.setColor(Color.black);
				g.drawString("Score joueur 1 : " + gr.getScoreJ1(), 830, 300);
				g.setColor(Color.blue);
				g.drawString("Score joueur 2 : " + gr.getScoreJ2(), 830, 350);
			}
		}

		
		g.drawImage(new Image("/res/quitter.png"), 860, 680);

		// Gestion de la victoire
		
		if (gr.gagner() == true) {
			if (Grille.nbJ == 1) {
				g.drawImage(new Image("/res/Gagner.png"), 0, 0); // afficher image de victoire
				
				// Si record battu pour mode facile réecrire la valeur du fichier texte
				if (Grille.cptTentatives < Grille.record) {
					Grille.record = Grille.cptTentatives;
					g.drawString("Record : " + Grille.record, 830, 200);
					if (Grille.difficulte == 1) {
						//
						try {
							PrintWriter writer = new PrintWriter("record.txt", "UTF-8");
							writer.println(Grille.record);
							writer.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// Si record battu pour mode difficile réecrire la valeur du fichier texte
					if (Grille.difficulte == 2) {
						try {
							PrintWriter writer = new PrintWriter("recordDiff.txt", "UTF-8");
							writer.println(Grille.record);
							writer.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			// Mise en page pour le mode 2 joueurs
			if (Grille.nbJ == 2) {
				if (gr.getScoreJ1() > gr.getScoreJ2()) {
					g.drawImage(new Image("/res/GagnerJ1.png"), 0, 0);
				} else if (gr.getScoreJ2() > gr.getScoreJ1()) {
					g.drawImage(new Image("/res/GagnerJ2.png"), 0, 0);
				} else
					g.drawImage(new Image("/res/Egalite.png"), 0, 0);
			}
		}

	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GameContainer gc, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		Input input = gc.getInput();

		gr.retourner();

		// Gestion du clic 
		if (input.isMousePressed(input.MOUSE_LEFT_BUTTON)) {
			if (Grille.nbJ != 0 && Grille.choixTheme != 0 && Grille.difficulte != 0) {
				gr.CarteCliquer(input.getMouseX(), input.getMouseY());
			}

				if (input.getMouseX() > 860 && input.getMouseX() < 1060 && input.getAbsoluteMouseY() > 570
						&& input.getAbsoluteMouseY() < 670) {
					gr = new Grille();
					Grille.init=0;
					Grille.init2=0;
					Grille.choixTheme=0;
					Grille.difficulte=0;
					Grille.nbJ=0;
					Grille.cptTentatives=0;	
					gr.scoreJ1=0;
					gr.scoreJ2=0;
					
					
					}
			
			if (input.getMouseX() > 860 && input.getMouseX() < 1060 && input.getAbsoluteMouseY() > 680
					&& input.getAbsoluteMouseY() < 780) {
				gc.exit();
				
			}
			if (Grille.choixTheme == 0) {
				if (input.getMouseX() > 240 && input.getMouseX() < 824 && input.getAbsoluteMouseY() > 274
						&& input.getAbsoluteMouseY() < 456) {
					Grille.choixTheme = 1;
				}
				if (input.getMouseX() > 240 && input.getMouseX() < 824 && input.getAbsoluteMouseY() > 500
						&& input.getAbsoluteMouseY() < 680) {
					Grille.choixTheme = 2;
				}
			} else if (Grille.nbJ == 0) {
				if (input.getMouseX() > 240 && input.getMouseX() < 824 && input.getAbsoluteMouseY() > 274
						&& input.getAbsoluteMouseY() < 456) {
					Grille.nbJ = 1;
				}
				if (input.getMouseX() > 240 && input.getMouseX() < 824 && input.getAbsoluteMouseY() > 500
						&& input.getAbsoluteMouseY() < 680) {
					Grille.nbJ = 2;
				}
			} else if (Grille.difficulte == 0) {
				if (input.getMouseX() > 240 && input.getMouseX() < 824 && input.getAbsoluteMouseY() > 274
						&& input.getAbsoluteMouseY() < 456) {
					Grille.difficulte = 1;
				}
				
				
				if (input.getMouseX() > 240 && input.getMouseX() < 824 && input.getAbsoluteMouseY() > 500
						&& input.getAbsoluteMouseY() < 680) {
					Grille.difficulte = 2;
				}
			}
		}

	}

}