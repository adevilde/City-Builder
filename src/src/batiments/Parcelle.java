package src.batiments;

import src.carte.*;

public class Parcelle {

	private Carte carte;
	private Case coin1;		//Case du coin supérieur gauche de la parcelle
	private Case coin2;		//Case du coin inférieur droit de la parcelle

	public Parcelle(Case coin1, Case coin2, Carte carte) {
		this.coin1 = coin1;
		this.coin2 = coin2;
		this.carte = carte;
	}

	public boolean contient(Case kase) {
		return kase.getX() > this.coin1.getX() && kase.getX() < this.coin2.getX()
		       && kase.getY() > this.coin1.getY() && kase.getY() < this.coin2.getY();
	}

	public Case getCoin1() {
		return this.coin1;
	}

	public Case getCoin2() {
		return this.coin2;
	}

	public void setCoin1(Case coin) {
		this.coin1 = coin;
	}

	public void setCoin2(Case coin) {
		this.coin2 = coin;
	}

	public int largeur() {
		return this.coin2.getX() - this.coin1.getX();
	}

	public int hauteur() {
		return this.coin2.getY() - this.coin1.getY();
	}

	public int superficie() {
		return this.largeur() * this.hauteur();
	}

	public Case[] getCases() {
		Case[] cases = new Case[this.superficie()];
		for (int i = 0; i < this.coin2.getX() - this.coin1.getX(); i++) {
			for (int j = 0; j < this.coin2.getY() - this.coin1.getY(); j++) {
				cases[i + j * largeur()] = carte.getCase(i + this.coin1.getX(), j + this.coin2.getY());
			}
		}
		return cases;
	}

}

